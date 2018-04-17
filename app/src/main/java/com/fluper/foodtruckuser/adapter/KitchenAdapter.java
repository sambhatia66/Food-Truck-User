package com.fluper.foodtruckuser.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.fluper.foodtruckuser.R;
import com.fluper.foodtruckuser.model.KitchenItems;

import java.util.ArrayList;

/**
 * Created by fluper on 4/4/18.
 */

public class KitchenAdapter extends RecyclerView.Adapter<KitchenAdapter.MyViewHolder> {
    Context context;
    ArrayList<KitchenItems> kitchenItemsArrayList = new ArrayList<>();


    public KitchenAdapter(Context context, ArrayList<KitchenItems> kitchenItemsArrayList){
        this.context = context;
        this.kitchenItemsArrayList = kitchenItemsArrayList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.singleitem_filterlist_layout, parent,
                false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.kitchenItemName.setText(kitchenItemsArrayList.get(position).getItemName());

    }

    @Override
    public int getItemCount() {
        return kitchenItemsArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        // todo use binding in viewholders , activities inflate and fragment
        private TextView kitchenItemName;
        private CheckBox checkBox;

        public MyViewHolder(View itemView) {
            super(itemView);
            kitchenItemName = itemView.findViewById(R.id.tv_kitchen_item);
            checkBox  = itemView.findViewById(R.id.check_button);

        }
    }
}
