package com.zyt.tropical.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description:
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/7/27 17:11
 **/
@Data
@AllArgsConstructor
public abstract class EverythingException extends RuntimeException {
    private String msg;
}
