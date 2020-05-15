package cn.sun.elasticsearch.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 * @Author: sunyufei
 * @Date: 2020-05-14 17:11
 **/
@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private String port;
    @Value("${spring.redis.timeout}")
    private String timeout;

    @Bean
    public JedisPool redisPoolFactory(){
        JedisPool jedisPool = new JedisPool(host, Integer.valueOf(port));
        return jedisPool;
    }
}
