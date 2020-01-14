package cn.sun.elasticsearch.demo.dao;

import cn.sun.elasticsearch.demo.model.LogEntity;

/**
 * @Author: sunyufei
 * @Date: 2020-01-14 17:13
 **/
public interface LogDao {

    int saveLog(LogEntity entity);
}
