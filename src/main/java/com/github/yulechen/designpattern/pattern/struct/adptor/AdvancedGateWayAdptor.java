package com.github.yulechen.designpattern.pattern.struct.adptor;

/**
 * @Author: chen q
 * @Date: 2020/3/23  15:38
 */
public class AdvancedGateWayAdptor implements Gateway {

  private AdvancedPayGateWay advancedPayGateWay;

  public AdvancedGateWayAdptor(
      AdvancedPayGateWay advancedPayGateWay) {
    this.advancedPayGateWay = advancedPayGateWay;
  }

  @Override
  public void doPayment(String acount1, String acount2) {
    advancedPayGateWay.makePaymeny(converAccount2Mobile(acount1),converAccount2Mobile(acount2));
  }

  private String converAccount2Mobile(String acount2) {
    return "convered2Mobile"+acount2;
  }
}
