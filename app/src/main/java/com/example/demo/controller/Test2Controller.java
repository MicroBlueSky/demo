package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * All rights Reserved, Designed By www.hikvision.com
 *
 * @ClassName TestController
 * @Package com.example.demo.controller
 * @Description TODO
 * @Author: sunyufei
 * @Date: 2021-06-02 11:40
 * @VersionV1.0
 * @Copyright: 2021 www.hikvision.com Inc. All rights reserved.
 * 注意：本内容仅限于杭州海康威视数字技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 **/
@RestController
@RequestMapping("/test2/")
public class Test2Controller {

    @RequestMapping("get2")
    public String test(){
        return "测试2";
    }
}
