package com.fbi.basemvp.traditionaldemo;

/**
 * Author: FBi.
 * Email: bofu1993@163.com.
 * Date: 9/1/16
 */
public class LoginModel {

  public void login(final String userName, final String password, final LoginCallback loginCallback) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        if ("fbi".equals(userName) && "fbi".equals(password)) {
          loginCallback.loginSuccess(userName);
        } else {
          loginCallback.loginFail();
        }
      }
    }).start();
  }


  public interface LoginCallback{
    void loginFail();

    void loginSuccess(String userName);
  }
}
