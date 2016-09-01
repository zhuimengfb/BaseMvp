package com.fbi.basemvp.view;

import com.fbi.basemvp.base.IBaseView;

/**
 * Author: FBi.
 * Email: bofu1993@163.com.
 * Date: 9/1/16
 */
public interface ILoginView extends IBaseView {

  String getUserName();

  String getPassword();

  void loginSuccess(String userName);

  void loginFail();

}
