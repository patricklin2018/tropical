package com.zyt.tropical.pojo.dto;

import com.zyt.tropical.pojo.domain.Emp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @Description: 用户常用信息
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/7/26 15:41
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    private Integer id;

    private String no;

    private String username;

    private String avatar;

    private Integer deptId;

    private String deptName;

    private Integer roleId;

    private String roleName;

    private Set<Integer> menuIds;

    public UserInfo(Emp emp) {
        this.id = emp.getId();
        this.no = emp.getNo();
        this.username = emp.getName();
        this.avatar = emp.getAvatar();
        this.deptId = emp.getDeptId();
        this.roleId = emp.getRoleId();
    }

}
