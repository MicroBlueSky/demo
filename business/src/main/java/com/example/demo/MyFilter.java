package com.example.demo;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * All rights Reserved, Designed By www.hikvision.com
 *
 * @ClassName MyFilter
 * @Package com.example.demo
 * @Description TODO
 * @Author: sunyufei
 * @Date: 2021-06-02 11:54
 * @VersionV1.0
 * @Copyright: 2021 www.hikvision.com Inc. All rights reserved.
 * 注意：本内容仅限于杭州海康威视数字技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 **/
@Component
@WebFilter(urlPatterns = {"/*"})
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println(request.getRequestURI());
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
