package com.atguigu.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author shkstart
 * @create 2019-12-17 10:57
 */


public class SaleTicketDome {
    public static void main(String[] args) {
        Ticket t1=new Ticket();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
         for(int i=1;i<=30;i++){
            executorService.execute(()-> t1.sale());
          }
    }
}
