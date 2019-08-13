package com.zyt.tropical.modules.menu.dao;

import com.zyt.tropical.pojo.domain.MenuDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description: 菜单相关数据链接层
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/12 15:05
 **/
public interface MenuRepo extends JpaRepository<MenuDO, Integer> {

    List<MenuDO> findByIdIn(List<Integer> ids);

}
