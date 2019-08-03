package com.zyt.tropical.pojo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: 部门 DO 对象
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/7/17 16:52
 **/
@Data
@Entity
@Table(name = "t_dept")
public class DeptDO {

    /**
     * Id
     */
    @Id
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 负责人姓名
     */
    private String manager;

    /**
     * 负责人手机
     */
    private String managerPhone;

    /**
     * 上级部门id
     */
    private Integer parentId;

    /**
     * 上级部门名称
     */
    private String parentName;

    /**
     * 是否删除
     */
    private Integer valid;

}
