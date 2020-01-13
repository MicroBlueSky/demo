package cn.sun.elasticsearch.demo.controller;

import cn.sun.elasticsearch.demo.annotation.LogAnnotation;
import cn.sun.elasticsearch.demo.controller.base.BaseController;
import cn.sun.elasticsearch.demo.service.ElasticsearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: sunyufei
 * @Date: 2020-01-10 10:44
 **/
@Controller
@RequestMapping("es")
@Slf4j
public class ElasticsearchController extends BaseController {

    @Autowired
    private ElasticsearchService esService;

    @ResponseBody
    @RequestMapping(value = "/hello")
    @LogAnnotation
    public StringBuilder sayHello(String id){
        return esService.Hello(id);
    }
}
