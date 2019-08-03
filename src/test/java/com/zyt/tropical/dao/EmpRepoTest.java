package com.zyt.tropical.dao;

import com.alibaba.fastjson.JSON;
import com.zyt.tropical.pojo.domain.EmpDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/3 14:08
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class EmpRepoTest {

    @Autowired
    private EmpRepo empRepo;

    @Test
    public void test() {
        List<EmpDO> res = empRepo.findAll();
        System.out.println(JSON.toJSONString(res));
    }

}