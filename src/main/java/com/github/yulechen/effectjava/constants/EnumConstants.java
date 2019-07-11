package com.github.yulechen.effectjava.constants;

/**
 * @Author: chenq
 * @Date: 2019/7/11  上午11:27
 */
public enum EnumConstants {
  a(3);

  private int v;

  EnumConstants(int v) {
    this.v = v;
  }

  public int getV() {
    return v;
  }
}
