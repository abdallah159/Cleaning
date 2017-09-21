package iti.abdallah.cleaning.ui.login;

import iti.abdallah.cleaning.model.login.LoginModel;
import iti.abdallah.cleaning.model.login.LoginModelImpl;


public class LoginPresenter implements LoginContract.Presenter, LoginModel.OnLoginListener {

    private LoginContract.MVPView loginView;
    private LoginModel loginModel;


    LoginPresenter(LoginContract.MVPView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModelImpl();
    }


    @Override
    public void validateLoginInfo(String name, String password) {
        //make login task..
        loginView.showProgress(true);
        loginModel.login(name, password, this);
    }

    @Override
    public void succeed() {
        loginView.showProgress(false);
        loginView.onSuccess();
    }

    @Override
    public void failed() {
        loginView.showProgress(true);
        loginView.onUserError("Username or password error");
    }
}
