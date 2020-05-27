package com.agro.agromall.models;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.annotation.NonNull;

import java.util.Date;

public class MRegisterFarmer3 {
    @NonNull
    private String mFarmName;
    @NonNull
    private String mFarmAddress;
    @NonNull
    private String mLongitude;
    @NonNull
    private String mLatitude;

    public MRegisterFarmer3(@NonNull final String farm_name, @NonNull final String farm_address, @NonNull final String longitude, @NonNull final String latitude) {
        mFarmName = farm_name;
        mFarmAddress = farm_address;
        mLongitude = longitude;
        mLatitude = latitude;
    }

    @NonNull
    public String getFarmName() {
        return mFarmName;
    }

    public void setFarmName(@NonNull final String farm_name) {
        mFarmName = farm_name;
    }

    @NonNull
    public String getFarmAddress() {
        return mFarmAddress;
    }

    public void setFarmAddress(@NonNull final String farm_address) {
        mFarmAddress = farm_address;
    }

    @NonNull
    public String getLongitude() {
        return mLongitude;
    }

    public void setLongitude(@NonNull final String longitude) {
        mLongitude = longitude;
    }

    @NonNull
    public String getLatitude() {
        return mLatitude;
    }

    public void setLatitude(@NonNull final String latitude) {
        mLatitude = latitude;
    }

    /*public boolean isInputDataValid() {
        if(!TextUtils.isEmpty(getFarmName())
                && !TextUtils.isEmpty(getFarmAddress())  && !TextUtils.isEmpty(getLongitude())
                && !TextUtils.isEmpty(getLatitude())){
            sqLiteHandler.addFarmer1(getFullName(),getEmail(),getUid(),getPhoneNumber(),getHomeAddress(), new Date().toString());
        }
    }*/

}
