package com.github.yulechen.hack;


import java.util.ArrayList;
import java.util.List;

public class TimeAttack {


  public static void main(String[] args) {
    String password="wertyufghgkk";
    System.out.println("密码长度："+password.length());
    guessLength(password);
    metricList.stream().sorted((o1,o2)->{
       return (int)(o1.time-o2.time);
    }
    ).forEach((t)->{
      System.out.println(t);
    });
  }

  private static  List<Metric> metricList =new ArrayList<Metric>();

  private static void guess(String password,String gussPassword){
    long start= System.nanoTime();
    // 1、比较长度
    // 2、比较内容 只要一个不满足就返回
    boolean result =password.equals(gussPassword);
    Metric m =new Metric(System.nanoTime()-start,gussPassword.length(),result);
    metricList.add(m);
  }

  private static void guessLength(String password){
    for(int i =0 ;i<100;i++){
      StringBuilder sb = new StringBuilder();
      for(int j=0;j<i;j++){
       sb.append("a");
      }
      guess(password,sb.toString());
    }
  }


  static class Metric{
    long time;
    long length;
    boolean result;


    public long getTime() {
      return time;
    }

    public void setTime(long time) {
      this.time = time;
    }

    public long getLength() {
      return length;
    }

    public void setLength(long length) {
      this.length = length;
    }

    public Metric(long time, long length, boolean result) {
      this.time = time;
      this.length = length;
      this.result = result;
    }

    @Override
    public String toString() {
      return "Metric{" +
          "time=" + time +
          ", length=" + length +
          ", result=" + result +
          '}';
    }
  }


}
