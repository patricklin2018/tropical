package com.zyt.tropical.util;

import com.zyt.tropical.pojo.vo.ResultVO;

/**
 * @Description: ResultVO 对象工厂类
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/3 14:13
 **/
public class ResultVOFactory {

    private static final Integer SUCCESS_CODE = 0;
    private static final String SUCCESS_MSG = "成功";

    private static final Integer BUSI_ERROR_CODE = 100;
    private static final String BUSI_ERROR_MSG = "业务异常";

    private static final Integer SYS_ERROR_CODE = 300;
    private static final String SYS_ERROR_MSG = "系统异常";

    private static final Integer ILLEGAL_REQUEST_ERROR_CODE = 400;
    private static final String ILLEGAL_REQUEST_ERROR_MSG = "请求参数异常";

    private static final Integer AUTH_ERROR_CODE = 401;
    private static final String AUTH_ERROR_MSG = "权限异常";

    private static final Integer UNKNOWN_ERROR_CODE = 500;
    private static final String UNKNOWN_ERROR_MSG = "未知异常";


    public static ResultVO success() {
        return new ResultVO(SUCCESS_CODE, SUCCESS_MSG, null);
    }

    public static <T> ResultVO success(T data) {
        return new ResultVO(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    public static <T> ResultVO busiError(String msg) {
        return new ResultVO(BUSI_ERROR_CODE, msg, null);
    }

    public static <T> ResultVO sysError(String msg) {
        return new ResultVO(SYS_ERROR_CODE, msg, null);
    }

    public static ResultVO illegalRequError() {
        return new ResultVO(ILLEGAL_REQUEST_ERROR_CODE, ILLEGAL_REQUEST_ERROR_MSG, null);
    }

    public static <T> ResultVO illegalRequError(T data) {
        return new ResultVO(ILLEGAL_REQUEST_ERROR_CODE, ILLEGAL_REQUEST_ERROR_MSG, data);
    }

    public static ResultVO authError() {
        return new ResultVO(AUTH_ERROR_CODE, AUTH_ERROR_MSG, null);
    }

    public static <T> ResultVO authError(T data) {
        return new ResultVO(AUTH_ERROR_CODE, AUTH_ERROR_MSG, data);
    }

    public static ResultVO unknownError() {
        return new ResultVO(UNKNOWN_ERROR_CODE, UNKNOWN_ERROR_MSG, null);
    }

    public static <T> ResultVO unknownError(T data) {
        return new ResultVO(UNKNOWN_ERROR_CODE, UNKNOWN_ERROR_MSG, data);
    }

}
