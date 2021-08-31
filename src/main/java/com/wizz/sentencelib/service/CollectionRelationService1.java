package com.wizz.sentencelib.service;

import com.wizz.sentencelib.SelectResult.CollectionRelationResult1;
import com.wizz.sentencelib.mapper.CollectionRelationMapper;
import com.wizz.sentencelib.tool.Bean2Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author seenline
 * @date 2021/8/8 18:18
 * @description
 */
@Service
public class CollectionRelationService1 {
    @Autowired
    private CollectionRelationMapper collectionRelationMapper;

    public LinkedList<Object> collectionRelation(String uid)
    {
        List<CollectionRelationResult1>resultSelect=collectionRelationMapper.selectRelation(uid);
        LinkedList<Object>returnResult=new LinkedList<>();

        for (CollectionRelationResult1 collectionRelationResult1 : resultSelect) {
               returnResult.add(collectionRelationResult1);
        }
        return returnResult;
    }

}
