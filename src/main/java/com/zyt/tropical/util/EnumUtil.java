package com.zyt.tropical.util;

import com.zyt.tropical.enums.KVEnum;

/**
 * @Description: 枚举工具类
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/3 14:19
 **/
public class EnumUtil {

    public static <T extends KVEnum> boolean equals(T claz, Integer index) {
        if (index == null) {
            return false;
        } else if (claz.getCode() == index) {
            return true;
        } else {
            return false;
        }
    }

}
