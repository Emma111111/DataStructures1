package test.java;

public class test1  extends Thread{
    private static int count=30;
    public void run(){
        while(true){
            if(count<0){
                System.out.println("卖光了");
                break;
            }else{

            }
        }
    }



}
