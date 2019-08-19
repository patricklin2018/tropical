package com.zyt.tropical.modules.menu.controller;

import com.zyt.tropical.pojo.dto.UserInfo;
import com.zyt.tropical.pojo.vo.ResultVO;
import com.zyt.tropical.util.ResultVOFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 菜单相关 Controller
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/12 11:34
 **/
@RestController
public class MenuController {

    @GetMapping("/menus")
    public ResultVO menus(UserInfo authInfoDTO) {
        if (authInfoDTO == null) {
            // throw new AuthException("请先完成登录");
        }
        return ResultVOFactory.success();
    }

}
