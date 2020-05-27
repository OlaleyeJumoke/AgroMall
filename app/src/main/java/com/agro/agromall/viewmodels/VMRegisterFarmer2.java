package com.agro.agromall.viewmodels;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.agro.agromall.BR;
import com.agro.agromall.ImagePicker;
import com.agro.agromall.R;
import com.agro.agromall.models.MRegisterFarmer2;
import com.squareup.picasso.Picasso;

import java.util.BitSet;

public class VMRegisterFarmer2 extends BaseObservable {
    private MRegisterFarmer2 registerFarmer2;


   private ImagePicker imagePicker =new ImagePicker();

    @Bindable
    private Bitmap imageBitmap = null;


    @BindingAdapter({"imageBitmap"})
    public static void loadImage(ImageView view, Bitmap imageBitmap) {
        view.setImageBitmap(imageBitmap);
    }

    public Bitmap getBitMap() {
        //imageBitmap = imagePicker.getBitmapImage();
        return imageBitmap;

    }

    public void setBitmap(Bitmap imageBitmap1) {
       imageBitmap = getBitMap();
        this.imageBitmap = imageBitmap1;
        notifyPropertyChanged(BR.imageBitmap);
    }

    public void onPickImageClicked(View v) {
        imagePicker.pickImage(v);
        getBitMap();
    }


}
