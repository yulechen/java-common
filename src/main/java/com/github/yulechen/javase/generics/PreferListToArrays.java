package com.github.yulechen.javase.generics;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 1、数组在运行时，有固定的类型。 < br /> 2、泛型只在编译时有固定的类型，运行时会擦除类型(需要兼容以前的jdk)。 < br /> 3、不能使用泛型的数组。  <br />
 * 4、优先在编译时发现问题 < br />
 */
public class PreferListToArrays {



  public void differ1() {
    Object[] objectArray = new Long[1];
    objectArray[0] = "I don't fit in"; // Throws ArrayStoreException

   // List<Object> ol = new ArrayList<Long>(); // Incompatible types
   // ol.add("I don't fit in");

  }


  public void genericArrays() {
/**
    // Why generic array creation is illegal - won't compile!
    List<String>[] stringLists = new List<String>[1]; // (1)
    List<Integer> intList = List.of(42);
    Object[] objects = stringLists;
    objects[0] = intList;
    String s = stringLists[0]
        .get(0); // here will be cast exception,so generic array creation is illegal
**/
  }

  // element type information is erased from generics at runtime
  // runtime unknown what T is represent
  class Chooser<T> {

    private final T[] choiceArray;

    public Chooser(Collection<T> choices) {
      // this will cast exeception ocour
      choiceArray = (T[]) choices.toArray();
      // this will be compile error
     // T[] choiceArray1 = choices.toArray();
    }
    // choose method unchanged
  }

  class Chooser2<T> {

    private final List<T> choiceList;

    public Chooser2(Collection<T> choices) {
      choiceList = new ArrayList<>(choices);
    }

    public T choose() {
      Random rnd = ThreadLocalRandom.current();
      return choiceList.get(rnd.nextInt(choiceList.size()));
    }
  }


  public void erasedTypeRuntime(){
    List<String> s = new ArrayList<>();
    // how can runtime konw here is String
    String s1 = s.get(0);
  }

}
