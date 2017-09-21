package iti.abdallah.cleaning.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import iti.abdallah.cleaning.R;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenterImpl(this);


    }

    @OnClick(R.id.login)
    public void Login(){
        String name = username.getText().toString();
        String pass = password.getText().toString();
        loginPresenter.validateLoginInfo(name,pass);

    }


    @Override
    public void onSuccess() {

    }

    @Override
    public void onUserError(String errmsg) {

    }

    @Override
    public void onPasswordError(String errmsg) {

    }

    @Override
    public void showProgress(boolean showProgress) {

    }
}
