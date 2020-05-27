package com.agro.agromall.models;

import android.graphics.Bitmap;
import android.text.TextUtils;

import androidx.annotation.NonNull;

public class MRegisterFarmer2 {
    @NonNull
    private Bitmap mImageURL;

    public MRegisterFarmer2(@NonNull final Bitmap imageURL) {
        mImageURL = imageURL;
    }

    @NonNull
    public Bitmap getImageURL() {
        return mImageURL;
    }

    public void setImageURL(@NonNull final Bitmap image_Url) {
        mImageURL = image_Url ;
    }

    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getImageURL().toString());
    }
}
