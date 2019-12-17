package com.atguigu.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shkstart
 * @create 2019-12-16 21:02
 */

class ShareResource{
    private int flag=1;
    Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    void print5(){
        lock.lock();
                try {
                  while(flag!=1) {
                      condition.await();
                  }
                    for (int i = 0; i <5 ; i++) {
                        System.out.println("AAA");
                    }
                    flag=2;
                    condition.signal();
                }
                 catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
    }
    void print10(){
        lock.lock();
                try {
                  while(flag!=2) {
                      condition.await();
                  }
                    for (int i = 0; i <10 ; i++) {
                        System.out.println("BBB");
                    }
                    flag=3;
                    condition.signal();
                }
                 catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
    }
    void print15(){
        lock.lock();
                try {
                  while(flag!=3) {
                      condition.await();
                  }
                    for (int i = 0; i <15 ; i++) {
                        System.out.println("CCC");
                    }
                    flag=1;
                    condition.signal();
                }
                 catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
    }

}
public class TheadOrderAccess {

    public static void main(String[] args) {
           ShareResource shareResource=new ShareResource();
           new Thread(()->{
               for (int i = 1; i <=5 ; i++) {
                   shareResource.print5();
               }
           }, "A").start();
           new Thread(()->{
               for (int i = 1; i <=10 ; i++) {
                   shareResource.print10();
               }
           }, "B").start();
           new Thread(()->{
               for (int i = 1; i <=15 ; i++) {
                   shareResource.print15();
               }
           }, "C").start();

    }
}
