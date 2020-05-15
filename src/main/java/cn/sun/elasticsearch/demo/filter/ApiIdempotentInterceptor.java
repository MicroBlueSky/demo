package cn.sun.elasticsearch.demo.filter;

import cn.sun.elasticsearch.demo.annotation.ApiIdempotent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 接口幂等性拦截器
 * @Author: sunyufei
 * @Date: 2020-05-14 19:34
 **/

public class ApiIdempotentInterceptor implements HandlerInterceptor  {

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        ApiIdempotent methodAnnotion = method.getAnnotation(ApiIdempotent.class);
        if (methodAnnotion != null){
            check(request);
        }
        return true;
    }

    private void check(HttpServletRequest request){
        tokenService.checkToken(request);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception{
    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
