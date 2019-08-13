package com.zyt.tropical.modules.menu.dao;

import com.zyt.tropical.pojo.domain.MenuPermissionDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description: 菜单权限相关数据链接层
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/12 15:11
 **/
public interface MenuPermissionRepo extends JpaRepository<MenuPermissionDO, Integer> {

    /**
     * 根据用户id获取菜单id
     *
     * @param userId 用户id
     * @return 菜单id列表
     */
    List<Integer> findMenuIdByUserId(Integer userId);

}
