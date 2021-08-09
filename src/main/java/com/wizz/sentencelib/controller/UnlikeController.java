package com.wizz.sentencelib.controller;

import com.wizz.sentencelib.model.CommonResponse;
import com.wizz.sentencelib.service.RemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnlikeController {
    @Autowired
    private RemoveService removeService;

    @RequestMapping("/unlike")
    public CommonResponse unlike(@RequestParam(required = true) String uid,
                                 @RequestParam(required = true) int sid) {
        if (removeService.remove(uid, sid))
            return CommonResponse.SUCCESS;
        return CommonResponse.NOTFIND;
    }
}

