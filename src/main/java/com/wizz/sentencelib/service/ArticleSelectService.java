package com.wizz.sentencelib.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wizz.sentencelib.SelectResult.ArticleOutUserResult;
import com.wizz.sentencelib.SelectResult.ArticleWithUserResult;
import com.wizz.sentencelib.beans.Collection;
import com.wizz.sentencelib.beans.Sentence;
import com.wizz.sentencelib.mapper.CollectionMapper;
import com.wizz.sentencelib.mapper.SentenceMapper;
import com.wizz.sentencelib.tool.Bean2Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author seenline
 * @data 2021/8/4 14:16
 * @description
 */
@Service
public class ArticleSelectService {
    @Autowired
    private SentenceMapper sentenceMapper;
    @Autowired
    private CollectionMapper collectionMapper;

    public LinkedHashMap<String, Object> outUser(int page, String tag1, String tag2, String tag3, String tag4)
    {
        Page<Sentence>pageCondition=new Page<>();
        pageCondition.setSize(10);
        pageCondition.setCurrent(page);
        IPage<ArticleOutUserResult> resultPage=sentenceMapper.findPageListByHeat(pageCondition,new QueryWrapper<>(),tag1,tag2,tag3,tag4);
        List<ArticleOutUserResult>listResult=resultPage.getRecords();
        LinkedHashMap<String,Object>returnResult=new LinkedHashMap<>();
        int cnt=1;
        for (ArticleOutUserResult articleOutUserResult : listResult) {
            try {

                returnResult.put("sentence"+cnt, Bean2Map.bean2map(articleOutUserResult));
            } catch (Exception e) {
                e.printStackTrace();
            }
            cnt++;
        }
        return returnResult;
    }
    public LinkedHashMap<String, Object> withUser(int page,String uid)
    {
        Page<Collection>pageCondition=new Page<>();
        pageCondition.setSize(10);
        pageCondition.setCurrent(page);
        IPage<ArticleWithUserResult> resultPage=collectionMapper.findTest(pageCondition,uid);
        List<ArticleWithUserResult>listResult=resultPage.getRecords();
        LinkedHashMap<String,Object>returnResult=new LinkedHashMap<>();
        int cnt=1;
        for (ArticleWithUserResult articleWithUserResult : listResult) {
            try {

                returnResult.put("sentence"+cnt, Bean2Map.bean2map(articleWithUserResult));
            } catch (Exception e) {
                e.printStackTrace();
            }
            cnt++;
        }
        return returnResult;
    }
}
