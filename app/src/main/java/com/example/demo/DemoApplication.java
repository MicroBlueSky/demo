package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * All rights Reserved, Designed By www.hikvision.com
 *
 * @ClassName DemoApplication
 * @Package com.example.demo
 * @Description TODO
 * @Author: sunyufei
 * @Date: 2021-06-02 11:24
 * @VersionV1.0
 * @Copyright: 2021 www.hikvision.com Inc. All rights reserved.
 * 注意：本内容仅限于杭州海康威视数字技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 **/
@SpringBootApplication
@MapperScan({"com.example.demo.dao.mapper"})
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }
}
