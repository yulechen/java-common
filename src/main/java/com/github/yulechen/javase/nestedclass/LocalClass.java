package com.github.yulechen.javase.nestedclass;

public class LocalClass {


  public void hello() {

    // this  class just use here.
    class A {

      private int a;

      void helloLocal() {
        LocalClass.this.hello();
      }
    }

    A a = new A();

  }


}
