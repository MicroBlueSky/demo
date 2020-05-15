package cn.sun.elasticsearch.demo.filter.impl;

import cn.sun.elasticsearch.demo.common.Constant;
import cn.sun.elasticsearch.demo.common.ResponseCode;
import cn.sun.elasticsearch.demo.common.ServerResponse;
import cn.sun.elasticsearch.demo.common.utils.JedisUtil;
import cn.sun.elasticsearch.demo.common.utils.RandomUtil;
import cn.sun.elasticsearch.demo.exception.ServiceException;
import cn.sun.elasticsearch.demo.filter.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: sunyufei
 * @Date: 2020-05-14 19:37
 **/
@Service
public class TokenServiceImpl implements TokenService {
    private static final String TOKEN_NAME = "token";

    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public ServerResponse createToken() {
        String str = RandomUtil.UUID32();
        StringBuilder token = new StringBuilder();
        token.append(Constant.Redis.TOKEN_PREFIX).append(str);
        jedisUtil.set(token.toString(), token.toString(), Constant.Redis.EXPIRE_TIME_MINUTE);
        return ServerResponse.success(token.toString());
    }

    @Override
    public void checkToken(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_NAME);
        if (StringUtils.isBlank(token)){
            token = request.getParameter(TOKEN_NAME);
            if (StringUtils.isBlank(token)){
                throw new RuntimeException("未获取到token信息");
            }
        }
        if (!jedisUtil.exists(token)) {
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
        }

        Long del = jedisUtil.del(token);
        if (del <= 0) {
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
    }
}
