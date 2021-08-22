package com.wizz.sentencelib.controller;

import com.wizz.sentencelib.model.CommonResponse;
import com.wizz.sentencelib.service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LIkeController {
    @Autowired
    private AddService addService;

    @RequestMapping("/like")
    public CommonResponse like(@RequestParam(required = true) String uid,
                               @RequestParam(required = true) Integer sid) {
        if (addService.add(uid, sid))
            return CommonResponse.SUCCESS;
        return CommonResponse.REPEAT;
    }
}
