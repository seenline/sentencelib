package com.wizz.sentencelib.controller;

import com.alibaba.fastjson.JSONObject;
import com.wizz.sentencelib.config.LoginUserInformation;
import com.wizz.sentencelib.service.UserSaveService;
import com.wizz.sentencelib.tool.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LoginController {
    @Autowired
    private UserSaveService userSaveService;

    @RequestMapping("/login")
    public JSONObject verify(@RequestParam(name = "code",required = true) String code,
                             @RequestParam(name = "userName",required = true) String uerName,
                             @RequestParam(name = "avatar",required = true) String avatar) {
        new Get().getHttp(code);
        userSaveService.save(LoginUserInformation.OPENID, avatar, uerName);
        //userSave.test();
        JSONObject returnResult = new JSONObject(true);
        returnResult.put("error_code", "200");
        returnResult.put("message", "登陆成功");
        returnResult.put("uid", LoginUserInformation.OPENID);
        return returnResult;
    }
}
