package com.agro.agromall.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.agro.agromall.R;
import com.agro.agromall.models.MHome;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    //private ItemClickListener mListener {
    public static ArrayList<MHome> farmList;
    Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView farmer_picture;
        private TextView farm_name;
        private TextView farmer_name;
        private TextView farm_address;
        private RecyclerView list;


        private MyViewHolder(View view) {
            super(view);
            farmer_picture = (ImageView) view.findViewById(R.id.farmer_picture);
            farm_name = (TextView) view.findViewById(R.id.farm_name);
            farmer_name = (TextView) view.findViewById(R.id.farmer_name);
            farm_address = (TextView) view.findViewById(R.id.farm_address);
            list = (RecyclerView) view.findViewById(R.id.farm_list);
        }
    }

    public HomeAdapter(Context mContext, ArrayList<MHome> postsList) {
        this.mContext = mContext;
        this.farmList = postsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        MHome farms = farmList.get(position);
        holder.farm_name.setText(farms.getFarmName());
        holder.farmer_name.setText(farms.getFullName());
        holder.farm_address.setText(farms.getFarmAddress());
        Picasso.get().load(farms.getFarmerPicture()).into(holder.farmer_picture);

        //applyProfilePicture(holder, events);
    }

    @Override
    public int getItemCount() {
        if (farmList != null) {
            return farmList.size();
        }
        return 0;
    }
}
