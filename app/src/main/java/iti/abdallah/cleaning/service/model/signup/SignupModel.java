package iti.abdallah.cleaning.service.model.signup;

public interface SignupModel {

    interface OnSignupListener {

        void succeed();

        void failed();
    }

    void signUp(String name, String password, String passwordConfirm, OnSignupListener listener);
}
