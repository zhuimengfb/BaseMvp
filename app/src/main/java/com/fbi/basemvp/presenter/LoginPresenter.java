package com.fbi.basemvp.presenter;

import com.fbi.basemvp.base.BasePresenter;
import com.fbi.basemvp.model.LoginModel;
import com.fbi.basemvp.view.ILoginView;

import rx.Subscriber;

/**
 * Author: FBi.
 * Email: bofu1993@163.com.
 * Date: 9/1/16
 */
public class LoginPresenter extends BasePresenter<ILoginView, LoginModel> {


  public LoginPresenter(ILoginView baseView) {
    super(baseView);
  }

  public void login(final String userName, String password) {
    subscriptions.add(model.login(userName, password, new Subscriber<Boolean>() {
      @Override
      public void onCompleted() {

      }

      @Override
      public void onError(Throwable e) {

      }

      @Override
      public void onNext(Boolean aBoolean) {
        if (aBoolean) {
          view.loginSuccess(userName);
        } else {
          view.loginFail();
        }
      }
    }));
  }

  @Override
  public void initModel() {
    model = new LoginModel();
  }
}
