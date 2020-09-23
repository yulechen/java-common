package com.github.yulechen.charset;

public class CharPair {


  public static void main(String[] args) {
    // 𐐀 是unicode 扩展字符，java 用两个char 来表示
    // igh-surrogates range, (\uD800-\uDBFF),
    // the second from the low-surrogates range (\uDC00-\uDFFF).
    System.out.println("𐐀".length());
  }
}
