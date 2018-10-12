package com.github.yulechen.hashmap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.LockSupport;

/**
 * hashMap GC 测试
 * <p>
 * gc 原理 ，指针不可达  object =null；
 */
public class HashMapGcTest {

    private static Map<String, Long> cache = new HashMap<>();

    public static void main(String[] args) throws InterruptedException, IOException {
        // long 8 个字节
        System.out.println("start。"+cache.size());
        System.gc();

        Thread.sleep(20*1000);
        System.out.println("clear.");
        addKeys();
       // cache=null;
        System.gc();
        System.out.println("清空缓存。"+cache.size());
        cache.forEach((k,v)->{
            System.out.println(k+v);
        });
        LockSupport.park();


    }


    public static void addKeys() throws InterruptedException {
        Long i = 1l;
        for (int j = 1; j < 10; j++) {
            Thread.sleep(3000);
            for (; i < 4096 * j; i++) {
                cache.put(""+i, i);
            }
            System.out.println("缓存条数"+cache.size());
        }


    }

    public void testClear() {

    }


    public void testRemove() {

    }

    public void testNullHashMap() {

    }


}
