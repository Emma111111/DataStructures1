package com.atguigu.linkedlist;
//创建一个环形的单向链表
class CircleSingleLinkedList{
    //创建一个first节点，当前没有编号
    private Boy first=null;
    //添加小孩节点，构成一个环形链表
    public void addBoy(int nums) {//nums代表一共添加多少个小孩
        //先做一个nums校验
        if(nums<2){
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy=null;
        //使用for循环创建环形链表
        for (int i = 1; i <=nums ; i++) {
            //根据编号创建小孩节点
             Boy boy=new Boy(i);
             //如果是第一个小孩
             if(i==1){
                 first=boy;
                 first.setNext(first); //构成环
                 curBoy=first;

             }else{
                 curBoy.setNext(boy);
                 boy.setNext(first);
                 curBoy=boy;//
             }
        }
    }
    //遍历当前的循环列表
    public void showBoy(){
        //判断列表是否为空
        if(first==null){
            System.out.println("列表为空");
            return;
        }
        Boy curBoy=first;
        while(true){
            System.out.printf("小孩的编号是%d\n",curBoy.getNo());
            if(curBoy.getNext()==first) {//说明已近遍历完毕
                break;

            }
            curBoy=curBoy.getNext();
        }
    }
}
public class Josnpfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(20);
        circleSingleLinkedList.showBoy();
    }
}
//表示一个节点
class Boy{
    private int no ;
    private Boy next;
    public Boy(int no){
        this.no=no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy getNext() {

        return next;
    }
}