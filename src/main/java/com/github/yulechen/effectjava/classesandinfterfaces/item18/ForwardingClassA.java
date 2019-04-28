package com.github.yulechen.effectjava.classesandinfterfaces.item18;

import java.util.Collection;

public class ForwardingClassA  extends  ClassA{

  private ClassA a;

  public ForwardingClassA(ClassA a) {
    this.a=a;
  }

  @Override
  public void add(String element) {
    a.add(element);
  }

  @Override
  public void addAll(Collection<String> elements) {
    a.addAll(elements);
  }

  @Override
  public int getCount() {
    return a.getCount();
  }

}
