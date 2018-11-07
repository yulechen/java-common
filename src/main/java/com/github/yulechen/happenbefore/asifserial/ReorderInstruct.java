package com.github.yulechen.happenbefore.asifserial;

/**
 * 指令重排序
 */
public class ReorderInstruct {
    private int a;
    private int b;
    private int  c;

    // sginle thread run this code
    public int  addAB(){
         a=1;
         b=2;
         c=a+b;
         return c;

        /**
             CPU may be run as this order
             b=2;
             a=1;
             c=a+b;
             return a+b;
         */
    }









}
