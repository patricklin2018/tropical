package com.zyt.tropical.pojo.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 角色DO
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/13 13:51
 **/
@Data
public class Role extends Model<Role> {

    /**
     * Id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 创建人
     */
    protected String createName;

    /**
     * 更新时间
     */
    protected Date updateTime;

    /**
     * 更新人
     */
    protected String updateName;

}
