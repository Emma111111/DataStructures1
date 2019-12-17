package com.atguigu.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author shkstart
 * @create 2019-12-16 22:17
 */


class MyCache{
    private volatile Map<String,String> map=new HashMap<>();
    ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    public void put(String key,String value){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写入开始");
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入结束");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
    }
    public void get(String key){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读取开始");
            String s = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取结束"+s);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
    }
}
public class ReadWriteLockDome {
    public static void main(String[] args) {
        MyCache myCache=new MyCache();
          for(int i=1;i<=10;i++){
             new Thread(()->{
                 myCache.put("temp","temp");
             },String.valueOf(i)).start();

           }
          for(int i=1;i<=10;i++){
             new Thread(()->{
                 myCache.get("temp");
             },String.valueOf(i)).start();

           }
    }
}
