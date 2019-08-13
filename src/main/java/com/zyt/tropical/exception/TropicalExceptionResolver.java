package com.zyt.tropical.exception;

import com.alibaba.fastjson.JSON;
import com.zyt.tropical.pojo.vo.ResultVO;
import com.zyt.tropical.util.IPUtil;
import com.zyt.tropical.util.ResultVOFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 全局异常捕获
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/7/27 17:21
 **/
@ControllerAdvice
@ResponseBody
@Slf4j
public class TropicalExceptionResolver {

    @ExceptionHandler(value = Exception.class)
    public ResultVO exceptionHandler(HttpServletRequest request, Exception e) {
        String url = request.getRequestURI();
        String params = JSON.toJSONString(request.getParameterMap());
        if (e instanceof IllegalArgumentException) {
            IllegalArgumentException ex = (IllegalArgumentException) e;
            log.error("【全局异常捕获】参数请求异常：msg={}, url={}, params={}", ex.getMessage(), url, params);
            return ResultVOFactory.illegalRequError(ex.getMessage());
        } else if (e instanceof BusiException) {
            BusiException ex = (BusiException) e;
            log.error("【全局异常捕获】业务异常：msg={}, url={}, params={}", ex.getMsg(), url, params);
            return ResultVOFactory.busiError(ex.getMsg());
        } else if (e instanceof SysException) {
            SysException ex = (SysException) e;
            log.error("【全局异常捕获】系统异常：msg={}, url={}, params={}", ex.getMsg(), url, params);
            return ResultVOFactory.sysError(ex.getMsg());
        } else if (e instanceof AuthException) {
            AuthException ex = (AuthException) e;
            String ip = IPUtil.getIpAdress(request);
            log.error("【全局异常捕获】权限异常：msg={}, url={}, ip={}", ex.getMsg(), url, ip);
            return ResultVOFactory.authError();
        } else if (e instanceof ServletRequestBindingException) {
            ServletRequestBindingException ex = (ServletRequestBindingException) e;
            log.error("【全局异常捕获】绑定异常：msg={}, rul={}", ex.getMessage(), url);
            return new ResultVO(400, "绑定异常", null);
        }
        else {
            log.error("【全局异常捕获】捕获未知异常，参考信息：msg={}, url={}, params={}", e.getMessage(), url, params);
            return ResultVOFactory.unknownError();
        }
    }

}
