package com.allashtokal.foodmood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.allashtokal.foodmood.Interface.ItemClickListener;
import com.allashtokal.foodmood.Model.Category;
import com.allashtokal.foodmood.Model.Food;
import com.allashtokal.foodmood.ViewHolder.FoodViewHolder;
import com.allashtokal.foodmood.ViewHolder.MenuViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class FoodList extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference foodList;

    TextView txtFullName;
    RecyclerView recycler_food;
    RecyclerView.LayoutManager layoutManager;
    String CategoryID ="";
    FirebaseRecyclerAdapter<Food, FoodViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        //Firebase
        database = FirebaseDatabase.getInstance();
        foodList = database.getReference("Food");

        //Load menu
        recycler_food = (RecyclerView)findViewById(R.id.recycler_food);
        recycler_food.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycler_food.setLayoutManager(layoutManager);
        //getIntent here
        loadFoodList();

    }

    private void loadFoodList() {
    if (getIntent() != null)
        CategoryID = getIntent().getStringExtra("CategoryID");
    if (!CategoryID.isEmpty() && CategoryID != null)
    {
        adapter = new FirebaseRecyclerAdapter<Food,FoodViewHolder>(Food.class,
                R.layout.food_item,
                FoodViewHolder.class,
                foodList.orderByChild("MenuID").equalTo(CategoryID)
        )
        {
            @Override
            protected void populateViewHolder(FoodViewHolder viewHolder, Food model, int position) {
                viewHolder.txtFoodName.setText(model.getName());
                Picasso.get().load(model.getImage()).into(viewHolder.FoodImage);

                final Food clickItem = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Toast.makeText(FoodList.this,""+ clickItem.getName(),Toast.LENGTH_SHORT).show();


                    }
                });

            }
        };
        Log.d("TAG",""+adapter.getItemCount());
        recycler_food.setAdapter(adapter);
    }

    }
}
