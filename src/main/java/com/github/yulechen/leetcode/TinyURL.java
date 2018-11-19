package com.github.yulechen.leetcode;


import java.util.HashMap;
import java.util.Map;

/***
 *
 * 全局map 存储
 *
 * leetcode.com/problems/design-tinyurl  --> 111  --> 62 进制 6 位
 * 111 -- leetcode.com/problems/design-tinyurl
 *
 */
public class TinyURL {



    private  char[] table = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    private int count =0;
    private Map cacheShort = new HashMap<>();

    public String encode(String longUrl) {
        int key= count++;
        cacheShort.put(key,longUrl);
        return ""+key;
    }


    public String decode(String shortUrl) {
         return (String)cacheShort.get(Integer.parseInt(shortUrl));
    }


    public int base62ToBase10(String base62) {
        int n = 0;
        for (int i = 0; i < base62.length(); ++i) {
            n = n * 62 + getCharIndex(base62.charAt(i));
        }
        return n;
    }

    private int getCharIndex(char c) {
        return 0;
    }


    public String base10ToBase62(int n) {
//        String str = "";
//        while (n != 0) {
//            str.insert(str.begin(), elements[n % 62]);
//            n /= 62;
//        }
//        while (str.size() != 6) {
//            str.insert(str.begin(), '0');
//        }
//        return str;
        return null;
    }

    public static void main(String[] args) {
        String longUrl="https://leetcode.com/problems/design-tinyurl";
        TinyURL codec = new TinyURL();
        String longUrlDecoded = codec.decode(codec.encode(longUrl));
        System.out.println(longUrlDecoded.equals(longUrl));

    }


}
