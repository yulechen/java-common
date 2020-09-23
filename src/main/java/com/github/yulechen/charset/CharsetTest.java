package com.github.yulechen.charset;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.stream.IntStream;

public class CharsetTest {


  /**
   * 使用码表与unicode 码表对应来做字符解析。
   *
   *
   *char 定义为 unicode 字符
   * @param args
   * @throws UnsupportedEncodingException
   */
  public static void main(String[] args)
      throws UnsupportedEncodingException, NoSuchFieldException, IllegalAccessException {
    // unicode 与 gbk 字符对应关系

    // 娩  --> unicode : \u5a29  --》 默认UTF-16 编码 (unicode)
    // 娩  --> gbk :c3e4
    // 娩  --> utf-8 :
    //buffer = ByteBuffer.wrap("娩".getBytes("utf-8"));
    // "娩"
    Charset charset =Charset.forName("gbk");
    ByteBuffer buffer = ByteBuffer.wrap(new byte[]{(byte)0xc3,(byte)0xe4});
    CharBuffer decode = charset.decode(buffer);
    IntStream chars = decode.chars();
    chars.forEach(i->{
      //ux5a29
      System.out.println(i);
    });
    System.out.println(charset.decode(buffer));
//    SourceFileGBK gbk =new SourceFileGBK();
//    Field value = SourceFileGBK.class.getDeclaredField("value");
//    String o = (String)value.get(SourceFileGBK.class);
//    System.out.println(o);

  }

}
