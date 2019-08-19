package com.zyt.tropical.pojo.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 数据权限 DO 对象
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/7/17 17:00
 **/
@Data
public class DataPermission extends Model<DataPermission> {

    /**
     * Id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 部门id
     */
    private Integer deptId;

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
