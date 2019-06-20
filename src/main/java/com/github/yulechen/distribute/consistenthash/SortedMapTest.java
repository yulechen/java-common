package com.github.yulechen.distribute.consistenthash;

import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapTest {
    private static SortedMap<Integer, String> virtualNodes = new TreeMap<Integer, String>();
    public static void main(String[] args) {
        virtualNodes.put(1,"a");
        virtualNodes.put(2,"b");
        virtualNodes.put(3,"c");
        for(int i=0;i<10 ;i++){
            SortedMap<Integer, String> integerStringSortedMap = null;
            // 超过最大节点的值，使用第一个节点
            // 构建hash 环
            integerStringSortedMap = virtualNodes.tailMap(i>virtualNodes.lastKey()?
                    virtualNodes.firstKey():i);
            Integer integer = integerStringSortedMap.firstKey();
            System.out.println(i+"----> "+integerStringSortedMap.get(integer));
        }

    }

}
