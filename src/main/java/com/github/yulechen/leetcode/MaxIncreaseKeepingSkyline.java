package com.github.yulechen.leetcode;

/**
 * https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/
 */
public class MaxIncreaseKeepingSkyline {

  public static void main(String[] args) {

    int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
    System.out.println(maxIncreaseKeepingSkyline(grid));

  }

  public static  int maxIncreaseKeepingSkyline(int[][] grid) {
    int[] rowMaxs = new int[grid.length];
    int[] columnMaxs = new int[grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      int rowMax = 0;
      for (int j = 0; j < grid[i].length; j++) {
         rowMax = grid[i][j] > rowMax ? grid[i][j] : rowMax;
      }
      rowMaxs[i] = rowMax;
    }


    for (int j = 0; j < grid[0].length; j++) {
      int columnMax = 0;
      for (int i = 0; i < grid.length; i++) {
        columnMax = grid[i][j] > columnMax ? grid[i][j] : columnMax;
      }
       columnMaxs[j] = columnMax;
    }
    int maxAddCount = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
          int minMax=rowMaxs[i]< columnMaxs[j]?rowMaxs[i]:columnMaxs[j];
           if(grid[i][j]<minMax){
              maxAddCount=maxAddCount+(minMax-grid[i][j]);
           }
      }

    }
    return maxAddCount;
  }


}
