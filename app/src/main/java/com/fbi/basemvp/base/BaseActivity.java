package com.fbi.basemvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Author: FBi.
 * Email: bofu1993@163.com.
 * Date: 9/1/16
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

  public P presenter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initPresenter();
  }

  public abstract void initPresenter();

  @Override
  protected void onDestroy() {
    super.onDestroy();
    if (presenter != null) {
      presenter.unBind();
    }
  }
}
