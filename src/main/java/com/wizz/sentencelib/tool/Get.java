package com.wizz.sentencelib.tool;

import com.alibaba.fastjson.JSONObject;
import com.wizz.sentencelib.config.BackgroundConfig;
import com.wizz.sentencelib.config.LoginUserInformation;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author seenline
 * @data 2021/7/27 17:17
 * @description 向微信服务器发送请求获取用户openid, session_key, unionid
 */

public class Get {
    public void getHttp(String code) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://api.weixin.qq.com/sns/jscode2session?appid="+ BackgroundConfig.ACCESS_KEY1+"&secret="+BackgroundConfig.ACCESS_KEY2+"&js_code="+code+"&grant_type=authorization_code");
        CloseableHttpResponse response = null;
        try {
            response = client.execute(get);
            HttpEntity entity = response.getEntity();
            JSONObject obj = JSONObject.parseObject(EntityUtils.toString(entity));
            new LoginUserInformation().setContentFirst(obj.getString("openid")).setContentSecond(obj.getString("session_id")).propertiesSet();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
