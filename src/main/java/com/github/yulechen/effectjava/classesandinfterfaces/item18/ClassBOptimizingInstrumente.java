package com.github.yulechen.effectjava.classesandinfterfaces.item18;

import java.util.Collection;

public class ClassBOptimizingInstrumente extends  ClassA {

  private int count;
  @Override
  public void add(String element) {
    count++;
    super.add(element);
  }

  @Override
  public void addAll(Collection<String> elements) {
    count+=elements.size();
    super.addAll(elements);
  }

  @Override
  public int getCount() {
    return count;
  }

}
