package cn.sun.elasticsearch.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在需要保证 接口幂等性 的Controller的方法上使用此注解
 * @Author: sunyufei
 * @Date: 2020-05-14 19:33
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiIdempotent {
}
