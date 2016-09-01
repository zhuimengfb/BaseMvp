package com.fbi.basemvp.traditionaldemo;

import android.os.Handler;

/**
 * Author: FBi.
 * Email: bofu1993@163.com.
 * Date: 9/1/16
 */
public class LoginPresenter {

  private ILoginView loginView;
  private LoginModel loginModel;
  private Handler handler;

  public void bind(ILoginView loginView) {
    this.loginView = loginView;
    loginModel = new LoginModel();
    handler = new Handler();
  }

  public void login(String userName, String password) {
    loginModel.login(userName, password, new LoginModel.LoginCallback() {
      @Override
      public void loginFail() {
        handler.post(new Runnable() {
          @Override
          public void run() {
            loginView.loginFail();
          }
        });
      }

      @Override
      public void loginSuccess(final String userName) {
        handler.post(new Runnable() {
          @Override
          public void run() {
            loginView.loginSuccess(userName);
          }
        });
      }
    });
  }

  public void unBind() {
    this.loginView = null;
    this.loginModel = null;
  }
}
