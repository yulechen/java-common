package com.github.yulechen.designpattern.pattern.struct.adptor;

/**
 * @Author: chenq
 * @Date: 2020/3/23  15:36
 */
public class God {

  public static void main(String[] args) {
    Gateway gateway =new PayGateWayImpl();


    gateway.doPayment("account1","account2");

    // 需求发生变化了，支付需要变成高级支持，用手机号支付
    // 代码流程应该不变化 gateway.doPayment


    // 替换组件成功，不修改两边代码。提供一个中间层来集成
    gateway =new AdvancedGateWayAdptor(new AdvancedPayGateWayImpl());
    gateway.doPayment("account1","account2");


  }



}
