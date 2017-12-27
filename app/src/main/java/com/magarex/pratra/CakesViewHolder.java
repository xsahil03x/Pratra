package com.magarex.pratra;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by HP on 8/23/2017.
 */

public class CakesViewHolder extends RecyclerView.ViewHolder {

    ImageView cakes;
    TextView cakeName,cakePrice,cakeTotal;
    EditText qty;
    CheckBox cakeSelect;
    Button btnAdd,btnSub;

    public CakesViewHolder(View itemView) {
        super(itemView);

        cakes =(ImageView)itemView.findViewById(R.id.image_cakes);
        cakeName =(TextView) itemView.findViewById(R.id.cakes_name);
        cakePrice =(TextView) itemView.findViewById(R.id.cakes_price);
        qty =(EditText) itemView.findViewById(R.id.cake_qty);
        cakeSelect =(CheckBox) itemView.findViewById(R.id.checkBoxAddtoCart);
        btnAdd =(Button) itemView.findViewById(R.id.btnaddcake);
        btnSub =(Button) itemView.findViewById(R.id.btnremovecake);
        cakeTotal = (TextView) itemView.findViewById(R.id.cake_Total);

    }
}
