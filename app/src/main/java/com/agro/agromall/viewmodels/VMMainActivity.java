package com.agro.agromall.viewmodels;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.agro.agromall.BR;
import com.agro.agromall.NavigationHandler;
import com.agro.agromall.models.User;


public class VMMainActivity extends BaseObservable {

    private User user;
    private NavigationHandler handler = new NavigationHandler();


    private String successMessage = "Login was successful";
    private String errorMessage = "Email or Password not valid";

    @Bindable
    private String toastMessage = null;


    public String getToastMessage() {
        return toastMessage;
    }


    private void setToastMessage(String toastMessage) {

        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public VMMainActivity() {
        user = new User("", "");
    }

    public void afterEmailTextChanged(CharSequence s) {
        user.setEmail(s.toString());
    }

    public void afterPasswordTextChanged(CharSequence s) {
        user.setPassword(s.toString());
    }

    public void onLoginClicked(View v) {
        if (user.isInputDataValid()){
            setToastMessage(successMessage);
            handler.onLoginClick(v);}
        else
            setToastMessage(errorMessage);
    }
}
