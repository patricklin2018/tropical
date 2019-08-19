package com.zyt.tropical.pojo.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 部门 DO 对象
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/7/17 16:52
 **/
@Data
public class Dept extends Model<Dept> {

    /**
     * Id
     */
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
