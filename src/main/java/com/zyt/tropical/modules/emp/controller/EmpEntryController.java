package com.zyt.tropical.modules.emp.controller;

import com.zyt.tropical.exception.AuthException;
import com.zyt.tropical.modules.emp.service.EmpService;
import com.zyt.tropical.pojo.domain.EmpDO;
import com.zyt.tropical.pojo.dto.AuthInfoDTO;
import com.zyt.tropical.pojo.form.LoginForm;
import com.zyt.tropical.pojo.vo.ResultVO;
import com.zyt.tropical.util.JWTHelper;
import com.zyt.tropical.util.ResultVOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 员工注册、登录、修改密码、禁止登录等入口相关controller
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/10 17:45
 **/
@RestController
public class EmpEntryController {

    @Autowired
    private EmpService empService;

    @Autowired
    private JWTHelper jwtHelper;

    @GetMapping(value = "/me")
    public ResultVO me(AuthInfoDTO me) {
        if (me == null) {
            throw new AuthException("用户登录超时，请重新登录");
        }
        return ResultVOFactory.success(me);
    }

    /**
     * 登录
     */
    @PostMapping(value = "/login")
    public ResultVO login(LoginForm loginForm, AuthInfoDTO authInfoDTO, HttpServletRequest request, HttpServletResponse response) {
        if (authInfoDTO != null) {
            // 刷新token
            jwtHelper.refresh(authInfoDTO, 1800, request);
        }
        EmpDO empDO = empService.login(loginForm);
        jwtHelper.publish(new AuthInfoDTO(empDO), 1800, request);
        return ResultVOFactory.success(empDO);
    }

}
