package com.wizz.sentencelib.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author seenline
 * @data 2021/8/9 17:22
 * @description
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public String test()
    {
        return "部署成功";
    }
}
