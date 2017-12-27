package com.magarex.pratra;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.security.AccessControlContext;
import java.util.ArrayList;

/**
 * Created by HP on 8/26/2017.
 */

public class OrdersAdapter extends RecyclerView.Adapter<OrdersViewHolder> {

    private Context context;
    private ArrayList<Items> Orders;

    public OrdersAdapter(Context context, ArrayList<Items> orders) {
        this.context = context;
        Orders = orders;
    }

    @Override
    public OrdersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_orders_row, null);
        OrdersViewHolder holder = new OrdersViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(OrdersViewHolder holder, int position) {

        holder.item_Name.setText(Orders.get(position).getItemName());
        holder.item_Price.setText(""+Orders.get(position).getItemPrice());
        holder.item_Qty.setText(""+Orders.get(position).getQty());
        holder.item_Total.setText(""+Orders.get(position).getTotal());

    }

    @Override
    public int getItemCount() {
        return Orders.size();
    }
}
