package com.zyt.tropical.modules.emp.mapper;

import com.alibaba.fastjson.JSON;
import com.zyt.tropical.mapper.EmpMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/19 18:07
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMapper {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void test1() {
        System.out.println(JSON.toJSONString(empMapper.selectList(null)));
    }

}
