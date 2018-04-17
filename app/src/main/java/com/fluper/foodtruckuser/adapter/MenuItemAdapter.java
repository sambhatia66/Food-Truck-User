package com.fluper.foodtruckuser.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fluper.foodtruckuser.R;
import com.fluper.foodtruckuser.activities.MenuFragment;

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.MyViewHolder> {
    Context context;


    public MenuItemAdapter(Context context) {
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.singleitem_menu_layout, parent,
                false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.ivItemImage.setImageResource(R.drawable.food_fifteen);

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivItemImage;
        private TextView tvItemName;
        private TextView tvItemDescription;
        private TextView tvItemPrice;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivItemImage = itemView.findViewById(R.id.iv_item);
            tvItemDescription = itemView.findViewById(R.id.tv_item_description);
            tvItemPrice = itemView.findViewById(R.id.tv_item_price);
            tvItemName = itemView.findViewById(R.id.tv_item_name);

        }
    }
}
