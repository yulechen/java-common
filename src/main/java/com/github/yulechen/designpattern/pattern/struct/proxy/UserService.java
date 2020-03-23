package com.github.yulechen.designpattern.pattern.struct.proxy;

/**
 * @Author: chenq
 * @Date: 2020/3/23  09:53
 */
public class UserService implements IUserService {

  @Override
  public void login(String name, String password){
    System.out.println("user login");
  }

  @Override
  public void register(String name, String password){
    System.out.println("user register");
  }

}
