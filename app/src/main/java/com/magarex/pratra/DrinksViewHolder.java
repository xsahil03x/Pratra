package com.magarex.pratra;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by HP on 8/19/2017.
 */

public class DrinksViewHolder extends RecyclerView.ViewHolder {

    ImageView drinks;
    TextView drinkName,drinkPrice,drinkTotal;
    EditText qty;
    CheckBox drinkSelect;
    Button btnAdd,btnSub;


    public DrinksViewHolder(View itemView) {
        super(itemView);

        drinks =(ImageView)itemView.findViewById(R.id.image_drinks);
        drinkName =(TextView) itemView.findViewById(R.id.drinks_name);
        drinkPrice =(TextView) itemView.findViewById(R.id.drinks_price);
        drinkTotal = (TextView) itemView.findViewById(R.id.drink_Total);
        qty =(EditText) itemView.findViewById(R.id.drink_qty);
        drinkSelect =(CheckBox) itemView.findViewById(R.id.checkBoxAddtoCart);
        btnAdd =(Button) itemView.findViewById(R.id.btnadddrink);
        btnSub =(Button) itemView.findViewById(R.id.btnremovedrink);
    }
}
