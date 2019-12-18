package com.atguigu.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author shkstart
 * @create 2019-12-18 18:50
 * 减少计数
 */
public class CountDownLatchDome {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(8);
         for(int i=1;i<=8;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t"+"学生离开教师");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
         }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t"+"班长关门走人");
    }
}
