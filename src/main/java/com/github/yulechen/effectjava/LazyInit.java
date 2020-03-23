package com.github.yulechen.effectjava;

import sun.jvm.hotspot.oops.FieldType;

/**
 * @Author: chenq
 * @Date: 2019/8/2  下午4:52
 */
public class LazyInit {

  public static void main(String[] args) {

    System.out.println(FieldHolder.class);
    //getField();
  }
  private static class FieldHolder {
    static final FieldType field = computeFieldValue();

    private static FieldType computeFieldValue() {
      System.out.println("hha");
      return new FieldType(null);
    }

  }
  private static FieldType getField() { return FieldHolder.field; }
}
