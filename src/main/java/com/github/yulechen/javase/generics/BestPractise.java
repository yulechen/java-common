package com.github.yulechen.javase.generics;

import java.util.HashSet;
import java.util.Set;

/**
 * As a quick review, Set<Object> is a parameterized type representing a set that can contain
 * objects of any type, Set<?> is a wildcard type representing a set that can contain only objects
 * of some unknown type, Set is a raw type, which opts out of the generic type system. The first two
 * are safe, and the last is not
 */

public class BestPractise {


  // not safe
  // out of generic type system ,just for compatibility
  public void testRawTypes() {
    // this can put any element
    @SuppressWarnings("unchecked")
    Set set = new HashSet();
    set.add("1");
    // this maybe runtime error ,and find the error hard.
    // never do this
    set.add(2);
    set.add(null);
  }

  // safe
  public void testUnknownTypes() {

    Set<?> set = new HashSet<>();
    // compile error ,can`t and any element (other than null)
    /**
     set.add("1");
     set.add(2);
     set.add(null);

     Set<String> setString = new HashSet<String>();
     setString.add("1");
     Set<?> setCast=(Set<?>)setString;
     setCast.add("1");
     **/
  }


  // safe
  // representing a set that can contain objects of any type
  public void testObjectTypes() {
    Set<Object> set = new HashSet<>();
    set.add("1");
    set.add(2);
    set.add(null);
    set.forEach(System.out::println);
  }

}
