package com.atguigu.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket {

    private int num = 30;
    private Lock lock = new ReentrantLock();
      public void sale() {
        lock.lock();
        try {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + (num--) + "张票,还剩" + num + "张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}

class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 35; i++) ticket.sale();
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 35; i++) ticket.sale();
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 35; i++) ticket.sale();
        }, "C").start();

    }
}