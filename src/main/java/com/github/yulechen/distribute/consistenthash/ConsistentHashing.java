package com.github.yulechen.distribute.consistenthash;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 为了解决：hash 表扩容，缩容对已有hash 值落到的节点影响。减少数据搬移
 *
 * @Author: chenq
 * @Date: 2019/6/20  上午9:33
 */
public class ConsistentHashing {

  private ArrayList<String> nodes = new ArrayList<>();

  private static int getHash(String str) {
    final int p = 16777619;
    int hash = (int) 2166136261L;
    for (int i = 0; i < str.length(); i++) {
      hash = (hash ^ str.charAt(i)) * p;
    }
    hash += hash << 13;
    hash ^= hash >> 7;
    hash += hash << 3;
    hash ^= hash >> 17;
    hash += hash << 5;

    // 如果算出来的值为负数则取其绝对值
    if (hash < 0) {
      hash = Math.abs(hash);
    }
    return hash;
  }

  public static void main(String[] args) {
    ConsistentHashing ch = new ConsistentHashing();
    // init
    ch.addNode("{Node1}");
    ch.addNode("{Node5}");
    ch.addNode("{Node2}");
    String[] requests = {"r1","r2","r3","r4","r5"};

    // origin,hash 不均匀
    for (String request : requests) {
      String node = ch.getConsistentNode(request);
      System.out.println(request +"->"+node);
    }

    System.out.println("AFTER REMOVE  NODE1");
    // if remove node ，所有值请求节点都发生了变化
    ch.removeNode("Node1");
    for (String request : requests) {
      String node = ch.getConsistentNode(request);
      System.out.println(request +"->"+node);
    }
    // NODE 名称加salt ，然hash 更均匀
    ch.addNode("ccc{Node1}ppp");
    ch.addNode("sdf{Node5}sdf");
    ch.addNode("{Node2}");

    for (String request : requests) {
      String node = ch.getConsistentNode(request);
      // find {} is node name.
      System.out.println(request +"->"+node);
    }


  }

  public void addNode(String nodeName) {
    nodes.add(nodeName);
    Collections.sort(nodes,(s1,s2)-> getHash(s1)-getHash(s2));
  }

  public String getNode(String request) {
    int hash = getHash(request);
    int index= hash &(nodes.size()-1); //
    return nodes.get(index);
  }

  public String getConsistentNode(String request) {
    int hash = getHash(request);

    // 优化计算,size  是变化的，所以计算出index ，会受到添加，删除元素的影响
    // 改进，依据元素本身的hash 值来计算 ，元素本身的hash 值不会发生变化。
    // 然后依据 请求的hash 值，在元素的hash 值内查找。变化的概率减少了。
    for (String node : nodes) {
      // node 值不发生变化，hash 值不会发生变化。
      int nodeHash = getHash(node);// hash 值从小到大排序
      if(nodeHash >=hash ){
        return node;
      }
    }
    return nodes.get(0);
  }

  public void removeNode(String nodeName) {
    nodes.remove(nodeName);
    Collections.sort(nodes,(s1,s2)-> getHash(s1)-getHash(s2));
  }


}
