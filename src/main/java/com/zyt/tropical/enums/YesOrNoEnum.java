package com.zyt.tropical.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description: 是否类型枚举
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/7/17 16:51
 **/
@Getter
@AllArgsConstructor
public enum YesOrNoEnum implements KVEnum {

    NO(0, "否"),
    YES(1, "是")
    ;

    /**
     * code
     */
    private final int code;

    /**
     * name
     */
    private final String name;

}
