package com.wizz.sentencelib.controller;

import com.wizz.sentencelib.model.CommonResponse;
import com.wizz.sentencelib.model.FeedBackResponse;
import com.wizz.sentencelib.service.AskInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author seenline
 * @date 2021/8/11 12:15
 * @description 问题反馈
 */
@RestController
@RequestMapping("/feedback")
public class FeedBackController {
    @Autowired
    private AskInformationService askInformationService;

    FeedBackResponse feedBackResponse=new FeedBackResponse();
    @RequestMapping("/post")
    public CommonResponse post(@RequestParam(required = true) String uid,
                               @RequestParam(required = true) String content) {
        askInformationService.post(uid,content);
        return CommonResponse.SUCCESS;
    }

    @RequestMapping("/get")
    public FeedBackResponse get()
    {
        feedBackResponse.setResponseCode("200");
        feedBackResponse.setMessage("成功");
        feedBackResponse.getData().add(askInformationService.get());
        return feedBackResponse;
    }


}
