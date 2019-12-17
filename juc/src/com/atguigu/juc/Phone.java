package com.atguigu.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author shkstart
 * @create 2019-12-16 18:15
 */
class Phone {

    public static synchronized void sendPhone () throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("sendEmail***********");
    }

    public  synchronized void sendMsg(){
        System.out.println("sendSMS*********");
    }
    public void hello(){
        System.out.println("hello");
    }
}

class Lock8{
    public static void main(String[] args) throws Exception {
        Phone p1=new Phone();
        Phone p2=new Phone();
        new Thread(()->{
            try {
                p1.sendPhone();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();

        Thread.sleep(100);
        new Thread(()->{
            try {
                p2.sendMsg();
               // p1.hello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}
