package com.fbi.basemvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fbi.basemvp.R;
import com.fbi.basemvp.base.BaseActivity;
import com.fbi.basemvp.presenter.LoginPresenter;

/**
 * Author: FBi.
 * Email: bofu1993@163.com.
 * Date: 9/1/16
 */
public class NewLoginActivity extends BaseActivity<LoginPresenter> implements ILoginView {

  private EditText userName;
  private EditText password;
  private Button loginButton;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    initView();
    initEvent();
  }

  private void initEvent() {
    loginButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.login(getUserName(), getPassword());
      }
    });
  }

  private void initView() {
    userName = (EditText) findViewById(R.id.et_user_name);
    password = (EditText) findViewById(R.id.et_password);
    loginButton = (Button) findViewById(R.id.bt_login);
  }


  @Override
  public void initPresenter() {
    presenter = new LoginPresenter(this);
  }

  @Override
  public String getUserName() {
    return userName.getText().toString();
  }

  @Override
  public String getPassword() {
    return password.getText().toString();
  }

  @Override
  public void loginSuccess(String userName) {
    Toast.makeText(this, "登录成功," + userName, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void loginFail() {
    Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
  }
}
