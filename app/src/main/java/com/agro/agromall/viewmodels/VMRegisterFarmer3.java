package com.agro.agromall.viewmodels;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.agro.agromall.BR;
import com.agro.agromall.models.MRegisterFarmer3;

public class VMRegisterFarmer3 extends BaseObservable {
    private MRegisterFarmer3 registerFarmer3;


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

    public VMRegisterFarmer3() {
        registerFarmer3 = new MRegisterFarmer3("", "", "", "" );
    }

    public void afterFarmNameTextChanged(CharSequence s) {
        registerFarmer3.setFarmName(s.toString());
    }

    public void afterFarmAddressTextChanged(CharSequence s) {
        registerFarmer3.setFarmAddress(s.toString());
    }

    public void afterLongitudeTextChanged(CharSequence s) {
        registerFarmer3.setLongitude(s.toString());
    }

    public void afterLatitudeTextChanged(CharSequence s) {
        registerFarmer3.setLatitude(s.toString());
    }

    public void onRegister3Clicked() {
        if (registerFarmer3.isInputDataValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
    }
}
