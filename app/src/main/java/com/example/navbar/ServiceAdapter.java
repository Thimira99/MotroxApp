package com.example.navbar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.MyViewHolder> {

    public Context context;
    Activity activity;
    public ArrayList Service_id,Owner_NIC,Owner_Name,Vehicle_Number,Service_Type,Date,Time;

    ServiceAdapter(Activity activity,
                   Context context,
                   ArrayList Service_id,
                   ArrayList Owner_NIC,
                   ArrayList Owner_Name,
                   ArrayList Vehicle_Number,
                   ArrayList Service_Type,
                   ArrayList Date,
                   ArrayList Time){
        this.activity = activity;
        this.context = context;
        this.Service_id = Service_id;
        this.Owner_NIC = Owner_NIC;
        this.Owner_Name = Owner_Name;
        this.Vehicle_Number = Vehicle_Number;
        this.Service_Type = Service_Type;
        this.Date = Date;
        this.Time = Time;

    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.service_raw,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ServiceAdapter.MyViewHolder holder, int position) {

        holder.Service_id_txt.setText(String.valueOf(Service_id.get(position)));
        holder.Owner_Name_txt.setText(String.valueOf(Owner_Name.get(position)));
        holder.Owner_NIC_txt.setText(String.valueOf(Owner_NIC.get(position)));
        holder.Vehicle_Number_txt.setText(String.valueOf(Vehicle_Number.get(position)));
        holder.Service_type_txt.setText(String.valueOf(Service_Type.get(position)));
        holder.Date_txt.setText(String.valueOf(Date.get(position)));
        holder.time_txt.setText(String.valueOf(Time.get(position)));

        holder.main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,UpdateService.class);
                intent.putExtra("id",String.valueOf(Service_id.get(position)));
                intent.putExtra("owner_name",String.valueOf(Owner_Name.get(position)));
                intent.putExtra("owner_nic",String.valueOf(Owner_NIC.get(position)));
                intent.putExtra("vehicle_number",String.valueOf(Vehicle_Number.get(position)));
                intent.putExtra("service_type",String.valueOf(Service_Type.get(position)));
                intent.putExtra("date",String.valueOf(Date.get(position)));
                intent.putExtra("time",String.valueOf(Time.get(position)));
                activity.startActivityForResult(intent,1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return Service_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Service_id_txt,Owner_Name_txt,Owner_NIC_txt,Vehicle_Number_txt,Service_type_txt,Date_txt,time_txt;
        LinearLayout main;

        public MyViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            Service_id_txt = itemView.findViewById(R.id.Service_id_txt);
            Owner_Name_txt = itemView.findViewById(R.id.Owner_Name_txt);
            Owner_NIC_txt = itemView.findViewById(R.id.Owner_NIC_txt);
            Vehicle_Number_txt = itemView.findViewById(R.id.Vehicle_Number_txt);
            Service_type_txt = itemView.findViewById(R.id.Service_type_txt);
            Date_txt = itemView.findViewById(R.id.Date_txt);
            time_txt = itemView.findViewById(R.id.time_txt);

            main = itemView.findViewById(R.id.main);
        }
    }
}
