package com.github.yulechen.datastruct.practise.dp;

public class BeiBao01 {

  public int knapsack1(int[] weigh,int n ,int w){
    boolean[][] states = new boolean[n][w + 1]; // 默认值false
    // 0 行初始数据，放入，不放入
    states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
    if (weight[0] <= w) {
      states[0][weight[0]] = true;
    }
    for(int i = 1 ;i< n ;i++){
      for(int j =0 ;j<=w;j++){  // 第i 个石头不放入
          if(states[i-1][j]==true){ // 重量不变 copy
            // 不放入
            states[i][j]=true;
            // 放入
            if(j+weigh[i]<=w){
              states[i][j+weigh[i]]=true;
            }
          }
      }
    }
    for (int i = w; i >= 0; --i) { // 输出结果
      if (states[n - 1][i] == true) {
        return i;
      }
    }


    return 0;
  }








  // weight:物品重量，n:物品个数，w:背包可承载重量
  public int knapsack(int[] weight, int n, int w) {
    boolean[][] states = new boolean[n][w + 1]; // 默认值false
    states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
    if (weight[0] <= w) {
      states[0][weight[0]] = true;
    }
    for (int i = 1; i < n; ++i) { // 动态规划状态转移
      for (int j = 0; j <= w; ++j) {// 不把第i个物品放入背包
        if (states[i - 1][j] == true) {
          states[i][j] = states[i - 1][j];
        }
      }
      for (int j = 0; j <= w - weight[i]; ++j) {//把第i个物品放入背包
        if (states[i - 1][j] == true) {
          states[i][j + weight[i]] = true;
        }
      }
    }
    for (int i = w; i >= 0; --i) { // 输出结果
      if (states[n - 1][i] == true) {
        return i;
      }
    }
    return 0;
  }


  // 回溯算法实现。注意：我把输入的变量都定义成了成员变量。
  private int maxW = Integer.MIN_VALUE; // 结果放到maxW中
  private int[] weight = {2, 2, 4, 6, 3};  // 物品重量
  private int n = 5; // 物品个数
  private int w = 9; // 背包承受的最大重量

  public void f(int i, int cw) { // 调用f(0, 0)
    if (cw == w || i == n) { // cw==w表示装满了，i==n表示物品都考察完了
      if (cw > maxW) {
        maxW = cw;
      }
      System.out.println(cw);
      return;
    }
    f(i + 1, cw); // 选择不装第i个物品
    if (cw + weight[i] <= w) {
      f(i + 1, cw + weight[i]); // 选择装第i个物品
    }
  }


  public static void main(String[] args) {
    BeiBao01 b= new BeiBao01();
    //b.f(0,0);

    int[] w={2,2,4,6,3};
    System.out.println(b.knapsack1(w, 5, 9));
    System.out.println(b.knapsack(w, 5, 9));
  }
}
