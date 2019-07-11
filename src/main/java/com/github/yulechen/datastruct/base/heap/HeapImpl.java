package com.github.yulechen.datastruct.base.heap;

import java.util.ArrayList;

/**
 * @Author: chenq
 * @Date: 2019/7/9  上午10:09
 */
public class HeapImpl implements Heap {

  ArrayList<Integer> array = new ArrayList();

  public HeapImpl() {
    array.add(0);
  }

  public static void main(String[] args) {
    HeapImpl h = new HeapImpl();
    h.init(new int[]{4, 1, 3, 6, 5, 7});
    h.print();
    int element = -1;
    while (element != 0) {
      element = h.popTop();
      System.out.println(element);
    }
  }

  /**
   * 从下往上
   */
  // 7,5,6,4,2,1
  @Override
  public void insert(int a) {
    array.add(a);
    int size = getSize();
    for (int index = size - 1; index >= 1; index = index / 2) {
      Integer currentNode = getCurrentNode(index);
      Integer parent = getParentNode(index);
      if (currentNode > parent && index > 1) {
        swapIndex(index, index / 2);
      } else {
        break;
      }
    }


  }

  @Override
  public void print() {
    //printInter(1);
    for (Integer integer : array) {
      System.out.print(integer + "  ");
    }
    System.out.println();
  }


  // 按照图形打印
  private void printInter(int index) {
    if (index >= getSize()) {
      return;
    }
    Integer currentNode = getCurrentNode(index);
    System.out.println(currentNode);
    // left
    printInter(index * 2);
    // right
    printInter(index * 2 + 1);
  }

  private String getSpaceString(int index) {
    return "";
  }

  private Integer getCurrentNode(int index) {
    if (index >= getSize()) {
      return null;
    }
    return array.get(index);
  }

  private Integer getLeftNode(int index) {
    int leftIndex = index * 2;

    if (leftIndex >= getSize()) {
      return null;
    }
    return array.get(leftIndex);
  }

  private Integer getRightNode(int index) {
    int rightIndex = index * 2 + 1;
    if (rightIndex >= getSize()) {
      return null;
    }
    return array.get(rightIndex);
  }

  private Integer getParentNode(int index) {
    return array.get(index / 2);
  }

  private void swapIndex(int i1, int i2) {
    int i2Data = array.get(i2);
    array.set(i2, array.get(i1));
    array.set(i1, i2Data);
  }

  @Override
  public void init(int[] arr) {
    for (int a : arr) {
      insert(a);
    }
  }

  @Override
  public int getSize() {
    return array.size();
  }

  @Override
  public int setSize(int size) {
    return 0;
  }

  @Override
  public int popTop() {
    int lastIndex = getSize() - 1;
    if (lastIndex == 0) {
      return 0;
    }
    Integer topElement = array.get(1);
    swapIndex(1, lastIndex);
    for (int i = 1; i < lastIndex - 1; ) {
      Integer currentNode = getCurrentNode(i);
      Integer leftNode = getLeftNode(i);
      if (i * 2 >= lastIndex) {
        leftNode = null;
      }
      if (leftNode == null) {
        break;
      }
      Integer rightNodeNode = getRightNode(i);
      if (i * 2 + 1 >= lastIndex) {
        rightNodeNode = null;
      }
      // leftNode is Max
      if (rightNodeNode != null && currentNode < leftNode && leftNode > rightNodeNode) {
        swapIndex(i, i * 2);
        i = i * 2;
      } else if (rightNodeNode != null && currentNode < rightNodeNode && rightNodeNode > leftNode) {
        swapIndex(i, i * 2 + 1);
        i = i * 2 + 1;
      } else if (rightNodeNode == null && currentNode < leftNode) {
        swapIndex(i, i * 2);
        i = i * 2;
      } else {
        break;
      }

    }

    array.remove(lastIndex);
    return topElement;
  }
}
