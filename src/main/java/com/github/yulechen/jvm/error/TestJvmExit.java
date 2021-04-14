package com.github.yulechen.jvm.error;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class TestJvmExit {

  // 启动命令行参数，-XX:ErrorFile 只有真正发生jvm crash 才会产生文件，控制台有提示打印
  // -Xloggc 程序启动就会生成文件
  //-Xloggc:/Users/chenqiu/logs/java_gc.log -XX:ErrorFile=/Users/chenqiu/logs/java_error%p.log
  public static void main(String... args) throws Exception {
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        // jvm crash not execute this method.
        dumpThreadDump();
      }
    });
    // this will make jvm crash
    getUnsafe().getByte(0);
    // throw new OutOfMemoryError();

    // 内存溢出不会使jvm crash，其他类型虚拟可能会内存溢出。
    //     long[] t=new long[1024*1024*1024];
    System.out.println("gg");

  }

  private static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
    Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
    theUnsafe.setAccessible(true);
    return (Unsafe) theUnsafe.get(null);
  }

  public static void dumpThreadDump() {
    ThreadMXBean threadMxBean = ManagementFactory.getThreadMXBean();
    for (ThreadInfo ti : threadMxBean.dumpAllThreads(true, true)) {
      System.out.print(ti.toString());
    }
  }
}
