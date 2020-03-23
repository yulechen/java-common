package com.github.yulechen.designpattern.pattern.struct.proxy;

/**
 * @Author: chenq
 * @Date: 2020/3/23  10:03
 */
public interface IUserService {

  void login(String name, String password);

  void register(String name, String password);
}
