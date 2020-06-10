package cn.sun.elasticsearch.demo.controller;

import cn.sun.elasticsearch.demo.config.MyThreadPoolService;
import cn.sun.elasticsearch.demo.controller.base.BaseController;
import cn.sun.elasticsearch.demo.thread.MyThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程测试
 * @Author: sunyufei
 * @Date: 2020-06-10 19:17
 **/
@Controller
@RequestMapping("multi")
public class MultiThreadingController extends BaseController {

    private static volatile int count =0;

    @Autowired
    private MyThreadPoolService myThreadPoolService;
    
    @ResponseBody
    @RequestMapping("thread")
    public String test(String param){
        count++;
        MyThread thread = new MyThread(param,count);
        myThreadPoolService.handle(thread);
        return "success";
    }
    @ResponseBody
    @RequestMapping("test")
    public Map returnFlex(HttpServletRequest request) throws InterruptedException {
        Map<String,Object> result = new HashMap<>();
        result.put("1","1");
        String[] methods = {"a","b","c"};
        ExecutorService service = Executors.newFixedThreadPool(methods.length);
        CountDownLatch countDownLatch = new CountDownLatch(methods.length);
        for (String s : methods){
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String beginWeekDay = request.getParameter("name");
                        System.out.println("参数：" + beginWeekDay);
                        beginWeekDay.isEmpty();
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        countDownLatch.countDown();
                    }
                }
            });
        }
        countDownLatch.await();
        return result;
    }
}
