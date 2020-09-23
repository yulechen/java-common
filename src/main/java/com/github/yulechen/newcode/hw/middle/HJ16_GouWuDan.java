package com.github.yulechen.newcode.hw.middle;

import java.util.Scanner;

public class HJ16_GouWuDan {
/*

1000 5
800 2 0
400 5 1
300 5 1
400 3 0
500 2 0
-----
2200

============
1500 7
500 1 0
400 4 0
300 5 1
400 5 1
200 5 0
500 4 0
400 4 0
----
62000
 */

  public static void main(String[] args) {
//    int money=1000;
//    int count=5;
//    // money weight, p
//    int[][] items={{800 ,2 ,0},{400 ,5 ,1},{300, 5 ,1},{400 ,3, 0},{500, 2, 0}};
//    System.out.println(getMaxExcept(money, count, items));

    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
      int money= sc.nextInt();
      int count = sc.nextInt();
      int[][] items =new int[count][3];
      for(int i = 0;i< count ;i++)
         for(int j =0;j<3;j++)
           items[i][j]= sc.nextInt();

      System.out.println(getMaxExcept(money, count, items));
      System.out.println("===");
    }
    sc.close();

  }


  /**
   * @param money ：总金额
   * @param count ：items count
   * @param items i0=m ,i1=weight,i2=主从(1 开始 -1)
   * @return Sum(item = ( money * weight))
   */
  static int getMaxExcept(int money, int count, int[][] items) {
    // 1、初始化第一个数组
    int[][] states = new int[count][money+1];
    for (int i = 0; i < count; i++) {
      for (int j = 10; j < money; j=j+10) {
        states[i][j] = -1;
      }
    }

    // 3、初始化第一个状态
    // 买第一个物品
    int itemFirstMoney = items[0][0];
    int itemFirstWeight = items[0][1];
    if (itemFirstMoney <= money) {
      states[0][itemFirstMoney] = itemFirstWeight * itemFirstMoney;
    }
    // 不买第一个物品
    states[0][0] = 0;

    for (int i = 1; i < count; i++) {
      for (int j = 0; j <= money; j++) {
        if (states[i - 1][j] >= 0) {
          // 不买,copy
          states[i][j] = states[i - 1][j];
          // 购买 条件1、价钱购，2、主从关系对
          // 钱够
          if (j + items[i][0] <= money) {
            // 如果为主设备，直接购买,从设备必须主可以购买
            int mOrSlave = items[i][2];
            int masterIndex =0;
            int masterMoney= items[i][1];
            if(mOrSlave>0){
              masterIndex = mOrSlave - 1;
            }
           // if (mOrSlave == 0 || states[masterIndex][masterMoney] > 0) {
              states[i][j + items[i][0]] = states[i - 1][j] + items[i][0] * items[i][1];
          //  }

          }
        }

      }

    }

    for (int j = money; j >= 0; --j) { // 输出结果
      if (states[count - 1][j] >0) {
        System.out.println("money:"+j);
        System.out.println(states[count - 1][j]);
       // return states[count - 1][j];
      }
    }
    return 0;
  }

  private boolean has(int[] money){
    for (int m : money) {
      if(m>0){
        return true;
      }
    }
    return false;
  }





}
