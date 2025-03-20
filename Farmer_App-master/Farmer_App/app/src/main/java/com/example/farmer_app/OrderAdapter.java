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

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {



    ArrayList<Userbetting> mList;
    Context context;

    public OrderAdapter(ArrayList<Userbetting> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_list,parent,false);

        return new OrderAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Userbetting vacancy1 = mList.get(position);
        holder.txtbname.setText("User Name -"+vacancy1.getUname());
        holder.txtaddress.setText("Price -"+vacancy1.getPrice());
        holder.txttype.setText("Time -"+vacancy1.getTime());
        holder.txtadd.setText("Product Name -"+vacancy1.getProname());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),details.class);

                intent.putExtra("uname", vacancy1.getUname());
                intent.putExtra("unumber",vacancy1.getUnumber());
                intent.putExtra("uaddress", vacancy1.getUaddress());
                intent.putExtra("fname",vacancy1.getFname());
                intent.putExtra("proname", vacancy1.getProname());
                intent.putExtra("date",vacancy1.getDate());
                intent.putExtra("time",vacancy1.getTime());

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
