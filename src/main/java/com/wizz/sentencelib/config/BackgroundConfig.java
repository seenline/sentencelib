package com.wizz.sentencelib.config;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "background")
public class BackgroundConfig implements InitializingBean {

    public static String ACCESS_KEY1;
    public static String ACCESS_KEY2;
    private String appId;
    private String appSecret;

    @Override
    public void afterPropertiesSet() throws Exception {
        ACCESS_KEY1 = appId;
        ACCESS_KEY2 = appSecret;
    }
}
