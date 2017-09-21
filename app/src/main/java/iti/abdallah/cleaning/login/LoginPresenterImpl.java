package iti.abdallah.cleaning.login;

/**
 * Created by abdallah on 21/09/17.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginModel {

    private LoginView loginView;
    private LoginModel loginModel;


    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModelImpl();
    }


    @Override
    public void validateLoginInfo(String name, String password) {

        //make login task..


    }

}
