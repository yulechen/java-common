package com.github.yulechen.charset;

import io.netty.buffer.ByteBufUtil;
import java.io.UnsupportedEncodingException;

public class Main {

  public static void main(String[] args) throws UnsupportedEncodingException {
//    String str = "中";
//    byte[] bytes = str.getBytes("GBK");
//    System.out.println(ByteBufUtil.hexDump(bytes));
//    bytes = str.getBytes("UTF-8");
//    System.out.println(ByteBufUtil.hexDump(bytes));
//    bytes = str.getBytes("IBM037");
//    System.out.println(ByteBufUtil.hexDump(bytes));

// E1ED -->
//    byte[] unicode= new byte[]{(byte)0x4e, (byte)0x2d};
//    String str =new String(unicode,"unicode");
//    System.out.println(str);


//    byte[] b= new byte[]{(byte)0xee, (byte)0x87, (byte)0xaf};
//    String str =new String(b,"utf-8");
//    byte[] unicodes = str.getBytes("unicode");
//    System.out.println(ByteBufUtil.hexDump(unicodes));

    // source file -->utf-8 编码  编码来源于输入法 + 编辑器
    String testStr="娩"; // 1040 -->o  u10400==𐐀

    // 代码编译后 -->

    System.out.println("utf-8:"+ByteBufUtil.hexDump(testStr.getBytes("utf-8")));
    System.out.println("utf-16:"+ByteBufUtil.hexDump(testStr.getBytes("utf-16")));
    System.out.println("utf-32:"+ByteBufUtil.hexDump(testStr.getBytes("utf-32")));
    System.out.println("unicode:"+ByteBufUtil.hexDump(testStr.getBytes("unicode")));

    System.out.println("gbk:"+ByteBufUtil.hexDump(testStr.getBytes("gbk")));
    char[] chars = testStr.toCharArray();
    for (char aChar : chars) {
      System.out.println(aChar);
    }



  }
}
