package com.wizz.sentencelib.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wizz.sentencelib.beans.CollectionRelation;
import com.wizz.sentencelib.mapper.CollectionRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author seenline
 * @data 2021/8/17 17:13
 * @description
 */
@Service
public class FriendService {
    @Autowired
    private CollectionRelationMapper collectionRelationMapper;
    public void add(String uid1,String uid2)
    {
        CollectionRelation tmp=collectionRelationMapper.selectOne(new QueryWrapper<CollectionRelation>().and(i->i.eq("uid",uid1).eq("otherId",uid2)));
        if (tmp==null)
            collectionRelationMapper.insert(new CollectionRelation().setUid(uid1).setOtherId(uid2));
    }
    public void delete(String uid1,String uid2)
    {
        collectionRelationMapper.delete(new QueryWrapper<CollectionRelation>().and(i->i.eq("uid",uid1).eq("otherId",uid2)));
    }
}
