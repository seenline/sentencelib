package com.wizz.sentencelib.controller;

import com.wizz.sentencelib.model.CommonResponse;
import com.wizz.sentencelib.service.AddFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author seenline
 * @data 2021/8/17 17:09
 * @description 用于添加好友
 */
@RestController
public class AddFriendsController {
    @Autowired
    private AddFriendService addFriendService;
    
    @RequestMapping("/addfriends")
    public CommonResponse addfriends(@RequestParam(required = true) String uid1,
                                     @RequestParam(required = true) String uid2)
    {
        addFriendService.add(uid1,uid2);
        return CommonResponse.SUCCESS;
    }
}
