package com.agro.agromall.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.agro.agromall.R;
import com.agro.agromall.SQLiteHandler;
import com.agro.agromall.databinding.ActivityRegisterFarmer3Binding;
import com.agro.agromall.models.MRegisterFarmer3;
import com.agro.agromall.viewmodels.VMRegisterFarmer3;

import java.util.Date;

public class RegisterFarmer3 extends AppCompatActivity {
    private MRegisterFarmer3 registerFarmer3;
    private String Uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegisterFarmer3Binding activityRegisterFarmer3Binding = DataBindingUtil.setContentView(this, R.layout.activity_register_farmer3);
        activityRegisterFarmer3Binding.setViewModel(new VMRegisterFarmer3());
        activityRegisterFarmer3Binding.executePendingBindings();
        Intent intent =  getIntent();
        Uid = intent.toString();

        //setContentView(R.layout.activity_register_farmer3);
    }
    @BindingAdapter({"toastMessage"})
    public void onRegister3Clicked(View view) {
        SQLiteHandler sqLiteHandler = new SQLiteHandler(view.getContext());
    if (!TextUtils.isEmpty(registerFarmer3.getFarmName())
            && !TextUtils.isEmpty(registerFarmer3.getFarmAddress())  && !TextUtils.isEmpty(registerFarmer3.getLongitude())
            && !TextUtils.isEmpty(registerFarmer3.getLatitude())) {
        sqLiteHandler.UpdateFarmer3(registerFarmer3.getFarmName(), registerFarmer3.getFarmAddress(),Uid,
                registerFarmer3.getLongitude(), registerFarmer3.getLatitude(), new Date().toString());
        //return registerFarmer1.getUid();

        Intent intent = new Intent(getApplicationContext(), Home.class);
        getApplicationContext().startActivity(intent);

    } else {
        Toast.makeText(view.getContext(), "unSaved", Toast.LENGTH_SHORT).show();
    }

    }



    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
