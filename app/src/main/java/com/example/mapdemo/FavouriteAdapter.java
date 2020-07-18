package com.example.mapdemo;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mapdemo.util.SQLHelperClass;

import java.util.ArrayList;
import java.util.HashMap;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.FavouriteViewHolder> {
    Context context;
    private static final String TAG = "FavouriteAdapter";
    private ArrayList location_id, location_latitude, location_longitude, location_city,location_state,location_pincode;

    public FavouriteAdapter(Activity activity, Context context, ArrayList location_id, ArrayList location_latitude, ArrayList location_longitude,
                            ArrayList location_city, ArrayList location_state, ArrayList location_pincode ) {
        activity = activity;
        context = context;
        location_id= location_id;
        location_latitude =location_latitude;
        location_longitude=location_longitude;
        location_city=location_city;
        location_state=location_state;
        location_pincode=location_pincode;

    }

    @NonNull
    @Override
    public FavouriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_favourite, null);
        return new FavouriteAdapter.FavouriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteViewHolder holder, int position) {
        //getting the product of the specified position
        holder.tv_latitude.setText(String.valueOf(location_latitude.get(position)));
        holder.tv_longitude.setText(String.valueOf(location_longitude.get(position)));
        holder.tv_city.setText(String.valueOf(location_city.get(position)));
        holder.tv_state.setText(String.valueOf(location_state.get(position)));
        holder.tv_pincode.setText(String.valueOf(location_pincode.get(position)));
        Log.e(TAG, "onBindViewHolder: "+String.valueOf(location_latitude.get(position)));
        //binding the data with the viewholder views

    }

    @Override
    public int getItemCount() {
        return location_id.size();
    }

    public class FavouriteViewHolder extends RecyclerView.ViewHolder {
        TextView tv_latitude,tv_longitude,tv_city,tv_state,tv_pincode;
        public FavouriteViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_latitude = (TextView)itemView.findViewById(R.id.tv_latitude);
            tv_longitude = (TextView)itemView.findViewById(R.id.tv_longitude);
            tv_city = (TextView)itemView.findViewById(R.id.tv_city);
            tv_state = (TextView)itemView.findViewById(R.id.tv_state);
            tv_pincode = (TextView)itemView.findViewById(R.id.tv_pincode);

        }
    }
}
