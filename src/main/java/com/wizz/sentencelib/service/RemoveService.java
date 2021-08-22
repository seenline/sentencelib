package com.wizz.sentencelib.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wizz.sentencelib.beans.Collection;
import com.wizz.sentencelib.mapper.CollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemoveService {
    @Autowired
    private CollectionMapper collectionMapper;

    @Autowired
    private HeatActService heatActService;

    public boolean remove(String uid, Integer sid) {
        List<Collection> list = collectionMapper.selectList(new QueryWrapper<Collection>().and(i -> i.eq("uid", uid).eq("sid", sid)));
        if (list.isEmpty())
            return false;
        heatActService.reduce(sid);
        collectionMapper.delete(new QueryWrapper<Collection>().and(i -> i.eq("uid", uid).eq("sid", sid)));
        return true;
    }

}
