package com.github.yulechen.datastruct.algorithm.recursion;

import java.io.File;

/**
 * @Author: chenq
 * @Date: 2020/5/12  11:33
 *
 * 遍历文件和文件夹
 *
 */
public class ListDirFiles {

  public void listFiles(File file){
    File[] files = file.listFiles();
    for (File f : files) {
       if(f.isDirectory()){
         listFiles(f);
       }else{
         System.out.println(f.getName());
       }
    }
  }

}
