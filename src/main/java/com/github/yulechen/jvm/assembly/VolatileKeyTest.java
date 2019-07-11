package com.github.yulechen.jvm.assembly;

/**
 *
 *java 运行参数 ：-XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly
 // 过滤方法
 java -XX:+UnlockDiagnosticVMOptions '-XX:CompileCommand=print,*PongRunner.run' 
 * @Author: chenq
 * @Date: 2019/7/10  下午3:03
 */
public class VolatileKeyTest {
  // volatile mac is use lock 指令
  // synchronized use cmp and jmp 指令。
  private volatile int a;

  private int b;
  private int c;

  public void write(){
    b=1;
    a=2;
    c=3;
  }

  public void read(){
    int br =b;
    int ar = a;
    int cr =c;
  }

  public static void main(String[] args) {

    VolatileKeyTest s = new VolatileKeyTest();
    // the method must call many time cat active jit.
    for (int i = 0 ; i < 1_1000_100; i++){
      s.write();
      s.read();
    }

  }
}
