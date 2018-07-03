package com.github.yulechen.interrupt;

public class MyTask  extends   Thread{

    public String name ="";
    @Override
    public void run() {
        while( !isInterrupted()){
            while(true) {
                try {
                    Thread.sleep(500);
                    System.out.println(name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return ;
                }
            }

        }
    }
}
