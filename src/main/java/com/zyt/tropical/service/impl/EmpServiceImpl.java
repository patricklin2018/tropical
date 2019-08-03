package com.zyt.tropical.service.impl;

import com.zyt.tropical.config.GlobalConfig;
import com.zyt.tropical.dao.EmpRepo;
import com.zyt.tropical.enums.YesOrNoEnum;
import com.zyt.tropical.exception.BusiException;
import com.zyt.tropical.pojo.domain.EmpDO;
import com.zyt.tropical.pojo.dto.AuthInfoDTO;
import com.zyt.tropical.pojo.form.LoginForm;
import com.zyt.tropical.service.EmpService;
import com.zyt.tropical.util.EnumUtil;
import com.zyt.tropical.util.MD5Util;
import com.zyt.tropical.util.jwt.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 员工服务实现
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/7/18 15:19
 **/
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepo empRepo;

    @Autowired
    private JWTHelper jwtHelper;

    @Override
    public EmpDO login(LoginForm loginForm, HttpServletResponse response) {
        Assert.notNull(loginForm.getUsername());
        Assert.notNull(loginForm.getPassword());
        EmpDO empDO = empRepo.findByNo(loginForm.getUsername());
        if (empDO == null) {
            throw new BusiException("找不到该用户");
        }
        String pass = MD5Util.saltAndMD5(loginForm.getPassword(), empDO.getSalt());
        if (!pass.equals(empDO.getPass())) {
            throw new BusiException("密码错误");
        } else if (!EnumUtil.equals(YesOrNoEnum.NO, empDO.getLocked())) {
            throw new BusiException("账号已被冻结");
        } else if (!EnumUtil.equals(YesOrNoEnum.NO, empDO.getValid())) {
            throw new BusiException("非法账号");
        }
        // 令牌颁发
        AuthInfoDTO authInfoDTO = new AuthInfoDTO();
        authInfoDTO.setUsername(empDO.getName());
        String jwt = jwtHelper.create(authInfoDTO, 5000);
        Cookie cookie = new Cookie(GlobalConfig.AUTH_FLAG, jwt);
        response.addCookie(cookie);
        return empDO;
    }

}
