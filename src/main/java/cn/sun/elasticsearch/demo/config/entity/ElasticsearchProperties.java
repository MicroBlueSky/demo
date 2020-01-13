package cn.sun.elasticsearch.demo.config.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: sunyufei
 * @Date: 2020-01-10 10:35
 **/
@Data
@Component
@ConfigurationProperties(prefix = "elasticsearch")
public class ElasticsearchProperties {
    private String host;
    private Integer port;
}
