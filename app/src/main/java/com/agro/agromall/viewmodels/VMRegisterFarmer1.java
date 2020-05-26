package com.agro.agromall.viewmodels;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.agro.agromall.BR;

import com.agro.agromall.models.MRegisterFarmer1;

public class VMRegisterFarmer1 extends BaseObservable {

    private MRegisterFarmer1 registerFarmer1;


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
        registerFarmer1 = new MRegisterFarmer1("", "", "", "" );
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

    public void onRegister1Clicked() {
        if (registerFarmer1.isInputDataValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
    }

}
