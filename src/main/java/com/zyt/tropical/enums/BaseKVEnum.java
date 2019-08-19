package com.zyt.tropical.enums;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description:
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/19 14:41
 **/
@Data
@AllArgsConstructor
public abstract class BaseKVEnum implements KVEnum {

    private int code;
    private String name;

}
