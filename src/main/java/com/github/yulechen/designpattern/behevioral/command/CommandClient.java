package com.github.yulechen.designpattern.behevioral.command;

import com.github.yulechen.designpattern.behevioral.command.v0.Document;
import com.github.yulechen.designpattern.behevioral.command.v0.MenuItem;

/**
 * @Author: chenq
 * @Date: 2020/4/27  17:14
 */
public class CommandClient {

  public static void main(String[] args) {
    // 提供一个中间command 对象连接 invoker 和receiver
    // 使用 command  将 invoker，和receiver 解耦
    OpenCommand open = new OpenCommand(new Document());
    PasteCommand paste = new PasteCommand(new Application());
    Command cmd = open;
    MenuItem item = new MenuItem(cmd);
    item.click();
    item = new MenuItem(paste);
    item.click();
  }


  public static  void design(){
    //MenuItem item =new  MenuItem(Document);
    // item.click() -- document.action()

    //MenuItem item =new  MenuItem(Application);
    // item.click() --application.action()

    // 问题 document 与 Application 没有共性
    // click 是一个稳定点，click 里面具体执行逻辑是个变化点
    // 1、将里面变化点，提供一个接口方法切入点出来

    // item.click(new Ihandler(){
    // new Document().doSome();
    //
    // })


    //2、将变化点当成一个item 的属性进行封装，new Item（handler.click()， item.click(handler)
    // 从复用性考虑，click 可能多次使用，但是 new只有一次
    //使用封装更好。便于内部维护数据状态，使得业务click 能够稳定调用。

    //将 Ihandler 与Document /application 抽象一个中间对象

    // Ihandler
    //       -- execute

    // IhandlerImplement
    //      --  execute: Document().doSome();

    // item.sethandlerImpl()
   //    item.click()

  }
}
