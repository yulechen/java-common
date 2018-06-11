package com.github.yulechen.grammar.jdk8.foreach;

public class Data {
    public String[] data = {"a","b","c"};

    public static void main(String[] args) {
        Data d = new Data();
        d.forEachElement(e->{
            System.out.println(e);
        });
    }

    public void forEachElement(ForEachMock<String> element){
        for (String datum : data) {
            element.forEachOut(datum);
        }
    }
}
