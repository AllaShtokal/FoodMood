package com.allashtokal.foodmood.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.allashtokal.foodmood.Interface.ItemClickListener;
import com.allashtokal.foodmood.R;

public class FoodViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener {

    public TextView txtFoodName;
    public ImageView FoodImage;

    private ItemClickListener itemClickListener;
    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);

        txtFoodName = (TextView) itemView.findViewById(R.id.food_name);
        FoodImage = (ImageView) itemView.findViewById(R.id.food_image);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);

    }
}
