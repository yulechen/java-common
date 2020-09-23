package com.github.yulechen.newcode.hw.exam.s3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  /**
   *    0
   *    6
   *   /  \
   *   2   8
   *       / \
   *      10 20
   * @param args
   */

  public static void main(String[] args) {
     int[][] s = {{8,6},{10,8},{6,0},{20,8},{2,6}};
     int r=8;
     FileNode root = createTree(s);
     removeNode(root,8);
     List<Integer> result = new ArrayList<>();
     scanNode(root,result);
     sortResult(result);
     result.remove(0);
     System.out.println(result);

  }

  static class FileNode {
    int nodeId;

    public FileNode(int nodeId) {
      this.nodeId = nodeId;
    }
    List<FileNode> child= new ArrayList<>();
    FileNode parent;

    public void addChild(FileNode c){
       child.add(c);
    }

    public void setParent(FileNode parent){
         this.parent=parent;
         parent.addChild(this);
    }
    public void remove(){
       this.parent.child.remove(this);
    }

    public int getNodeId() {
      return nodeId;
    }

    public List<FileNode> getChild() {
      return child;
    }
  }


  public static FileNode createTree(int[][] inputData){
    FileNode root = new FileNode(0);
    Map<Integer,FileNode> cache =new HashMap<>();
    cache.put(0,root);
    for (int[] inputDatum : inputData) {
       int cuurNodeId= inputDatum[0];
       cache.put(cuurNodeId,new FileNode(cuurNodeId));
    }
    for (int[] inputDatum : inputData) {
      int cuurNodeId= inputDatum[0];
      int parent= inputDatum[1];
      FileNode fileNode = cache.get(cuurNodeId);
      fileNode.setParent(cache.get(parent));
    }
    return root;
  }


  public static void removeNode(FileNode root, int removeId) {
    if(root.getNodeId()== removeId){
      root.remove();
      return;
    }
    List<FileNode> child = root.getChild();
    for(int i =0 ; i< child.size();i++){
      removeNode(child.get(i),removeId);
    }

  }

  public static void scanNode(FileNode root, List<Integer> result) {
    if (root.getChild() == null) {
      return;
    }
    result.add(root.getNodeId());
    List<FileNode> child = root.getChild();
    for (FileNode fileNode : child) {
      scanNode(fileNode, result);
    }
  }

  public  static void sortResult(List<Integer> result){
     Collections.sort(result);
  }


}




