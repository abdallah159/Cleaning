package iti.abdallah.cleaning.ui.signup;

import iti.abdallah.cleaning.model.signup.SignupModel;
import iti.abdallah.cleaning.model.signup.SignupModelImpl;

public class SignupPresenter implements SignupContract.Presenter,SignupModel.OnSignupListener {

    private SignupContract.MVPView signupView;
    private SignupModel signupModel;

    public SignupPresenter(SignupContract.MVPView mvpView) {
        this.signupView = mvpView;
        this.signupModel = new SignupModelImpl();
    }

    @Override
    public void validateSignupInfo(String name, String password, String passwordConfirm) {

        //sign up task
        signupView.showProgress(true);
        signupModel.signUp(name,password,passwordConfirm,this);

    }

    @Override
    public void succeed() {
        signupView.showProgress(false);
        signupView.onSuccess();

    }

    @Override
    public void failed() {
        signupView.showProgress(false);
        signupView.onUserOrPasswordError("Please check your info. ");

    }
}
