package com.github.yulechen.datastruct.base.array;

public class CurdArray {

  int[] array = new int[10];
  int count =0;
  public void delete(int index){
    array[index]=-1;
  }
  public void deleteElement(int element){
    for (int i : array) {
       if(array[i]== element){
         delete(i);
       }
    }
  }

  public void update(int index, int element){
    array[index] =element;
  }
// version-1
//  public void addInIndex(int index, int element){
//    // 条件判断，可能由其他数据丢失
//    for(int i= count-1;i>index;i--){
//       array[i]=array[i-1];
//    }
//    array[index]=element;
//
//  }
// version-2
  public void addInIndex(int index, int element){
    // 条件判断，可能由其他数据丢失
    if(index<count)
    for(int i= index;i<count-1;i++){
     int temp= array[i+1];
     array[i+1]=array[index];
     array[index]= temp;
    }
    array[index]=element;
    if(count<array.length){
      count++;
    }

  }


  public void addLast( int element){
     array[count] =element;
     count++;
  }

  public void printArray(){
    for (int i : array) {
      System.out.print(i+" ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    CurdArray a =new CurdArray();
    for(int i =0 ;i<10;i++){
      a.addInIndex(i,i);
    }
    a.printArray();
    a.addInIndex(2,22);
    a.printArray();
    a.addInIndex(1,11);
    a.printArray();
  }

}
