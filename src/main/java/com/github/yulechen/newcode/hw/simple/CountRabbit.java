package com.github.yulechen.newcode.hw.simple;

/**
 * 统计兔子
 */
public class CountRabbit {


  public static void main(String[] args) {
    System.out.println(getTotalCount2(3));
  }

  /**
   * 统计出兔子总数。
   *
   * @param monthCount 第几个月
   * @return 兔子总数
   */
  public static int getTotalCount(int monthCount) {
    int a = 1, b = 0, c = 0; // 1 个月，2个月，3个月
//     while((--monthCount)>0){
//       c+=b;
//       b=a;
//       a=c;
//     }
//     return a+b+c;

    /**
     * +1 m
     *
     *
     *
     */
    for (int i = 1; i < monthCount; i++) {
      // 三个月龄兔子数 = 两个月兔子变成3个月，本来大于3个月的。
      c = b + c;
      // 1 个月兔子变成两个月兔子
      b = a;
      // >=3个月的兔子 生成1个月兔子
      a = c;
    }
    return a+b+c;

  }



  // 当n>=3的时候
  // f(n)=f(n-1)+k
  // k=f(n-2)
  public static int getTotalCount2(int monthCount) {
     if(monthCount==1 ||monthCount==2 ){
       return 1;
     }
    int before1 = getTotalCount2(monthCount - 1);
    int before2 = getTotalCount2(monthCount - 2);
    return before1+before2;
  }


}

