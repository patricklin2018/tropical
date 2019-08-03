package com.zyt.tropical.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description: 请求结果
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/7/27 16:59
 **/
@Data
@AllArgsConstructor
public class ResultVO<T> {

    private int code;

    private String msg;

    private T data;

}
