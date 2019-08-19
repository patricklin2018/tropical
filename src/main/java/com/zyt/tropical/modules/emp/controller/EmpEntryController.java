package com.zyt.tropical.modules.emp.controller;

import com.zyt.tropical.config.GlobalConfig;
import com.zyt.tropical.exception.AuthException;
import com.zyt.tropical.modules.emp.service.EmpService;
import com.zyt.tropical.pojo.dto.UserInfo;
import com.zyt.tropical.pojo.form.LoginForm;
import com.zyt.tropical.pojo.vo.ResultVO;
import com.zyt.tropical.util.ResultVOFactory;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 员工注册、登录、修改密码、禁止登录等入口相关controller
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/10 17:45
 **/
@RestController
@AllArgsConstructor
public class EmpEntryController {

    private final EmpService empService;

    @GetMapping(value = "/me")
    public ResultVO me(UserInfo me) {
        if (me == null) {
            throw new AuthException("用户登录超时，请重新登录");
        }
        return ResultVOFactory.success(me);
    }

    /**
     * 登录
     */
    @PostMapping(value = "/login")
    public ResultVO login(LoginForm loginForm, UserInfo userInfo, HttpServletRequest request) {
        String token;
        if (userInfo != null) {
            token = request.getHeader(GlobalConfig.TOKEN_FLAG);
        } else {
            token = empService.login(loginForm);
        }
        return ResultVOFactory.success(token);
    }

}
