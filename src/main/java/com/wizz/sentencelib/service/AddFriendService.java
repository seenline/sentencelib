package com.wizz.sentencelib.service;

import com.wizz.sentencelib.beans.CollectionRelation;
import com.wizz.sentencelib.mapper.CollectionRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author seenline
 * @data 2021/8/17 17:13
 * @description
 */
@Service
public class AddFriendService {
    @Autowired
    private CollectionRelationMapper collectionRelationMapper;
    public void add(String uid1,String uid2)
    {
        collectionRelationMapper.insert(new CollectionRelation().setUid(uid1).setOtherId(uid2));
    }
}
