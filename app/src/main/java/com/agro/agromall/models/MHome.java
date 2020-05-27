package com.agro.agromall.models;

import androidx.annotation.NonNull;

import com.agro.agromall.SQLiteHandler;

import java.util.HashMap;
import java.util.List;

public class MHome {

    SQLiteHandler sqLiteHandler;
    @NonNull
    private String mFullName;
    @NonNull
    private String mEmail;
    @NonNull
    private String mPhoneNumber;
    @NonNull
    private String mHomeAddress;
    @NonNull
    private String mFarmerPicture;
    @NonNull
    private String Uid;
    @NonNull
    private String mFarmName;
    @NonNull
    private String mFarmAddress;
    @NonNull
    private String mLongitude;
    @NonNull
    private String mLatitude;


    public MHome(@NonNull final String full_name,
                 @NonNull final String email,
                 @NonNull final String phone_number,
                 @NonNull final String home_address,
                 @NonNull final String farmer_picture,
                 @NonNull final String farm_name,
                 @NonNull final String farm_address,
                 @NonNull final String longitude,
                 @NonNull final String latitude) {

        mFullName = full_name;
        mEmail = email;
        mPhoneNumber = phone_number;
        mHomeAddress = home_address;
        mFarmerPicture = farmer_picture;
        mFarmName = farm_name;
        mFarmAddress = farm_address;
        mLongitude = longitude;
        mLatitude = latitude;
    }
    HashMap<String, String> user = sqLiteHandler.getUserDetails();
    final String email = user.get("email");

    @NonNull
    public String getUid() {
        int uid = (int) (Math.random());
        Uid = String.valueOf(uid);
        return Uid;
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
    public String getFarmerPicture() {
        return mFarmerPicture;
    }

    public void setFarmerPicture(@NonNull final String farmer_picture) {
        mFarmerPicture = farmer_picture;
    }

    @NonNull
    public String getHomeAddress() {
        return mHomeAddress;
    }

    public void setHomeAddress(@NonNull final String home_address) {
        mHomeAddress = home_address;
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

   /* public LiveData<List<MHome>> getTodolist()
    {
        return todolist;
    }*/
}
