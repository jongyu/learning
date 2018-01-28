package com.zhongyu.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by ZhongYu on 3/12/2017.
 * 获取前缀为com的配置
 */
@Component
@ConfigurationProperties(prefix = "com")
public class ConfigProperties {

    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
