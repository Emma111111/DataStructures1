package com.atguigu.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shkstart
 * @create 2019-12-16 19:16
 */

//资源类
class Airconditioner {
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    public void increment() {  //生产者
        lock.lock();
        try {
            while(num != 0) {
                condition.await();
            }
            ++num;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decement() {  //消费者
        lock.lock();
        try {
            while (num == 0) {
                condition.await();
            }
            --num;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
public class TheadWaitNottifyDome {
    public static void main(String[] args) {


        Airconditioner airconditioner=new Airconditioner();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
              airconditioner.increment();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
              airconditioner.decement();
            }
        },"B").start();
    }


}