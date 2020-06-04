package com.github.yulechen.datastruct.algorithm.recursion;

import java.util.Arrays;

/**
 * @Author: chenq
 * @Date: 2020/6/1  17:20
 */
public class MergeSort_01 {

  public static int[] merge_sort(int[] to_sort) {

    if (to_sort == null) {
      return new int[0];
    }

    // 如果分解到只剩一个数，返回该数
    if (to_sort.length == 1) {
      return to_sort;
    }

    // 将数组分解成左右两半
    int mid = to_sort.length / 2;
    int[] left = Arrays.copyOfRange(to_sort, 0, mid);
    int[] right = Arrays.copyOfRange(to_sort, mid, to_sort.length);

    // 嵌套调用，对两半分别进行排序
    left = merge_sort(left);
    right = merge_sort(right);

    // 合并排序后的两半
    int[] merged = merge(left, right);

    return merged;

  }
  public static int[] merge(int[] a, int[] b) {

    if (a == null) {
      a = new int[0];
    }
    if (b == null) {
      b = new int[0];
    }

    int[] merged_one = new int[a.length + b.length];

    int mi = 0, ai = 0, bi = 0;

    // 轮流从两个数组中取出较小的值，放入合并后的数组中
    while (ai < a.length && bi < b.length) {

      if (a[ai] <= b[bi]) {
        merged_one[mi] = a[ai];
        ai ++;
      } else {
        merged_one[mi] = b[bi];
        bi ++;
      }

      mi ++;

    }

    // 将某个数组内剩余的数字放入合并后的数组中
    if (ai < a.length) {
      for (int i = ai; i < a.length; i++) {
        merged_one[mi] = a[i];
        mi ++;
      }
    } else {
      for (int i = bi; i < b.length; i++) {
        merged_one[mi] = b[i];
        mi ++;
      }
    }

    return merged_one;

  }
}
