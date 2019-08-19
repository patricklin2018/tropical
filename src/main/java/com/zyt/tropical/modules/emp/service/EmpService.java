package com.zyt.tropical.modules.emp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyt.tropical.pojo.domain.Emp;
import com.zyt.tropical.pojo.form.LoginForm;

/**
 * @Description: 员工服务接口
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/7/18 15:18
 **/
public interface EmpService extends IService<Emp> {

    /**
     * 登录
     *
     * @param loginForm 登录表单
     * @return token
     */
    String login(LoginForm loginForm);


}
