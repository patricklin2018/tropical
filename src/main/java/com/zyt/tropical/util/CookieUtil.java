package com.zyt.tropical.util;

import org.springframework.util.Assert;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: Cookie 操作工具类
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/3 14:11
 **/
public class CookieUtil {

    /**
     * 获取 cookie 的值，若无该 key，则返回为 null
     *
     * @param request http servlet request
     * @param key     键
     * @return 值
     */
    public static String get(HttpServletRequest request, String key) {
        Assert.notNull(request);
        Assert.notNull(key);
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie c : cookies) {
                if (c.getName().equals(key)) {
                    return c.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 设置 cookie
     *
     * @param response http servlet response
     * @param key      键
     * @param val      值
     */
    public static void set(HttpServletResponse response, String key, String val, Integer expiredSeconds) {
        Assert.notNull(response);
        Assert.notNull(key);
        Cookie cookie = new Cookie(key, val);
        if (expiredSeconds != null) {
            cookie.setMaxAge(expiredSeconds);
        }
        response.addCookie(cookie);
    }

}
