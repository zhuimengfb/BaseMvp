package com.fbi.basemvp.base;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;

/**
 * Author: FBi.
 * Email: bofu1993@163.com.
 * Date: 9/1/16
 */
public abstract class BasePresenter<V extends IBaseView, M extends BaseModel> {

  public V view;
  public M model;
  public List<Subscription> subscriptions = new ArrayList<>();

  public BasePresenter(V baseView) {
    this.view = baseView;
    initModel();
  }

  public abstract void initModel();

  public void unBind() {
    for (Subscription subscription : subscriptions) {
      if (subscription.isUnsubscribed()) {
        subscription.unsubscribe();
      }
    }
    view = null;
    model = null;
  }

}
