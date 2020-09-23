package com.github.yulechen.datastruct.base.array;

public class ExpansionArray {
  int count=0;
  int[] array =new int[10];
  public void add(int element ){
    if(count>=array.length){
      int[] new_array = new int[array.length*2];
      // copy N
      for(int i=0;i<array.length;i++){
        new_array[i]=array[i];
      }
      array =new_array;
    }

    array[count]=element;
    count++;
  }

}
