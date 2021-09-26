package com.example.navbar;

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

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList id,nic,firstName,lastName,streetAddress,city,email,phoneNum,qty;


    CustomAdapter(Context context,
                  ArrayList id,
                  ArrayList nic,
                  ArrayList firstName,
                  ArrayList lastName,
                  ArrayList streetAddress,
                  ArrayList city,
                  ArrayList email,
                  ArrayList phoneNum,
                  ArrayList qty
                  ){
        this.context = context;
        this.id =id;
        this.nic = nic;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.email = email;
        this.phoneNum = phoneNum;
        this.qty = qty;


    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.order_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

      //  this.position = position;

        holder.nic_txt.setText(String.valueOf(nic.get(position)));
        holder.firstName_txt.setText(String.valueOf(firstName.get(position)));
        holder.lastName_txt.setText(String.valueOf(lastName.get(position)));
        holder.streetAddress_txt.setText(String.valueOf(streetAddress.get(position)));
        holder.city_txt.setText(String.valueOf(city.get(position)));
        holder.email_txt.setText(String.valueOf(email.get(position)));
        holder.phoneNum_txt.setText(String.valueOf(phoneNum.get(position)));
        holder.qty_txt.setText(String.valueOf(qty.get(position)));
        //holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {
               //Intent intent = new Intent(context, Updata_Order.class);//intent.putExtra("id", String.valueOf(id.get(position)));
               // intent.putExtra("nic", String.valueOf(nic.get(position)));
               // intent.putExtra("firstName", String.valueOf(firstName.get(position)));
                //intent.putExtra("lastName", String.valueOf(lastName.get(position)));
               // intent.putExtra("streetAddress", String.valueOf(streetAddress.get(position)));
               // intent.putExtra("city", String.valueOf(city.get(position)));
               // intent.putExtra("email", String.valueOf(email.get(position)));
               //intent.putExtra("phoneNum", String.valueOf(phoneNum.get(position)));
               // intent.putExtra("qty", String.valueOf(qty.get(position)))  ;
               // context.startActivity(intent);

            }
        //});


    //}

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id_txt,nic_txt,firstName_txt,lastName_txt,streetAddress_txt,city_txt,email_txt,phoneNum_txt,qty_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id_txt = itemView.findViewById(R.id.id_txt);
            nic_txt = itemView.findViewById(R.id.nic_txt);
            firstName_txt = itemView.findViewById(R.id.firstName_txt);
            lastName_txt = itemView.findViewById(R.id.lastName_txt);
            streetAddress_txt = itemView.findViewById(R.id.streetAddress_txt);
            city_txt = itemView.findViewById(R.id.city_txt);
            email_txt = itemView.findViewById(R.id.email_txt);
            phoneNum_txt = itemView.findViewById(R.id.phoneNum_txt);
            qty_txt = itemView.findViewById(R.id.qty_txt);

           // mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
