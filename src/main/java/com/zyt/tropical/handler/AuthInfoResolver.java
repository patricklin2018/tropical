package com.zyt.tropical.handler;

import com.zyt.tropical.config.GlobalConfig;
import com.zyt.tropical.exception.AuthException;
import com.zyt.tropical.pojo.dto.AuthInfoDTO;
import com.zyt.tropical.util.CookieUtil;
import com.zyt.tropical.util.jwt.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/7/31 16:24
 **/
public class AuthInfoResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private JWTHelper jwtHelper;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.getParameterType().isAssignableFrom(AuthInfoDTO.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest;
        String token = CookieUtil.get(request, GlobalConfig.AUTH_FLAG);
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        try {
            AuthInfoDTO authInfoDTO = jwtHelper.parse(token);
            return authInfoDTO;
        } catch (AuthException e) {
            return null;
        }
    }
}
