package com.atguigu.linkedlist;

public class SingleLinkedListDome {
    public static void main(String[] args) {
        HeroNode heroNode0 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode1 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode2 = new HeroNode(3, "吴勇", "智多星");
        HeroNode heroNode3 = new HeroNode(4, "林冲", "豹子头");
        //创建单链表
      SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(heroNode0);
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.list();

        //加入编号的顺序
       singleLinkedList.addByOrder(heroNode1);
       singleLinkedList.addByOrder(heroNode0);
       singleLinkedList.addByOrder(heroNode3);
       singleLinkedList.addByOrder(heroNode2);
       singleLinkedList.list();


       //修改节点的代码
        HeroNode heroNode5=new HeroNode(2,"小卢俊义","与狮子");
        singleLinkedList.upDate(heroNode5);
        singleLinkedList.list();
        singleLinkedList.del(4);
        singleLinkedList.list();
        System.out.println("---------------");
        System.out.println(getLength(singleLinkedList.getHead()));
        //测试一下是否得到了倒数第K个节点
        HeroNode res=findLastIndexNode(singleLinkedList.getHead(),4);
        System.out.println("res="+res);

    }
    //返回节点的有效个数
    public static int getLength(HeroNode head){
        if(head.next ==null){
            return 0;
        }
        int length=0;
        HeroNode cur=head.next;
        while(cur!=null){
            length++;
            cur=cur.next;

        }
        return length;
    }
    //查找单链表中的倒数第K个节点【新浪面试题】
    //思路：
    //1、编写一个方法，接收head节点，同时接收index节点
    //2、index表示倒数节点的第index节点
    //3、先把链表从头到尾的遍历。得到链表的总长度getLength
    //4、得到size后我们从链表的第一个开始遍历（size-index）个，就可以得到
    //如果找到了就返回该节点，否则返回null
    public static HeroNode findLastIndexNode(HeroNode head,int index) {
        //判断如果链表为空，返回null
        if (head.next == null) {
            return null;       //没有找到
        }
        //第一个遍历得到链表的长度
        int size = getLength(head);
        //第二次遍历size-index的位置，就是我们找的倒数的第k个节点
        //先做一个index的检验
        if (index <= 0 || index > size) {
            return null;
        }
       //定义辅助变量，
        HeroNode cur=head.next;
        for (int i = 0; i <size-index ; i++) {
                    cur=cur.next;
        }
        return cur;
    }
}
