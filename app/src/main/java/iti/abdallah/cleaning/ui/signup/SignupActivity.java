package iti.abdallah.cleaning.ui.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import iti.abdallah.cleaning.R;
import iti.abdallah.cleaning.ui.login.LoginActivity;

public class SignupActivity extends AppCompatActivity implements SignupContract.MVPView {

    @BindView(R.id.usernameET)
    EditText usernameET;
    @BindView(R.id.passwordET)
    EditText passwordET;
    @BindView(R.id.passwordconfimET)
    EditText confirmPasswordET;

    private SignupContract.Presenter signupPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        signupPresenter = new SignupPresenter(this);
    }

    @OnClick(R.id.loginTV)
    void goToSignup() {
        Intent i = new Intent(SignupActivity.this, LoginActivity.class);
        SignupActivity.this.finish();
        startActivity(i);
    }

    @OnClick(R.id.signupBTN)
    public void SignUp() {
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();
        String confirmPassword = confirmPasswordET.getText().toString();

        signupPresenter.validateSignupInfo(username, password, confirmPassword);
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
