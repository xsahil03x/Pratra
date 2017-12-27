package com.magarex.pratra;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by HP on 8/27/2017.
 */

public class OrdersViewHolder extends RecyclerView.ViewHolder {

    TextView item_Name, item_Price, item_Qty, item_Total;

    public OrdersViewHolder(View itemView) {
        super(itemView);

        item_Name = (TextView) itemView.findViewById(R.id.item_Name);
        item_Price = (TextView) itemView.findViewById(R.id.item_Price);
        item_Qty = (TextView) itemView.findViewById(R.id.item_Qty);
        item_Total = (TextView) itemView.findViewById(R.id.item_Total);
    }
}
