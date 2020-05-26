package com.agro.agromall.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.agro.agromall.R;
import com.agro.agromall.databinding.ActivityRegisterFarmer3Binding;
import com.agro.agromall.viewmodels.VMRegisterFarmer3;

public class RegisterFarmer3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegisterFarmer3Binding activityRegisterFarmer3Binding = DataBindingUtil.setContentView(this, R.layout.activity_register_farmer3);
        activityRegisterFarmer3Binding.setViewModel(new VMRegisterFarmer3());
        activityRegisterFarmer3Binding.executePendingBindings();

        //setContentView(R.layout.activity_register_farmer3);
    }

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
