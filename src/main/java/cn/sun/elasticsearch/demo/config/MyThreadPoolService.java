package cn.sun.elasticsearch.demo.config;

import cn.sun.elasticsearch.demo.thread.MyThread;
import org.apache.catalina.Executor;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.concurrent.*;

/**
 * @Author: sunyufei
 * @Date: 2020-06-10 19:23
 **/
@Service
public class MyThreadPoolService{

    private  ExecutorService threadpool = new ThreadPoolExecutor(5,10,
            200,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(10));

    @PreDestroy
    public  void destroyExecutor(){
        System.out.println("线程池关闭------------！！！");
        threadpool.shutdown();
    }

    public  void handle(MyThread thread){
        threadpool.execute(thread);
    }
}
