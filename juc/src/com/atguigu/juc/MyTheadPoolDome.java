package com.atguigu.juc;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author shkstart
 * @create 2019-12-17 19:47
 */
public class MyTheadPoolDome {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                1l,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()


        );
        try {
            for (int i = 1; i <=8; i++) {
                final int tmpe=i;
                threadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"受理业务"+"\t" +"客户号"+tmpe);
                });
            }
        }finally {
threadPoolExecutor.shutdown();
        }
    }
}
