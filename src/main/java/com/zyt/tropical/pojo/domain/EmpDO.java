package com.zyt.tropical.pojo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: 员工 DO 对象
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/7/17 16:37
 **/
@Data
@Entity
@Table(name = "t_emp")
public class EmpDO extends BaseDO {

    /**
     * Id
     */
    @Id
    private Integer id;

    /**
     * 编号
     */
    private String no;

    /**
     * 密码
     */
    private String pass;

    /**
     * 盐
     */
    private String salt;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String idNo;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 部门id
     */
    private Integer deptId;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 是否冻结
     */
    private Integer locked;

    /**
     * 是否删除
     */
    private Integer valid;

}
