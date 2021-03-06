package com.wizz.sentencelib.controller;

import com.wizz.sentencelib.model.ArticleResponse;
import com.wizz.sentencelib.service.ArticleSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

/**
 * @author seenline
 * @date 2021/7/29 17:20
 * @description
 */
@RestController
public class ArticleController {
    @Autowired
    private ArticleSelectService articleSelectService;

    @RequestMapping("/sentence")
    public ArticleResponse sentence(@RequestParam(required = true) int page,
                                    @RequestParam(required = false)String uid,
                                    @RequestParam(required = false)String tag1,
                                    @RequestParam(required = false)String tag2,
                                    @RequestParam(required = false)String tag3,
                                    @RequestParam(required = false)String tag4){
        ArticleResponse articleResponse=new ArticleResponse();
        if(uid==null) {
            articleResponse.setData(articleSelectService.outUser(page,tag1,tag2,tag3,tag4));
        }
        else {
            articleResponse.setData(articleSelectService.withUser(page,uid));
        }
        articleResponse.setResponseCode("200");
        articleResponse.setMessage("成功");
        return articleResponse;

    }

}
