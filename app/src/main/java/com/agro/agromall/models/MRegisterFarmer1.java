package com.agro.agromall.models;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.annotation.NonNull;

public class MRegisterFarmer1 {
    @NonNull
    private String mFullName;
    @NonNull
    private String mEmail;
    @NonNull
    private String mPhoneNumber;
    @NonNull
    private String mHomeAddress;

    public MRegisterFarmer1(@NonNull final String full_name, @NonNull final String email, @NonNull final String phone_number, @NonNull final String home_address) {
        mFullName = full_name;
        mEmail = email;
        mPhoneNumber = phone_number;
        mHomeAddress = home_address;
    }

    @NonNull
    public String getEmail() {
        return mEmail;
    }

    public void setEmail(@NonNull final String email) {
        mEmail = email;
    }

    @NonNull
    public String getFullName() {
        return mFullName;
    }

    public void setFullName(@NonNull final String full_name) {
        mFullName = full_name;
    }

    @NonNull
    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(@NonNull final String phone_number) {
        mPhoneNumber = phone_number;
    }

    @NonNull
    public String getHomeAddress() {
        return mHomeAddress;
    }

    public void setHomeAddress(@NonNull final String home_address) {
        mHomeAddress = home_address;
    }

    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getEmail()) && Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()
                && getFullName().length() > 5 && !TextUtils.isEmpty(getPhoneNumber()) && !TextUtils.isEmpty(getHomeAddress());
    }

}
