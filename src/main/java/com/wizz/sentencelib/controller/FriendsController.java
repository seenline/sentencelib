package com.wizz.sentencelib.controller;

import com.wizz.sentencelib.model.CommonResponse;
import com.wizz.sentencelib.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author seenline
 * @date 2021/8/17 17:09
 * @description 用于添加好友
 */
@RestController
public class FriendsController {
    @Autowired
    private FriendService friendService;
    
    @RequestMapping("/addfriends")
    public CommonResponse addFriends(@RequestParam(required = true) String uid1,
                                     @RequestParam(required = true) String uid2)
    {
        friendService.add(uid1,uid2);
        return CommonResponse.SUCCESS;
    }
    @RequestMapping("/delfriends")
    public CommonResponse delFriends(@RequestParam(required = true) String uid1,
                                     @RequestParam(required = true) String uid2)
    {
        friendService.delete(uid1, uid2);
        return CommonResponse.SUCCESS;
    }
}
