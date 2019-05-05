package com.github.yulechen.javase.nestedclass;

public class StaticMemeberClass {


  public void hello() {

  }

  // static member class has not refrece to EnclosingClass
  static class StaticMember {


    public void noneNeedAccessEnclosingClass() {

    }
  }
}
