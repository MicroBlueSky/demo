package cn.sun.elasticsearch.demo.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author: sunyufei
 * @Date: 2020-01-14 15:38
 **/
@Data
public class LogEntity {

    private String url;
    private String params;
    private String ret;
    private String exception;
    private Date createTime;
    private Date updateTime;
}
