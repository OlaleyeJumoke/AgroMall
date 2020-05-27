package com.agro.agromall.viewmodels;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.agro.agromall.BR;

import com.agro.agromall.NavigationHandler;
import com.agro.agromall.SQLiteHandler;
import com.agro.agromall.models.MRegisterFarmer1;

import java.util.Date;

public class VMRegisterFarmer1 extends BaseObservable {

    private MRegisterFarmer1 registerFarmer1;
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

    public VMRegisterFarmer1() {
        registerFarmer1 = new MRegisterFarmer1("", "", "", "");
    }

    public void afterFullNameTextChanged(CharSequence s) {
        registerFarmer1.setFullName(s.toString());
    }

    public void afterEmailTextChanged(CharSequence s) {
        registerFarmer1.setEmail(s.toString());
    }

    public void afterPhoneNumberChanged(CharSequence s) {
        registerFarmer1.setPhoneNumber(s.toString());
    }

    public void afterHomeAddressTextChanged(CharSequence s) {
        registerFarmer1.setHomeAddress(s.toString());
    }
    //registerFarmer1.get

    public void onRegister1Clicked(View view) {
        SQLiteHandler sqLiteHandler = new SQLiteHandler(view.getContext());

        if (!TextUtils.isEmpty(registerFarmer1.getEmail()) && Patterns.EMAIL_ADDRESS.matcher(registerFarmer1.getEmail()).matches()
                && registerFarmer1.getFullName().length() > 5 && !TextUtils.isEmpty(registerFarmer1.getPhoneNumber()) && !TextUtils.isEmpty(registerFarmer1.getHomeAddress())) {
            sqLiteHandler.addFarmer1(registerFarmer1.getFullName(), registerFarmer1.getEmail(),
                    registerFarmer1.getUid(), registerFarmer1.getPhoneNumber(), registerFarmer1.getHomeAddress(), new Date().toString());
            //return registerFarmer1.getUid();
            setToastMessage(successMessage);
            handler.onRegister1Click(view, registerFarmer1.getUid());
        } else setToastMessage(errorMessage);

    }

}
