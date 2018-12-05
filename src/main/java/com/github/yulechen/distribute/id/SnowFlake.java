package com.github.yulechen.distribute.id;

/*
   SnowFlake 0 - 41位时间戳 - 5位数据中心标识 - 5位机器标识 - 12位序列号
 */
public class SnowFlake {

  /**
   * 每一部分占用的位数
   */
  private final static byte CURRENTTIME_BIT = 42;//数据中心占用的位数
  private final static byte SEQUENCE_BIT = 12;   //序列号占用的位数
  private final static byte MACHINE_BIT = 5;     //机器标识占用的位数
  private final static byte DATACENTER_BIT = 5;  //数据中心占用的位数

  // final guarantee thread safe.
  private final int dataCenterNum;
  private final int machineNum;

  private int i=1;

  public SnowFlake(int dataCenterNum,int machineNum){
     this.dataCenterNum=dataCenterNum;
     this.machineNum=machineNum;
  }



  public long getId(){
    long currentTimestamp = getCurrentTimestamp();
    currentTimestamp= currentTimestamp<<(SEQUENCE_BIT+MACHINE_BIT+DATACENTER_BIT);
    int nextSeq = getNextSeq(currentTimestamp);
    int next= (dataCenterNum<<(SEQUENCE_BIT+MACHINE_BIT))|(machineNum<<SEQUENCE_BIT)|nextSeq;
    return currentTimestamp|next;
  }


  private long getCurrentTimestamp(){
    // 时间措 42 位
    return System.currentTimeMillis();
  }


  private int getNextSeq(long timestamp){
      return i++;
  }

  public static void main(String[] args) {
    SnowFlake sf= new SnowFlake(1,4);
    for(int i=0;i<20;i++){
      long id = sf.getId();
      System.out.println(id);
      System.out.println("date:"+(id>>22));
      System.out.println("id:"+(id&0xFFF));
      System.out.println("machineNum:"+((id>>12)&0x1F));
      System.out.println("dataCenterNum:"+((id>>17)&0x1F));
      System.out.println();
      System.out.println();


    }
  }

}
