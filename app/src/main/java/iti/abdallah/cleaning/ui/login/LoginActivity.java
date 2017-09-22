package iti.abdallah.cleaning.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import iti.abdallah.cleaning.R;
import iti.abdallah.cleaning.ui.signup.SignupActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.MVPView {

    @BindView(R.id.usernameET)
    EditText usernameET;
    @BindView(R.id.passwordET)
    EditText passwordET;

    private LoginContract.Presenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenter(this);
    }

    @OnClick(R.id.registerTV)
    void goToSignup() {
        Intent i = new Intent(LoginActivity.this, SignupActivity.class);
        LoginActivity.this.finish();
        startActivity(i);
    }

    @OnClick(R.id.loginBTN)
    public void Login() {
        String name = usernameET.getText().toString();
        String pass = passwordET.getText().toString();
        loginPresenter.validateLoginInfo(name, pass);
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onUserOrPasswordError(String errmsg) {

    }


    @Override
    public void showProgress(boolean showProgress) {

    }
}
