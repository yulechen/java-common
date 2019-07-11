package com.github.yulechen.datastruct.base.heap;

/**
 * @Author: chenq
 * @Date: 2019/7/8  下午3:57
 */
public interface Heap {


  void insert(int a);

  void print();

  void init(int[] arr);

  int getSize();

  int setSize(int size);

  int popTop();

}
