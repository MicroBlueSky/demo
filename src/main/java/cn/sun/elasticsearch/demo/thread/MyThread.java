package cn.sun.elasticsearch.demo.thread;

/**
 * @Author: sunyufei
 * @Date: 2020-06-10 19:50
 **/
public class MyThread implements Runnable {

    private String name;
    private int count;

    public MyThread(String name,int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100000);
            System.out.println(Thread.currentThread().getName()+"------"+"当前数量："+count+"请求参数："+name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
