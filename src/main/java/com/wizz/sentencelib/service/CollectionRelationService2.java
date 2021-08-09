package com.wizz.sentencelib.service;

import com.wizz.sentencelib.SelectResult.CollectionRelationResult2;
import com.wizz.sentencelib.mapper.SentenceMapper;
import com.wizz.sentencelib.tool.Bean2Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author seenline
 * @data 2021/8/9 14:56
 * @description
 */
@Service
public class CollectionRelationService2 {
    @Autowired
    private SentenceMapper sentenceMapper;

    public LinkedList<Object> relation(String uid) {
        List<CollectionRelationResult2> resultSelect = sentenceMapper.selectFriendsCollection(uid);
        LinkedList<Object> returnResult = new LinkedList<>();
        for (CollectionRelationResult2 collectionRelationResult2 : resultSelect) {
            try {
                returnResult.add(Bean2Map.bean2map(collectionRelationResult2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return returnResult;
    }
}
