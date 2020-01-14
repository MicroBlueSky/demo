package cn.sun.elasticsearch.demo.service.log;

import cn.sun.elasticsearch.demo.model.LogEntity;

/**
 * @Author: sunyufei
 * @Date: 2020-01-14 15:36
 **/
public interface LogService {

    void saveLog(LogEntity entity);
}
