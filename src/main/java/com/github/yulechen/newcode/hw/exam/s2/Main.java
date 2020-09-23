package com.github.yulechen.newcode.hw.exam.s2;


import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
//    Scanner in = new Scanner(System.in);
//    while (in.hasNextInt()) {
//      int length = in.nextInt();
//      String line = in.nextLine();
//      line = in.nextLine();
//      System.out.println(convert(line, length));
//    }

    System.out.println(convert("12abc-1-1A22a", 3));
    //12abc-abCABc4aB@
    //12abc-abCABc4aB@
  }


  static String  convert(String str,int newLength){
    if(null == str || str.isEmpty()){
       return str;
    }
    String[] split = str.split("-");

    StringBuilder sb = new StringBuilder();
    for(int i =1 ;i< split.length;i++){
      sb.append(split[i]);
    }
    String s = sb.toString();
    // 重新分组
    List<String> group= new ArrayList<>();
    for(int i =0 ;i< s.length() ;i=i+newLength){
      int to=i+newLength>s.length()?s.length():i+newLength;
      group.add(s.substring(i,to));
    }
    // 统计大小写
    List<String> newGroup =new ArrayList<>();
    for (String g : group) {
      char[] chars = g.toCharArray();
      int lowCaseCount =0;
      int upperCaseCount=0;
      for (char aChar : chars) {
          if(aChar>='A' &&aChar<='Z' )
            upperCaseCount++;
           if(aChar>='a' && aChar<='z' )
             lowCaseCount++;

      }
      char[] newchars = new char[chars.length];
      // 小写字符多，将大写转换成小写
      int diff = 'a'-'A';
      if(lowCaseCount>upperCaseCount){
        for(int i = 0 ; i<chars.length;i++ ){
           newchars[i]= chars[i];
          if(chars[i]>='A' &&chars[i]<='Z' ){
            newchars[i]= (char)(diff+chars[i]);
          }
        }

      }else if(upperCaseCount> lowCaseCount){
        // 大写字符多，将小写转换成大写
        for(int i = 0 ; i<chars.length;i++ ){
          newchars[i]= chars[i];
          if(chars[i]>='a' &&chars[i]<='z' ){
            newchars[i]= (char)(chars[i]-diff);
          }
        }
      }else{
        for(int i = 0 ; i<chars.length;i++ ){
          newchars[i]= chars[i];
        }
      }
      newGroup.add(new String(newchars));
    }
    StringBuilder newsb =new StringBuilder();
    newsb.append(split[0]+"-");
    for (String s1 : newGroup) {
      newsb.append(s1+"-");
    }
     int length = newsb.length();
     newsb.deleteCharAt(length-1);
     return newsb.toString();
  }

}
