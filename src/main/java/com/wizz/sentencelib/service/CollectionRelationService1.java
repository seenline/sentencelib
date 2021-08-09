package com.wizz.sentencelib.service;

import com.wizz.sentencelib.SelectResult.CollectionRelationResult1;
import com.wizz.sentencelib.mapper.CollectionRelationMapper;
import com.wizz.sentencelib.tool.Bean2Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author seenline
 * @data 2021/8/8 18:18
 * @description
 */
@Service
public class CollectionRelationService1 {
    @Autowired
    private CollectionRelationMapper collectionRelationMapper;

    public LinkedHashMap<String,Object> collectionRelation(String uid)
    {
        List<CollectionRelationResult1>resultSelect=collectionRelationMapper.selectRelation(uid);
        LinkedHashMap<String,Object>returnResult=new LinkedHashMap<>();
        int cnt=1;
        for (CollectionRelationResult1 collectionRelationResult1 : resultSelect) {
                try {

                    returnResult.put("collectUser"+cnt, Bean2Map.bean2map(collectionRelationResult1));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                cnt++;

        }
        return returnResult;
    }

}
