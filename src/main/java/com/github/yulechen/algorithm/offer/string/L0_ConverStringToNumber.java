package com.github.yulechen.algorithm.offer.string;

/**
 * String a="121033";
 *
 */
public class L0_ConverStringToNumber {


  public static void main(String[] args) throws Exception {
    String rStr="202";
    System.out.println(convert(rStr)==202);
  }
  /**
   *
   * ascii 码表：
   * 0-48
   *
   * 9-57
   *
   * @param number
   * @return
   */
  public static long convert(String number) throws Exception {
    // 1、输入添加判断
      if(number==null || number.isEmpty()){
        // should define a exception;
        throw  new Exception("illege string");
      }
    //
    char[] chars = number.toCharArray();

    long converedNumber =0l;
    for(int i =0 ;i< chars.length ;i++){
      // 判断char 是否合法
      converedNumber=converedNumber*10+chars[i]-'0';
      // 判断converedNumber 是否溢出;
    }
    return converedNumber;
  }


}
