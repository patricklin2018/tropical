package com.zyt.tropical.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 对象工具
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/3 14:02
 **/
public class ObjectUtil {

    /**
     * 对象转换 Map
     * @param obj
     * @return
     * @throws RuntimeException
     */
    public static Map<String, String> objToMap(Object obj) throws RuntimeException {
        Map<String, String> res = new HashMap<>(4);
        if (obj == null) {
            return res;
        }
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                res.put(field.getName(), String.valueOf(field.get(obj)));
            }
        } catch (Exception e) {
            throw new RuntimeException("对象转换异常");
        }
        return res;
    }

}
