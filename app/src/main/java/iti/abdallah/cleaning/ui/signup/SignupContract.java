package iti.abdallah.cleaning.ui.signup;

public interface SignupContract {

    interface MVPView {

        void onSuccess();

        void onUserOrPasswordError(String errmsg);

        void showProgress(boolean showProgress);
    }

    interface Presenter {

        void validateSignupInfo(String name, String password, String passwordConfirm);
    }
}
