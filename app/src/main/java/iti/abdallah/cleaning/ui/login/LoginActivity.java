package iti.abdallah.cleaning.ui.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import iti.abdallah.cleaning.R;

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

    @OnClick(R.id.login)
    public void Login() {
        String name = usernameET.getText().toString();
        String pass = passwordET.getText().toString();
        loginPresenter.validateLoginInfo(name, pass);
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
