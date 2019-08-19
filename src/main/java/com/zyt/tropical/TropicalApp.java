package com.zyt.tropical;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: 项目启动类
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/3 13:33
 **/
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DruidDataSourceAutoConfigure.class})
@MapperScan("com.zyt.tropical.mapper")
public class TropicalApp {

    public static void main(String[] args) {
        SpringApplication.run(TropicalApp.class, args);
    }

}
