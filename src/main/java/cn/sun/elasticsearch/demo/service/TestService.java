package cn.sun.elasticsearch.demo.service;

import cn.sun.elasticsearch.demo.common.ServerResponse;
import cn.sun.elasticsearch.demo.pojo.Mail;

public interface TestService {

    ServerResponse testIdempotence();

//    ServerResponse accessLimit();
//
//    ServerResponse send(Mail mail);
}
