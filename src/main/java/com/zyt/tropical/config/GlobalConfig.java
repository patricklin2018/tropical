package com.zyt.tropical.config;

/**
 * @Description: 全局常量
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/3 14:12
 **/
public final class GlobalConfig {

    /**
     * 令牌头部key
     */
    public static final String TOKEN_FLAG = "token";

    /**
     * 令牌有效期
     */
    public static final Integer AUTH_EXPIRED_SECONDS = 1800;

    /**
     * Redis缓存令牌前缀
     */
    public static final String TOKEN_CACHE_PREFIX = "token:";

}
