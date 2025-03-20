package com.example.farmer_app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder>{

    ArrayList<Location> mList;
    Context context;

    public LocationAdapter(ArrayList<Location> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.useritem,parent,false);

        return new LocationAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Location vacancy1 = mList.get(position);
        holder.txtbname.setText("Product Name -"+vacancy1.getProname());
        holder.txtaddress.setText("Description -"+vacancy1.getDesc());
        holder.txttype.setText("Price -"+vacancy1.getPrice());
        holder.txtadd.setText("Quantity -"+vacancy1.getQty());

        Glide.with(holder.img1.getContext()).load(vacancy1.getImageurl()).into(holder.img1);

        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+vacancy1.getFnumber()));
                if(ActivityCompat.checkSelfPermission(view.getContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    return;
                }
                view.getContext().startActivity(intent);


            }
        });

        holder.bet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(),betting.class);

                intent.putExtra("name", vacancy1.getFname());
                intent.putExtra("address",vacancy1.getProname());



                view.getContext().startActivity(intent);

            }
        });





    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView img1,call,bet;
        TextView txtbname,txtaddress,txttype,txtadd;


        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img1 =itemView.findViewById(R.id.img1);
            txtbname = itemView.findViewById(R.id.nametext);
            txtaddress = itemView.findViewById(R.id.coursetext);
            txttype = itemView.findViewById(R.id.emailtext);
            txtadd = itemView.findViewById(R.id.address);
            call = itemView.findViewById(R.id.call);
            bet = itemView.findViewById(R.id.bet);
            relativeLayout=itemView.findViewById(R.id.relative);

        }



    }
}
