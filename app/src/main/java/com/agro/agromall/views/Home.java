package com.agro.agromall.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.agro.agromall.R;
import com.agro.agromall.models.MHome;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static com.agro.agromall.views.HomeAdapter.farmList;

public class Home extends AppCompatActivity {
    HomeAdapter homeAdapter;
    public RecyclerView recyclerView;
    public FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = (RecyclerView) findViewById(R.id.farm_list);


        floatingActionButton=findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                getApplicationContext().startActivity(intent);
            }
        });
        /*homeAdapter = new HomeAdapter();
        recyclerView.setAdapter(homeAdapter);*/
        //getting access to view model class



        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        String tag_string_req = "req_home";
        //ArrayList<MHome> postList = MHome();
        HomeAdapter adapter = new HomeAdapter(getApplicationContext(), farmList);
        recyclerView.setAdapter(adapter);




    }




}
