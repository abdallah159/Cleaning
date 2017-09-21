package iti.abdallah.cleaning.ui.login;

public interface LoginContract {

    interface MVPView {

        void onSuccess();

        void onUserError(String errmsg);

        void onPasswordError(String errmsg);

        void showProgress(boolean showProgress);
    }

    interface Presenter {

        void validateLoginInfo(String name, String password);
    }
}
