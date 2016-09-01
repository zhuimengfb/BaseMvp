package com.fbi.basemvp.traditionaldemo;

/**
 * Author: FBi.
 * Email: bofu1993@163.com.
 * Date: 9/1/16
 */
public interface ILoginView {

  String getUserName();

  String getPassword();

  void loginSuccess(String userName);

  void loginFail();

}
