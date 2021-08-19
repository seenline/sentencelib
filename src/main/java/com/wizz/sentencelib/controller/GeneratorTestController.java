package com.wizz.sentencelib.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author seenline
 * @data 2021/8/18 12:59
 * @description
 */
@RestController
public class GeneratorTestController {
    @RequestMapping("/test")
    public String test()
    {
        return "success";
    }

}
