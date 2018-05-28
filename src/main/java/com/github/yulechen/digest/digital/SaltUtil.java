package com.github.yulechen.digest.digital;

public class SaltUtil {

    public static final String slat="aabbcc";

    public static String saltSrc(String src){
        return slat+src;
    }
}
