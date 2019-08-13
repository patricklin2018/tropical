package com.zyt.tropical.modules.menu.service.impl;

import com.zyt.tropical.config.GlobalConfig;
import com.zyt.tropical.modules.menu.dao.MenuPermissionRepo;
import com.zyt.tropical.modules.menu.dao.MenuRepo;
import com.zyt.tropical.modules.menu.service.MenuService;
import com.zyt.tropical.pojo.domain.MenuDO;
import com.zyt.tropical.pojo.dto.AuthInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @Description: 菜单相关服务实现
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/12 11:35
 **/
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepo menuRepo;

    @Autowired
    private MenuPermissionRepo menuPermissionRepo;

    @Override
    public List<MenuDO> getMenusByAuth(AuthInfoDTO authInfoDTO) {
        Assert.notNull(authInfoDTO);
        Assert.isTrue(authInfoDTO.validate());
        List<MenuDO> res;
        if (authInfoDTO.getNo().equals(GlobalConfig.ADMIN_FLAG)) {
            res = menuRepo.findAll();
        } else {
            List<Integer> menuIds = menuPermissionRepo.findMenuIdByUserId(authInfoDTO.getId());
            res = menuRepo.findByIdIn(menuIds);
        }
        return null;
    }
}
