package com.zyt.tropical.util;

import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;

/**
 * @Description: MD5 工具类
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/3 14:18
 **/
public class MD5Util {

    private MD5Util() {}

    /**
     * 输入密码 src，返回 md5 加密结果
     */
    public static String md5(String rawPass) {
        return DigestUtils.md5DigestAsHex(rawPass.getBytes());
    }

    /**
     * 加盐
     * @param rawPass 原始密码
     * @param salt 盐
     * @return 加盐后密码
     */
    public static String salt(String rawPass, String salt) {
        Assert.notNull(rawPass);
        Assert.notNull(salt);
        Assert.isTrue(salt.length() >= 8);
        String saltedPass = salt.charAt(5) + salt.charAt(0) + rawPass + salt.charAt(2) + salt.charAt(7);
        return saltedPass;
    }

    /**
     * 输入密码 src，返回 md5 + salt 加密结果
     */
    public static String saltAndMD5(String rawPass, String salt) {
        return md5(salt(rawPass, salt));
    }

}
