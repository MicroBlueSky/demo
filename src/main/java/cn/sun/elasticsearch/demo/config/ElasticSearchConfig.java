package cn.sun.elasticsearch.demo.config;

import cn.sun.elasticsearch.demo.config.entity.ElasticsearchProperties;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: sunyufei
 * @Date: 2020-01-10 10:19
 **/
@Configuration
public class ElasticSearchConfig {

    @Autowired
    private ElasticsearchProperties properties;

    @Bean(destroyMethod = "close")
    public RestHighLevelClient client(){
        return new RestHighLevelClient(RestClient.builder(new HttpHost(properties.getHost(),properties.getPort(),"http")));
    }
}
