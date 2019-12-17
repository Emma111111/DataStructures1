package com.atguigu.linkedlist;
//定义singlelinkedlist,管理我们的英雄
 class SingleLinkedList {
    //先初始化一个头结点，头结点不要动，不存放具体的数据

    private HeroNode head = new HeroNode(0, "", "");
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //思路；当不考虑编号顺序时，
    //1、找到当前链表的最后节点
    //2、将最后节点的next指向新的节点
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助遍历Temp
        HeroNode temp = head;
        //遍历列表，找到最后
        while (true) {
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;

        }
        temp.next = heroNode;
        //当退出while循环时，temp就指向了链表的最后
        //将最后节点的next指向新的节点
    }

    //显示链表
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为head节点不能动，因此我们需要一个辅助遍历Temp
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }

    //第二种方式，在添加英雄时，根据排名将英雄添加到指定位置
    //(如果有这个排名则添加失败，并给出提示)
    public void addByOrder(HeroNode heroNode) {
        //因为单链表的头结点不能动，因此我们需要一个辅助指针来帮助找到添加的位置
        //因为单链表，因为我们要找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;//标志添加的编号是否存在，默认为flase
        while (true) {
            if (temp.next == null) { //说明temp已在列表的最后
                break;
            }
            if (temp.next.no > heroNode.no) { //位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) { //说明编号已存在
                flag = true;
                break;
            }
            temp = temp.next;//后移，遍历当前列表
        }
        //判断flag的值
        if (flag) {
            //说明编号存在，不能添加
            System.out.printf("您输入的英雄编号%d已经存在,不能添加\n", heroNode.no);
        } else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息，根据no编号来修改，no编号不能修改
    public void upDate(HeroNode newHeroNode) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no来节点
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (temp == null) {  //说明已经遍历完了列表
                break;
            }
            if (temp.no==newHeroNode.no ){  //说明已近找到了
                flag=true;
                break;
            }
            temp=temp.next;

        }
        if(flag){
            temp.name=newHeroNode.name;
            temp.nickName=newHeroNode.nickName;
        }else{  //没有找到
            System.out.printf("没有找到编号%d的节点，不能修改\t",newHeroNode.no);
        }
    }
    public void del(int no){
        HeroNode temp=head;
        boolean flag=false;
        while(true){
        if(temp.next==null){
            break;
        }
        if(temp.next.no==no){
            flag=true;
            break;
        }
        temp=temp.next;
    }
        if(flag){
            temp.next=temp.next.next;
        }else{
            System.out.printf("您要删除的节点%d不存在",no);
        }
}

 }