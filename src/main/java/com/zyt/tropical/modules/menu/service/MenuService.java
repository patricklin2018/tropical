package com.zyt.tropical.modules.menu.service;

import com.zyt.tropical.pojo.domain.MenuDO;
import com.zyt.tropical.pojo.dto.AuthInfoDTO;

import java.util.List;

/**
 * @Description: 菜单相关服务接口
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/12 11:35
 **/
public interface MenuService {

    /**
     * 根据授权获取菜单信息
     *
     * @return 菜单信息
     */
    List<MenuDO> getMenusByAuth(AuthInfoDTO authInfoDTO);

}
