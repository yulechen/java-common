package com.github.yulechen.designpattern.pattern.struct.adptor;

/**
 * @Author: chenq
 * @Date: 2020/3/23  15:34
 */
public class AdvancedPayGateWayImpl implements  AdvancedPayGateWay {

  @Override
  public void makePaymeny(String mobile1, String mobile2) {
    System.out.println( mobile1 +"payed" +mobile2);
  }

}
