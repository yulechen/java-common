package com.github.yulechen.effectjava.classesandinfterfaces.item18;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ClassA {

  private Set<String> conainer =new HashSet<String>();

  public void add(String element){
     conainer.add(element);
  }

  public void addAll(Collection<String> elements){
    for (String element : elements) {
      add(element);
    }
  }

  public int getCount(){
     return conainer.size();
  }

}
