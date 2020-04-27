package com.github.yulechen.designpattern.behevioral.command;

/**
 * @Author: chenq
 * @Date: 2020/4/27  17:16
 */
public class PasteCommand implements Command  {

  private Application application;

  public PasteCommand(Application application) {
    this.application = application;
  }

  @Override
  public void execute() {
    application.paste();
  }

}
