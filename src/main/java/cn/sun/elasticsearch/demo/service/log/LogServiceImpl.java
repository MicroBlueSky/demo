package cn.sun.elasticsearch.demo.service.log;

import cn.sun.elasticsearch.demo.model.LogEntity;
import cn.sun.elasticsearch.demo.service.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author: sunyufei
 * @Date: 2020-01-14 15:36
 **/
@Slf4j
@Service
public class LogServiceImpl extends BaseService implements LogService{

    @Override
    public void saveLog(LogEntity entity) {
        log.info("保存日志信息:"+entity.toString());
    }
}
