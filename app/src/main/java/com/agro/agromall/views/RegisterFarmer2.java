package com.agro.agromall.views;

import android.app.Activity;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.agro.agromall.R;
import com.agro.agromall.databinding.ActivityRegisterFarmer2Binding;
import com.agro.agromall.viewmodels.VMRegisterFarmer2;

public class RegisterFarmer2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegisterFarmer2Binding activityRegisterFarmer2Binding =
                DataBindingUtil.setContentView(this, R.layout.activity_register_farmer2);
        activityRegisterFarmer2Binding.setViewModel(new VMRegisterFarmer2());
        activityRegisterFarmer2Binding.executePendingBindings();
    }
}
