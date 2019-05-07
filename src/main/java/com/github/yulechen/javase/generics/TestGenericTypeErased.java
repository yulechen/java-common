package com.github.yulechen.javase.generics;

import java.util.ArrayList;
import java.util.List;

public class TestGenericTypeErased {

  public static void main(String[] args) {

    List<String> stringList =new ArrayList<>();

    // java/util/List.add (Ljava/lang/Object;)
    stringList.add("1");
    /*
     INVOKEINTERFACE java/util/List.get (I)Ljava/lang/Object;
     CHECKCAST java/lang/String
     */
    String s = stringList.get(0);
    System.out.println(s);
  }
}
