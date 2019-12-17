package com.atguigu.queue;

import java.util.Scanner;

public class CircleArrayQueueDome {
    public static void main(String[] args) {
        //测试数组模拟环形队列
           //创建一个对象
        CircleArray arrayQueue = new CircleArray(4);
        char key=' ';  //接收用户的输入
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        while(loop){
            //输出一个菜单
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):给队列添加数据");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head)：显示队列头的数据");
            key=scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueque(value);
                    break;
                case 'g' :

                    try {
                        int res=arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res=arrayQueue.headQueue();
                        System.out.printf("取出头的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();;
                    loop=false;
                    break;

                    default:
                    break;
            }
        }
        System.out.println("程序退出");

    }
}

