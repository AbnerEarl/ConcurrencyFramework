package com.frank.ycj520.networkrequest.http;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManage {
    //1.把任务添加到请求队列
    private LinkedBlockingQueue<Runnable> queue=new LinkedBlockingQueue<>();
    public void execute(Runnable runnable){
        if (runnable!=null) {
            try {
                queue.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //2.把队列中的人物放入到线程池
    private ThreadPoolExecutor threadPoolExecutor;
    private ThreadPoolManage(){
        threadPoolExecutor=new ThreadPoolExecutor(4,20,15,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(4),rejectedExecutionHandler);

        //开启
        threadPoolExecutor.execute(runnable);
    }
    private RejectedExecutionHandler rejectedExecutionHandler=new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {

            //runnable是超时的线程
            try {
                queue.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    };

    //3.执行任务
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            while (true){
                Runnable runnable=null;
                //从队列中取出请求
                try {
                    runnable=queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(runnable!=null){
                    threadPoolExecutor.execute(runnable);
                }

            }
        }
    };


    //提供一个单例模式

    private static ThreadPoolManage instance=new ThreadPoolManage();

    public static ThreadPoolManage getInstance() {
        return instance;
    }
}
