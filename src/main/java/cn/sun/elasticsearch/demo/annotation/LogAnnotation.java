package cn.sun.elasticsearch.demo.annotation;

import java.lang.annotation.*;

/**
 * @Author: sunyufei
 * @Date: 2020-01-10 19:19
 **/
@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {
}
