package com.wizz.sentencelib.controller;

import com.wizz.sentencelib.model.RelationResponse;
import com.wizz.sentencelib.service.CollectionRelationService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author seenline
 * @data 2021/8/9 11:32
 * @description 这个接口和CollectionRelationController共用，因为原接口的设计的返回json过于复杂，和前端沟通后增加该接口完成需求
 */

@RestController
public class HelpThirdController {
    @Autowired
    private CollectionRelationService2 collectionRelationService2;
    @RequestMapping("/relation2")
    public RelationResponse relation(@RequestParam(required = true)String uid) {
        RelationResponse relationResponse =new RelationResponse();
        relationResponse.setData((collectionRelationService2.relation(uid)));
        relationResponse.setResponseCode("200");
        relationResponse.setMessage("成功");
        System.out.println(relationResponse);
        return relationResponse;
    }

}
