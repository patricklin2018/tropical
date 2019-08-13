package com.zyt.tropical.modules.emp.service;

import com.zyt.tropical.pojo.domain.EmpDO;
import com.zyt.tropical.pojo.form.LoginForm;

/**
 * @Description: 员工服务接口
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/7/18 15:18
 **/
public interface EmpService {

    /**
     * 登录
     * @param loginForm 登录表单
     * @return 员工信息
     */
    EmpDO login(LoginForm loginForm);

}
