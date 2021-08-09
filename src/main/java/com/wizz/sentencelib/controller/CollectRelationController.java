package com.wizz.sentencelib.controller;

import com.wizz.sentencelib.model.RelationResponse;
import com.wizz.sentencelib.service.CollectionRelationService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

/**
 * @author seenline
 * @data 2021/8/8 18:15
 * @description 获取用户的收藏文案馆（也就是用户的好友）
 */
@RestController
public class CollectRelationController {
    @Autowired
    private CollectionRelationService1 collectionRelationService1;

    private RelationResponse relationResponse;
    @RequestMapping("/relation1")
    public RelationResponse getCollectionRelation(@RequestParam(required = true) String uid)
    {
        RelationResponse relationResponse =new RelationResponse();
        LinkedHashMap<String,Object>tmp=new LinkedHashMap<>();
        tmp= collectionRelationService1.collectionRelation(uid);
        relationResponse.getData().push(tmp);
        relationResponse.setResponseCode("200");
        relationResponse.setMessage("成功");
        System.out.println(relationResponse);
        return relationResponse;
    }

}
