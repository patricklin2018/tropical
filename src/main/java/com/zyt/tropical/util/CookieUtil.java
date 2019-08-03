package com.zyt.tropical.util;

import org.springframework.util.Assert;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description: Cookie 操作工具类
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/3 14:11
 **/
public class CookieUtil {

    /**
     * 获取 cookie 的值，若无该 key，则返回为 null
     * @param request
     * @param key 键值
     * @return 对应值
     */
    public static String get(HttpServletRequest request, String key) {
        Assert.notNull(request);
        Assert.notNull(key);
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals(key)) {
                return c.getValue();
            }
        }
        return null;
    }


}
