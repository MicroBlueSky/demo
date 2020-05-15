package cn.sun.elasticsearch.demo.filter;

import cn.sun.elasticsearch.demo.common.ServerResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * tokenservice
 * @Author: sunyufei
 * @Date: 2020-05-14 19:36
 **/
public interface TokenService {

    ServerResponse createToken();
    void checkToken(HttpServletRequest request);
}
