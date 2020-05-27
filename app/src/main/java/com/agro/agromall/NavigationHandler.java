package com.agro.agromall;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.agro.agromall.models.User;
import com.agro.agromall.views.Home;
import com.agro.agromall.views.RegisterFarmer1;
import com.agro.agromall.views.RegisterFarmer2;

public class NavigationHandler {
    User user;

    public void onLoginClick(View view) {
        //if (user.isInputDataValid()) {
            Context context = view.getContext();
            Intent intent = new Intent(context, RegisterFarmer1.class);
            //intent.putExtra("uid", uid);
            context.startActivity(intent);
        //}
    }
    public void onRegister1Click(View view, String uid) {
        Context context = view.getContext();
        Intent intent = new Intent(context, RegisterFarmer2.class);
        intent.putExtra("uid", uid);
        context.startActivity(intent);

    }
}
