package com.agro.agromall;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.agro.agromall.views.RegisterFarmer1;

public class NavigationHandler {
    public void onLoginClick(View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, RegisterFarmer1.class);
        //intent.putExtra("productId", productId);
        context.startActivity(intent);
    }
}
