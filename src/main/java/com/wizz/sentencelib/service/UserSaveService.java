package com.wizz.sentencelib.service;

import com.wizz.sentencelib.beans.User;
import com.wizz.sentencelib.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author seenline
 * @data 2021/8/2 14:39
 * @description 用户信息保存至数据库中
 */
@Service
public class UserSaveService {
    @Autowired
    private UserMapper userMapper;
    public void save(String uid,String avatar,String username)
    {
        userMapper.insert(new User().setUid(uid).setAvatar(avatar).setUsername(username));
    }

}
