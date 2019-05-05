package com.github.yulechen.javase.nestedclass;

public class NoneStaticMemeberClass {


  public void hello() {

  }

  // None static member class has a hidden refrece to EnclosingClass
  // storing this reference takes time and space
  class NoneStaticMember {


    public void needAccessEnclosingClass() {
      NoneStaticMemeberClass.this.hello();
    }
  }
}
