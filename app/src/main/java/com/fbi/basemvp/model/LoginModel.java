package com.fbi.basemvp.model;

import com.fbi.basemvp.base.BaseModel;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author: FBi.
 * Email: bofu1993@163.com.
 * Date: 9/1/16
 */
public class LoginModel extends BaseModel {

  private boolean login(String userName, String password) {
    return "fbi".equals(userName) && "fbi".equals(password);
  }

  public Subscription login(String userName, String password, Subscriber<Boolean> subscriber) {
    return Observable.just(login(userName, password))
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber);
  }
}
