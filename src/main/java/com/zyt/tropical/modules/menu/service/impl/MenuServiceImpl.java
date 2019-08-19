package com.zyt.tropical.modules.menu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyt.tropical.mapper.MenuMapper;
import com.zyt.tropical.modules.menu.service.MenuService;
import com.zyt.tropical.pojo.domain.Menu;
import org.springframework.stereotype.Service;

/**
 * @Description: 菜单相关服务实现
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/12 11:35
 **/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
}
