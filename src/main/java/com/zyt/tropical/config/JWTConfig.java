package com.zyt.tropical.config;

import com.alibaba.druid.util.StringUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: JWT 配置
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/3 13:43
 **/
@Configuration
@ConfigurationProperties(prefix = "jwt")
@Data
public class JWTConfig {

    public String alg;

    public String type;

    public String privateSecret;

    public Map getHeader() {
        Map<String, Object> header = new HashMap<>();
        header.put("alg", alg);
        header.put("type", type);
        return header;
    }

    public boolean validate() {
        if (StringUtils.isEmpty(alg) || StringUtils.isEmpty(type) || StringUtils.isEmpty(privateSecret)) {
            return false;
        }
        return true;
    }

}
