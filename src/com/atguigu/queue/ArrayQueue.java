package com.atguigu.queue;


    //使用数组模拟队列，写一个Arrayque类
    class ArrayQueue{
        private int maxsize;//设置数组的最大容量
        private  int front;// 队列头
        private  int rear;//队列尾
        private  int[] arr;
        public ArrayQueue(int arrMaxSize){
            maxsize=arrMaxSize;
            arr=new int [maxsize];
            front=-1;  //指向列队头，分析出front指向列队前一个位置
            rear=-1; //指向列队尾，指向列队的尾部数据

        }
        //判断队列是否已满
        public boolean isFull(){
            return rear==maxsize-1;
        }
        //判断队列是否为空
        public boolean isEmpty(){
            return front==rear;
        }
        //向队里里添加数据
        public void addQueque(int n ){
            //判断队列是否满
            if(isFull()){
                System.out.println("队列满，不能加入数据");
                return;
            }
            rear++;
            arr[rear]=n;

        }
        //从队列里取出数据，出队列
        public int getQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列以空，不能取数据");
            }
            front++;
            return arr[front];
        }
        //显示队列的所有数据
        public void showQueue(){
            if(isEmpty()){
                System.out.println("队列以空，不能显示数据");
                return;
            }
            for (int i = 0; i <arr.length ; i++) {
                System.out.printf("arr[%d]=%d\n",i,arr[i]);
            }
        }
        //显示队列的头数据
        public int headQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列以空，不能显示数据");
            }
            return arr[front+1];
        }
    }

