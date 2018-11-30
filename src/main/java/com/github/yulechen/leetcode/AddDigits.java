package com.github.yulechen.leetcode;

public class AddDigits {

    /**
     *  给定一个非负整数 num
     *  输入: 38
     *  输出: 2
     *  解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
     *  你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(addDigits(1281999911));
    }

    /**
     * num%10 去余数,内存溢出
     * @param num
     * @return
     */
    public static int addDigits(int num) {
          if(num<10)
               return num;
          int next=0;
          int a= num;
          while(a>10){
              next+=a%10;
              a=a/10;
          }
          next+=a;
         return addDigits(next);
    }


    /**
     * 不用递归和循环,数学证明
     * @param num
     * @return
     */
    public static int addDigits1(int num) {
        return 1+(num-1)%9;
    }

}
