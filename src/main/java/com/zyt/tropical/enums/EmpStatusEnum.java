package com.zyt.tropical.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description: 员工状态枚举
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/19 14:41
 **/
@Getter
@AllArgsConstructor
public enum EmpStatusEnum implements KVEnum {
    NORMAL(0, "正常"),
    RESIGN(10, "离职")
    ;

    private int code;
    private String name;

}
