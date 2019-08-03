package com.zyt.tropical.pojo.domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: 菜单权限 DO 对象
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/7/17 17:02
 **/
@Data
@Entity
@Table(name = "t_menu_permission")
public class MenuPermissionDO extends BaseDO {

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
     * 菜单id
     */
    private Integer menuId;

}
