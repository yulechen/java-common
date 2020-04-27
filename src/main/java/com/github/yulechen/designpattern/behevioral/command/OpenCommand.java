package com.github.yulechen.designpattern.behevioral.command;

import com.github.yulechen.designpattern.behevioral.command.v0.Document;

/**
 * @Author: chenq
 * @Date: 2020/4/27  17:18
 */
public class OpenCommand implements Command {

  private Document document;

  public OpenCommand(Document document) {
    this.document = document;
  }

  @Override
  public void execute() {
    document.open();
  }

}
