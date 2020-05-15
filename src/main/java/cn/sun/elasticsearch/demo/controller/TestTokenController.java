package cn.sun.elasticsearch.demo.controller;

import cn.sun.elasticsearch.demo.annotation.ApiIdempotent;
import cn.sun.elasticsearch.demo.common.ServerResponse;
import cn.sun.elasticsearch.demo.common.utils.JedisUtil;
import cn.sun.elasticsearch.demo.controller.base.BaseController;
import cn.sun.elasticsearch.demo.filter.TokenService;
import cn.sun.elasticsearch.demo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: sunyufei
 * @Date: 2020-05-14 17:02
 **/
@Controller
@RequestMapping("/token/")
@Slf4j
public class TestTokenController extends BaseController {

    @Autowired
    private JedisUtil jedisUtil;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private TestService testService;

    @GetMapping("getToken")
    @ResponseBody
    public ServerResponse token() {
        return tokenService.createToken();
    }

    @ApiIdempotent
    @PostMapping("testIdempotence")
    @ResponseBody
    public ServerResponse testIdempotence() {
        return testService.testIdempotence();
    }
}
