package com.github.yulechen.designpattern.pattern.struct.adptor;

/**
 * @Author: chenq
 * @Date: 2020/3/23  15:35
 */
public class PayGateWayImpl implements Gateway {

  @Override
  public void doPayment(String acount1, String acount2) {
    System.out.println( acount1 +"payed" + acount2);
  }
}
