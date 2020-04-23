package com.github.yulechen.designpattern.pattern.struct.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenq
 * @Date: 2020/3/25  14:45
 */
public class Composite  implements Account {
  private List<Account> accounts = new ArrayList<>();

  @Override
  public void accountType() {
    for (Account  account: accounts) {
      account.accountType();
    }
  }

  public  void addAccount(Account account){
    accounts.add(account);
  }

  public void removeAccount(Account account){
    accounts.remove(account);
  }
}
