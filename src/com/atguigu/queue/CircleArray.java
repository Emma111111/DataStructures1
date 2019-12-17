package com.atguigu.queue;


    //使用数组模拟队列，写一个Arrayque类
    class CircleArray {
        private int maxsize;//设置数组的最大容量
        private  int front;// 队列头
        private  int rear;//队列尾
        private  int[] arr;
        public CircleArray(int arrMaxSize){
            maxsize=arrMaxSize;
            arr=new int [maxsize];
            front=0;  //指向队列的第一个元素
            rear=0; //指向队列倒数第二个元素，为了预留一个位置


        }
        //判断队列是否已满
        public boolean isFull(){
            return (rear+1)%maxsize==front;
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
            //将数据加入
            arr[rear]=n;
            //让rear后移，这里必须考虑取模
            rear=(rear+1)%maxsize;

        }
        //从队列里取出数据，出队列
        public int getQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列以空，不能取数据");
            }
            //这里需要分析出front是指向队里的第一个元素；
            //1、先把front的值保留在一个临时变量
            //2、将front后移，考虑取模
            //3、将临时保存的变量返回
            int value=arr[front];
            front=(front+1)%maxsize;
            return value;

        }
        //显示队列的所有数据
        public void showQueue(){
            if(isEmpty()){
                System.out.println("队列以空，不能显示数据");
                return;
            }
            for (int i = front; i <front+size(); i++) {
                System.out.printf("arr[%d]=%d\n",i%maxsize,arr[i%maxsize]);
            }
        }
        //显示当前队里的有效数据
         public int size(){
            return (rear+maxsize-front)%maxsize;
         }
        //显示队列的头数据
        public int headQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列以空，不能显示数据");
            }
            return arr[front];
        }
    }

