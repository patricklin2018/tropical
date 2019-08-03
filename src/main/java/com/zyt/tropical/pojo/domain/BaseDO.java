package com.zyt.tropical.pojo.domain;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @Description: 基础 DO 对象
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/7/17 16:28
 **/
@Data
@MappedSuperclass
public class BaseDO {

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
