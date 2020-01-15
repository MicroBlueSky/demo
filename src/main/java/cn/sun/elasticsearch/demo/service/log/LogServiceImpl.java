package cn.sun.elasticsearch.demo.service.log;

import cn.sun.elasticsearch.demo.dao.LogDao;
import cn.sun.elasticsearch.demo.model.LogEntity;
import cn.sun.elasticsearch.demo.service.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author: sunyufei
 * @Date: 2020-01-14 15:36
 **/
@Slf4j
@Service
public class LogServiceImpl extends BaseService implements LogService{

//    @Resource
//    private LogDao logDao;

    @Override
    public void saveLog(LogEntity entity) {
        log.info("保存日志信息:"+entity.toString());
        entity.setCreateTime(new Date());
//        logDao.saveLog(entity);
    }
}
