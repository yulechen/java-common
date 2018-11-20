package com.github.yulechen.grammar.jdk8.collections;

import java.util.ArrayList;
import java.util.List;

public class StreamCollect {

   public  class A{
        int a=0;
        String  b="";

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }
    }


    public static void main(String[] args) {
        StreamCollect collect= new StreamCollect();
        collect.test();
    }


    public void test(){
        List<A> list = new ArrayList();
        A a1= new A();
        a1.setA(0);
        A a2= new A();
        a2.setA(1);
        list.add(a1);
        list.add(a2);
        ArrayList<Integer> collect = list.stream().mapToInt(A::getA).collect(
                ArrayList::new,
                (r, v) -> {
                    r.add(v);
                },
                (y, z) -> {
                    y.addAll(z);
                }
        );
        collect.forEach(System.out::println);
    }
}
