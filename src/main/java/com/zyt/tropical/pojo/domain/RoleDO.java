package com.zyt.tropical.pojo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: 角色DO
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/13 13:51
 **/
@Data
@Entity
@Table(name = "t_role")
public class RoleDO extends BaseDO {

    /**
     * Id
     */
    @Id
    private Integer id;

    /**
     * 名称
     */
    private String name;

}
