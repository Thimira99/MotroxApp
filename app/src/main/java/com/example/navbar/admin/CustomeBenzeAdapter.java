package com.example.navbar.admin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navbar.R;

import java.util.ArrayList;

public class CustomeBenzeAdapter extends RecyclerView.Adapter<CustomeBenzeAdapter.MyViewHolder>{
    private Context context;
    private Activity activity;
    private ArrayList itemid, itemNmae, itemDetails, itemPrize;

    CustomeBenzeAdapter(Activity activity, Context context, ArrayList itemid, ArrayList itemNmae, ArrayList itemDetails,
                  ArrayList itemPrize){
        this.activity = activity;
        this.context = context;
        this.itemid = itemid;
        this.itemNmae = itemNmae;
        this.itemDetails = itemDetails;
        this.itemPrize = itemPrize;
    }

    @NonNull
    @Override
    public CustomeBenzeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new CustomeBenzeAdapter.MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final CustomeBenzeAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.itemId.setText(String.valueOf(itemid.get(position)+"."));
        holder.itemName.setText(String.valueOf(itemNmae.get(position)));
        holder.itemDescription.setText(String.valueOf(itemDetails.get(position)));
        holder.itemPrize.setText("Rs : "+String.valueOf(itemPrize.get(position)+".00"));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActicityBenze.class);
                intent.putExtra("id", String.valueOf(itemid.get(position)));
                intent.putExtra("title", String.valueOf(itemNmae.get(position)));
                intent.putExtra("author", String.valueOf(itemDetails.get(position)));
                intent.putExtra("pages", String.valueOf(itemPrize.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return itemid.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemId, itemName, itemDescription, itemPrize;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemId = itemView.findViewById(R.id.book_id_txt);
            itemName = itemView.findViewById(R.id.book_title_txt);
            itemDescription = itemView.findViewById(R.id.book_author_txt);
            itemPrize = itemView.findViewById(R.id.book_pages_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}

