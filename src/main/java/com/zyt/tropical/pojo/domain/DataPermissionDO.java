package com.zyt.tropical.pojo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: 数据权限 DO 对象
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/7/17 17:00
 **/
@Data
@Entity
@Table(name = "t_data_permission")
public class DataPermissionDO extends BaseDO {

    /**
     * Id
     */
    @Id
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 部门id
     */
    private Integer deptId;

}
