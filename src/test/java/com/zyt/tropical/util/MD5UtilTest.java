package com.zyt.tropical.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/12 09:17
 **/
public class MD5UtilTest {

    @Test
    public void saltAndMD5() {
        String pass = "123456";
        String dbPass = MD5Util.saltAndMD5(pass, "abcdefgh");
        System.out.println(dbPass);
    }
}