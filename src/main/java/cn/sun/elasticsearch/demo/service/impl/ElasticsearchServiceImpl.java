package cn.sun.elasticsearch.demo.service.impl;

import cn.sun.elasticsearch.demo.config.ElasticSearchConfig;
import cn.sun.elasticsearch.demo.service.ElasticsearchService;
import cn.sun.elasticsearch.demo.service.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.main.MainResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author: sunyufei
 * @Date: 2020-01-10 12:20
 **/
@Service
@Slf4j
public class ElasticsearchServiceImpl extends BaseService implements ElasticsearchService {


    @Resource
    private ElasticSearchConfig elasticSearchConfig;

    @Override
    public StringBuilder Hello(String id){
        RestHighLevelClient client = elasticSearchConfig.client();
        MainResponse response = null;
        try {
            log.info("连接es,获取es服务信息。。。。");
            response = client.info(RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回集群的各种信息
        StringBuilder builder = new StringBuilder();
        builder.append("ClusterName:"+response.getClusterName());
        builder.append("===== clusterUuid:"+response.getClusterUuid());
        builder.append("===== nodeName:"+response.getNodeName());
        builder.append("===== version:"+response.getVersion());
        builder.append("===== build:"+response.getBuild());
        return builder;
    }
}
