package com.github.yulechen.designpattern.pattern.struct.proxy;

/**
 * @Author: chenq
 * @Date: 2020/3/23  09:57
 * # 1、直接继承，然后在父类方法中添加日志功能。
 *         1、 父类不是抽象的，代码不会提示，用接口与抽象类较好
 *         2、 父类本来就可以单独使用，所以也不应该是抽象类型
 *         3、
 * #
 */
public class UserServiceProxy implements  IUserService{

  private IUserService userServices;

  @Override
  public void login(String name, String password) {
    userServices.login(name,password);
    System.out.println("log");
  }

  @Override
  public void register(String name, String password) {
    System.out.println("log");
  }


}
