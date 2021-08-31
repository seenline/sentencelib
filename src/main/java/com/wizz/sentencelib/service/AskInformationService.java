package com.wizz.sentencelib.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wizz.sentencelib.SelectResult.ArticleOutUserResult;
import com.wizz.sentencelib.beans.AskInformation;
import com.wizz.sentencelib.mapper.AskInformationMapper;
import com.wizz.sentencelib.tool.Bean2Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author seenline
 * @date 2021/8/11 12:17
 * @description
 */
@Service
public class AskInformationService {
    @Autowired
    private  AskInformationMapper askInformationMapper;

    public void post(String uid, String content)
    {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String simpleDate = temp.format(date);   //向数据库中放入当前具体时间，
        askInformationMapper.insert(new AskInformation().setContent(content).setUid(uid).setCreateTime(simpleDate));
    }

    public LinkedHashMap<String,Object> get()
    {
        List<AskInformation>listResult=askInformationMapper.selectList(new QueryWrapper<AskInformation>().orderByDesc("createtime"));
        LinkedHashMap<String,Object>returnResult=new LinkedHashMap<>();
        int cnt=1;
        for (AskInformation askInformation : listResult) {
            try {
                returnResult.put("feedback"+cnt, Bean2Map.bean2map(askInformation));
            } catch (Exception e) {
                e.printStackTrace();
            }
            cnt++;
        }
        return returnResult;
    }
}
