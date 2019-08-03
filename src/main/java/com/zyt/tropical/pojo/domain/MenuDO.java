package com.zyt.tropical.pojo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: 菜单 DO 对象
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/7/17 16:54
 **/
@Data
@Entity
@Table(name = "t_menu")
public class MenuDO extends BaseDO {

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
     * 类型
     */
    private Integer type;

    /**
     * 上级菜单id
     */
    private Integer parentId;

    /**
     * 同级排序
     */
    private Integer sort;

    /**
     * 是否小时
     */
    private Integer shown;

    /**
     * 跳转地址
     */
    private String url;

    /**
     * 图标
     */
    private String icon;

    /**
     * 是否删除
     */
    private Integer valid;

}
