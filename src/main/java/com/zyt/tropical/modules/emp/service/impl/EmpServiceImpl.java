package com.zyt.tropical.modules.emp.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyt.tropical.config.GlobalConfig;
import com.zyt.tropical.enums.YesOrNoEnum;
import com.zyt.tropical.exception.BusiException;
import com.zyt.tropical.mapper.DeptMapper;
import com.zyt.tropical.mapper.EmpMapper;
import com.zyt.tropical.mapper.MenuPermissionMapper;
import com.zyt.tropical.mapper.RoleMapper;
import com.zyt.tropical.modules.emp.service.EmpService;
import com.zyt.tropical.pojo.domain.Dept;
import com.zyt.tropical.pojo.domain.Emp;
import com.zyt.tropical.pojo.domain.MenuPermission;
import com.zyt.tropical.pojo.domain.Role;
import com.zyt.tropical.pojo.dto.UserInfo;
import com.zyt.tropical.pojo.form.LoginForm;
import com.zyt.tropical.util.EnumUtil;
import com.zyt.tropical.util.MD5Util;
import com.zyt.tropical.util.UUIDUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Description: 员工服务实现
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/7/18 15:19
 **/
@Service
@AllArgsConstructor
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {

    private final DeptMapper deptMapper;
    private final RoleMapper roleMapper;
    private final MenuPermissionMapper menuPermissionMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public String login(LoginForm loginForm) {
        Assert.notNull(loginForm);
        Assert.notNull(loginForm.getNo());
        Assert.notNull(loginForm.getPass());
        Emp empDO = baseMapper.selectOne(Wrappers.<Emp>lambdaQuery().eq(Emp::getNo, loginForm.getNo()));
        if (empDO == null) {
            throw new BusiException("找不到该用户");
        }
        String pass = MD5Util.saltAndMD5(loginForm.getPass(), empDO.getSalt());
        if (!pass.equals(empDO.getPass())) {
            throw new BusiException("密码错误");
        } else if (!EnumUtil.equals(YesOrNoEnum.NO, empDO.getLocked())) {
            throw new BusiException("账号已被冻结");
        } else if (!EnumUtil.equals(YesOrNoEnum.NO, empDO.getValid())) {
            throw new BusiException("非法账号");
        }
        UserInfo userInfo = new UserInfo(empDO);
        // 部门信息
        if (userInfo.getDeptId() != null) {
            Dept dept = deptMapper.selectById(empDO.getDeptId());
            if (dept != null) {
                userInfo.setDeptName(dept.getName());
            }
        }
        // 角色信息
        if (userInfo.getRoleId() != null) {
            Role role = roleMapper.selectById(empDO.getRoleId());
            if (role != null) {
                userInfo.setRoleName(role.getName());
            }
        }
        // 获取授权菜单
        List<MenuPermission> menuPermissionDOList = menuPermissionMapper.selectList(Wrappers.<MenuPermission>lambdaQuery().eq(MenuPermission::getUserId, empDO.getId()));
        Set<Integer> menuIds = menuPermissionDOList
                .stream().map(e -> e.getMenuId())
                .collect(Collectors.toSet());
        userInfo.setMenuIds(menuIds);
        String token = UUIDUtil.get32UUID();
        redisTemplate.opsForValue().set(GlobalConfig.TOKEN_CACHE_PREFIX + token, userInfo);
        redisTemplate.expire(GlobalConfig.TOKEN_CACHE_PREFIX + token, GlobalConfig.AUTH_EXPIRED_SECONDS, TimeUnit.SECONDS);
        return token;
    }

}
