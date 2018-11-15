package com.github.yulechen.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
  S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

 J 中的字母不重复，J 和 S中的所有字符都是字母。
 字母区分大小写，因此"a"和"A"是不同类型的石头。
 示例 1:

 输入: J = "aA", S = "aAAbbbb"
 输出: 3
 示例 2:

 输入: J = "z", S = "ZZ"
 输出: 0
 注意:

 S 和 J 最多含有50个字母。
 J 中的字符不重复

 */
public class JewelsInStones {
    public static void main(String[] args) {
        JewelsInStones jsi =new JewelsInStones();

        String j="aA";
        String s="aAAbbbb";

        long start=System.currentTimeMillis();
        int i = jsi.numJewelsInStones(j, s);
        long end= System.currentTimeMillis()-start;
        System.out.println(end+"ms"+":"+i);
    }

    public int numJewelsInStones(String j, String s) {
        char[] schs = s.toCharArray();
        int count=0;
        for (char ch : schs) {
            if(j.contains(""+ch)){
                count++;
            }
        }
        return count;
    }

    public int numJewelsInStones1(String j, String s) {
        char[] jchs = j.toCharArray();
        char[] schs = s.toCharArray();
        Map<Character,Integer> cache = new HashMap<>();
        for (char ch : jchs) {
            cache.put(ch,0);
        }
        int count=0;
        for (char aChar : schs) {
              if(cache.get(aChar)!=null){
                  count++;
              }
        }

        return count;
    }


    /**
     * 字母ASCII表  0-127 个
     * @param J 50 个 不重复
     * @param S 50  个 可以重复
     * @return
     */
    public int numJewelsInStones3(String J, String S) {
        char[] jChs = J.toCharArray();
        char[] sChs = S.toCharArray();
        int[] tChs = new int[127];
        for (int i = 0; i < sChs.length; i++) {
            tChs[sChs[i]]++;
        }
        int count=0;
        for (int j = 0; j < jChs.length; j++) {
            if(tChs[jChs[j]]!=0)
                count += tChs[jChs[j]];
        }
        return count;
    }



}
