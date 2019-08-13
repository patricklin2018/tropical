package com.zyt.tropical.modules.emp.service.impl;

import com.zyt.tropical.enums.YesOrNoEnum;
import com.zyt.tropical.exception.BusiException;
import com.zyt.tropical.modules.emp.dao.EmpRepo;
import com.zyt.tropical.modules.emp.service.EmpService;
import com.zyt.tropical.pojo.domain.EmpDO;
import com.zyt.tropical.pojo.form.LoginForm;
import com.zyt.tropical.util.EnumUtil;
import com.zyt.tropical.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @Description: 员工服务实现
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/7/18 15:19
 **/
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepo empRepo;

    @Override
    public EmpDO login(LoginForm loginForm) {
        Assert.notNull(loginForm.getNo());
        Assert.notNull(loginForm.getPass());
        EmpDO empDO = empRepo.findByNo(loginForm.getNo());
        if (empDO == null) {
            throw new BusiException("找不到该用户");
        }
        String pass = MD5Util.saltAndMD5(loginForm.getPass(), empDO.getSalt());
        if (!pass.equals(empDO.getPass())) {
            throw new BusiException("密码错误");
        } else if (!EnumUtil.equals(YesOrNoEnum.NO, empDO.getLocked())) {
            throw new BusiException("账号已被冻结");
        } else if (!EnumUtil.equals(YesOrNoEnum.NO, empDO.getValid())) {
            throw new BusiException("非法账号");
        }
        return empDO;
    }

}
