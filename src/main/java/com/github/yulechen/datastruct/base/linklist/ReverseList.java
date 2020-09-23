package com.github.yulechen.datastruct.base.linklist;


import java.util.Stack;

/**
 * 单项链表反转
 */
public class ReverseList {


  public static void main(String[] args) {
    int[] array={1,2,3,4,5,6};
    Node node = convertArrayToList(array);
//    printList(node);
//    Node node1 = revertList(node);
//    printList(node1);

    Node node2= node;
    Node node3 = revertList2(node2);
    printList(node3);
  }


  /**
   * 定义数据结构
   */
  static class Node {

    int data;
    Node next;

    public int getData() {
      return data;
    }

    public void setData(int data) {
      this.data = data;
    }

    public Node getNext() {
      return next;
    }

    public void setNext(Node next) {
      this.next = next;
    }
  }


  // convert array to list
  static Node convertArrayToList(int[] data) {
    Node first = new Node();
    first.setData(data[0]);
    Node c =first;
    for (int i = 1; i < data.length; i++) {
      Node t = new Node();
      t.setData(data[i]);
      c.setNext(t);
      c= t;
    }
    return first;
  }




  /**
   * 使用栈
   * @param first
   * @return
   */
  static Node revertList(Node first) {
    Stack<Node> stack = new Stack();
    Node n = first;
    while(n!=null){
      stack.push(n);
      n = n.next;
    }
    // first ,技巧设置初始值。
    Node currentNode= stack.pop();
    Node firstNode =currentNode;
    while(!stack.isEmpty()){
      currentNode.next= stack.pop();
      currentNode= currentNode.next;
    }
    currentNode.next=null;
    return firstNode;

  }


  static Node revertList2(Node node) {
    // 最后一个节点
    if(node.next==null){
       return node;
    }
    // 上一步node
    Node returnNode= revertList2(node.next);
    // 上一步node.next = 当前node
    node.next.next=node;
    node.next=null;

    return returnNode;
  }

  static  void printList(Node list){
    Node temp= list;
    while(temp !=null){
      System.out.print(temp.data+"->");
      temp=temp.next;
    }
    System.out.println();
  }
  static  void printArray(int[] array){
    for (int i : array) {
      System.out.print(i+" ");
    }
    System.out.println();
  }
}
