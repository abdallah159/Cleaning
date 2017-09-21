package iti.abdallah.cleaning.model.login;

public interface LoginModel {

    interface OnLoginListener {

        void succeed();

        void failed();
    }

    void login(String name, String password, OnLoginListener listener);
}
