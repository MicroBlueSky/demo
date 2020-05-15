package cn.sun.elasticsearch.demo.service.impl;


import cn.sun.elasticsearch.demo.common.ServerResponse;
import cn.sun.elasticsearch.demo.common.utils.RandomUtil;
import cn.sun.elasticsearch.demo.pojo.Mail;
import cn.sun.elasticsearch.demo.pojo.MsgLog;
import cn.sun.elasticsearch.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

//    @Autowired
//    private MsgLogMapper msgLogMapper;
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;

    @Override
    public ServerResponse testIdempotence() {
        return ServerResponse.success("testIdempotence: success");
    }

//    @Override
//    public ServerResponse accessLimit() {
//        return ServerResponse.success("accessLimit: success");
//    }
//
//    @Override
//    public ServerResponse send(Mail mail) {
//        String msgId = RandomUtil.UUID32();
//        mail.setMsgId(msgId);
//
//        MsgLog msgLog = new MsgLog(msgId, mail, RabbitConfig.MAIL_EXCHANGE_NAME, RabbitConfig.MAIL_ROUTING_KEY_NAME);
//        msgLogMapper.insert(msgLog);// 消息入库
//
//        CorrelationData correlationData = new CorrelationData(msgId);
//        rabbitTemplate.convertAndSend(RabbitConfig.MAIL_EXCHANGE_NAME, RabbitConfig.MAIL_ROUTING_KEY_NAME, MessageHelper.objToMsg(mail), correlationData);// 发送消息
//
//        return ServerResponse.success(ResponseCode.MAIL_SEND_SUCCESS.getMsg());
//    }

}
