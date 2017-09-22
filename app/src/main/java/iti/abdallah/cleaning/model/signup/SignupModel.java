package iti.abdallah.cleaning.model.signup;

public interface SignupModel {

    interface OnSignupListener {

        void succeed();

        void failed();
    }

    void signUp(String name, String password, String passwordConfirm, OnSignupListener listener);
}
