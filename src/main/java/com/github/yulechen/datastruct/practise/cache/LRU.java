package com.github.yulechen.datastruct.practise.cache;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * last recently used;
 */
public class LRU {

  private LinkedList<Integer> cache = new LinkedList<>();

  private int size=5;

  // if key is exit ,return ,and mark used recently
  // if size > size ,remove key
  public int getKey(int key){
    for (Integer cached : cache) {
      if(cached==key){
          // deleted cached ,and move key to first
         cache.remove((Integer) key);
         cache.addFirst(key);
         return key;
      }
    }
    // 判断有没有空间，没有空间，移除最后一个元素
    if(cache.size() == size){
         System.out.println("空间不够，删除最后一个");
         cache.addFirst(key);
         cache.removeLast();
    }else{
      cache.addFirst(key);
    }
    return key;
  }


  public void display(){
    cache.forEach(System.out::println);
  }

  public static void main(String[] args) {
     LRU lru =new LRU();

     lru.getKey(1);
     lru.getKey(2);
     lru.getKey(3);
     lru.getKey(4);
     lru.getKey(5);
     lru.getKey(6);
     lru.getKey(7);

     lru.display();

    LinkedHashMap  lruLinedHashMap = new LinkedHashMap(16,0.75f,true);

    lruLinedHashMap.put(1,"a");
    lruLinedHashMap.put(2,"b");
    lruLinedHashMap.put(4,"ac");
    lruLinedHashMap.put(3,"ad");

    lruLinedHashMap.forEach((k,v)->System.out.println(""+k));

    lruLinedHashMap.get(4);


    System.out.println("--");
    lruLinedHashMap.forEach((k,v)->System.out.println(""+k));

    // remove first element
    lruLinedHashMap.remove(lruLinedHashMap.entrySet().iterator().next());
  }

}
