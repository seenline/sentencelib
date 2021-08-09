package com.wizz.sentencelib.config;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author seenline
 * @data 2021/7/27 17:17
 * @description 存储交互得到的openid，session，unionid
 */

@Accessors(chain = true)
@Data
public class LoginUserInformation {
    public static String OPENID;
    public static String SESSION_KEY;

    private String contentFirst;
    private String contentSecond;

    public void propertiesSet() {
        OPENID = contentFirst;
        SESSION_KEY = contentSecond;
    }


}
