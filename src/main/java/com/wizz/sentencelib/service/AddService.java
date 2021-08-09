package com.wizz.sentencelib.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wizz.sentencelib.beans.Collection;
import com.wizz.sentencelib.mapper.CollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class AddService {
    @Autowired
    private HeatActService heatActService;

    @Autowired
    private CollectionMapper collectionMapper;

    java.util.Date date = new java.util.Date();
    SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String simpleDate = temp.format(date);   //向数据库中放入当前具体时间，

    public Boolean add(String uid, int sid) {
        List<Collection> list = collectionMapper.selectList(new QueryWrapper<Collection>().and(i -> i.eq("uid", uid).eq("sid", sid)));
        if (!list.isEmpty())
            return false;
        heatActService.add(sid);
        collectionMapper.insert(new Collection().setUid(uid).setSid(sid).setDatetime(simpleDate));
        return true;
    }
}
