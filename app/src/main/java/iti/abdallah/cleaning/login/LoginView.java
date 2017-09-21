package iti.abdallah.cleaning.login;

/**
 * Created by abdallah on 21/09/17.
 */

public interface LoginView {

    void onSuccess();

    void onUserError(String errmsg);

    void onPasswordError(String errmsg);

    void showProgress(boolean showProgress);


}
