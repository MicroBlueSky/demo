package cn.sun.elasticsearch.demo.aspect;

import cn.sun.elasticsearch.demo.annotation.LogAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author: sunyufei
 * @Date: 2020-01-10 18:58
 **/
@Slf4j
@Component
@Aspect
public class LogAspect {

    /**
    *定义切入点
    */
    @Pointcut("@annotation(cn.sun.elasticsearch.demo.annotation.LogAnnotation)")
    public void log(){
        log.info("进入切面类，开始执行。。。。。。。。。。。。。。。。");
    }

    //前置通知
    @Before("log()")
    public Object before(JoinPoint point){
        log.info("前置通知开始。。。。。。。。。。。。。。。。。。。。");
        long time = System.currentTimeMillis();
        log.info(""+time);
        return "";
    }

    //后置通知
    @After("log()")
    public Object after(JoinPoint point){
        long time = System.currentTimeMillis();
        log.info(time+"后置通知开始。。。。。。。。。。。。。。。。。。。。");
        return "";
    }

    //环绕通知
    @Around("log()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        long startTime = System.currentTimeMillis();
        log.info(startTime+"环绕通知start。。。。。。。。。。。。。。。。。。。。");
        Object object = point.proceed();
        long endTime = System.currentTimeMillis();
        log.info(endTime+"环绕通知end。。。。。。。。。。。。。。。。。。。。");
        return object;
    }

    //返回通知
    @AfterReturning(pointcut = "log()&&@annotation(annotation)",returning = "result")
    public void afterReturnning(JoinPoint point, LogAnnotation annotation, Object result){
        long time = System.currentTimeMillis();
        log.info(time+"方法返回通知。。。。。。。。。。。。。。。。");
    }

    @AfterThrowing(pointcut = "log()&&@annotation(annotation)",throwing = "e")
    public Object afterThrowing(JoinPoint point, LogAnnotation annotation, Exception e){
        long time = System.currentTimeMillis();
        log.info(time+"方法异常通知。。。。。。。。。。。。。。");
        return "";
    }
}
