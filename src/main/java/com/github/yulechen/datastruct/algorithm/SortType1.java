package com.github.yulechen.datastruct.algorithm;

/**
 * N^2 sort
 *
 *
 */
public class SortType1 {

  static int[] UN_SORT_ARR = {1, 7, 3, 12, 6, 2, 3, 4, 39, 8};

  public static void outputArr(int[] arr) {
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  /**
   * 名称：冒泡排序
   * 原地排序
   * 稳定排序
   * 时间复杂度 min：n^2 max：n^2 avg：n^2
   *
   * 核心算法：
   * 1、当前元素和下一个元素比较，当前元素大于下一个元素就交换。
   * 2、比较次数 1->N,1->N-1,1->N-2,1->1
   */
  public static int[] bubbleSort(int[] unSortArr) {
    int length = unSortArr.length;
    for (int i = length; i > 0; i--) {
      for (int j = 0; j < i - 1; j++) {
        int current = unSortArr[j];
        int next = unSortArr[j + 1];
        if (current > next) {
          int temp = unSortArr[j];
          unSortArr[j] = next;
          unSortArr[j + 1] = temp;
        }
      }
    }
    return unSortArr;
  }

  /**
   * 优化版本：如果某一次排序没有发生交换操作，则排序完成。
   */
  public static int[] bubbleSortOptimize(int[] unSortArr) {
    int length = unSortArr.length;
    for (int i = length; i > 0; i--) {
      // 乐观判断，假如已经排好序了
      boolean isOrderFinish = true;
      for (int j = 0; j < i - 1; j++) {
        int current = unSortArr[j];
        int next = unSortArr[j + 1];
        if (current > next) {
          int temp = unSortArr[j];
          unSortArr[j] = next;
          unSortArr[j + 1] = temp;
          isOrderFinish = false;
        }
      }
      if (isOrderFinish) {
        break;
      }
    }
    return unSortArr;
  }


  /**
   * 名称：选择排序
   * 核心算法：分为两个区域，有序区，无序区。将无序区里面最小的元素，放在有序区末尾，
   * 优化冒泡排序：减少了数据交换次数 次数：1-N ,2-N,3-N
   */
  public static int[] selectSort(int[] unSortArr) {
    int length = unSortArr.length;
    for (int i = 0; i < length; i++) {
      // 记录最小值索引
      int minIndex = i;
      for (int j = i; j < length; j++) {
        if (unSortArr[j] < unSortArr[minIndex]) {
          minIndex = j;
        }
      }
      // 优化点，减少交换次数
      int temp = unSortArr[minIndex];
      unSortArr[minIndex] = unSortArr[i];
      unSortArr[i] = temp;
    }
    return unSortArr;
  }

  /**
   * 名称：插入排序 （）
   * 核心算法：将无序列表中的一个元素，插入到有序列表正确的位置上。
   * 不交换元素，插入元素后移动元素
   * 循环：1-n,
   * 优化：使用哨兵简化边界值判断,使用第0 位
   * @param unSortArr
   * @return
   */
  public static int[] insertionSort(int[] unSortArr) {
    int length = unSortArr.length;
    for(int i=0;i<length;i++){
      int prepareInsert= unSortArr[i];
      //  找到位置插入,并且移动元素
      for(int j=i-1;j>=0;j--){
        int sortedElement= unSortArr[j];
        if(sortedElement>prepareInsert){
          // 后移
          unSortArr[j+1]=unSortArr[j];
          // 处理边界值
          if(j==0){
            unSortArr[j]=prepareInsert;
          }
        }else{
          unSortArr[j+1]=prepareInsert;
          break;
        }
      }
    }
    return unSortArr;
  }

  /**
   * use while
    * @param arr
   * @return
   */
  public static int[] insertionSortOptimize(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; ++i) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = key;
    }
    return arr;
  }

  public static void main(String[] args) {
    // outputArr(bubbleSort(UN_SORT_ARR.clone()));
    // outputArr(bubbleSortOptimize(UN_SORT_ARR.clone()));
   // outputArr(selectSort(UN_SORT_ARR.clone()));
   outputArr(insertionSort(UN_SORT_ARR.clone()));
   outputArr(insertionSortOptimize(UN_SORT_ARR.clone()));

  }
}
