package com.agro.agromall.views;

import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Toast;

import com.agro.agromall.R;
import com.agro.agromall.databinding.ActivityMainBinding;
import com.agro.agromall.databinding.ActivityRegisterFarmer1Binding;
import com.agro.agromall.viewmodels.VMRegisterFarmer1;

public class RegisterFarmer1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegisterFarmer1Binding activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_register_farmer1);
        activityMainBinding.setViewModel(new VMRegisterFarmer1());
        activityMainBinding.executePendingBindings();

    }

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
