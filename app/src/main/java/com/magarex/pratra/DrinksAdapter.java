package com.magarex.pratra;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by HP on 8/12/2017.
 */

public class DrinksAdapter extends RecyclerView.Adapter<DrinksViewHolder> {

    private Context context;
    private ArrayList<Items> drinks;
    public static int ITEMTOTAL;


    public DrinksAdapter(Context context, ArrayList<Items> drinks) {
        this.context = context;
        this.drinks = drinks;
    }

    @Override
    public DrinksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_drink_row, null);
        DrinksViewHolder holder = new DrinksViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final DrinksViewHolder holder, final int position) {

        holder.drinks.setImageResource(drinks.get(position).getItemImg());
        holder.drinkName.setText(drinks.get(position).getItemName());
        holder.drinkPrice.setText(""+ drinks.get(position).getItemPrice());

        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (holder.getAdapterPosition()) {
                    case 0:
                        add(holder.qty,holder.drinkTotal,holder.drinkPrice);
                        break;
                    case 1:
                        add(holder.qty,holder.drinkTotal,holder.drinkPrice);
                        break;
                    case 2:
                        add(holder.qty,holder.drinkTotal,holder.drinkPrice);
                        break;
                    case 3:
                        add(holder.qty,holder.drinkTotal,holder.drinkPrice);
                }

            }
        });

        holder.btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (holder.getAdapterPosition()){

                    case 0:
                        sub(holder.qty,holder.drinkTotal,holder.drinkPrice);
                        break;
                    case 1:
                        sub(holder.qty,holder.drinkTotal,holder.drinkPrice);
                        break;
                    case 2:
                        sub(holder.qty,holder.drinkTotal,holder.drinkPrice);
                        break;
                    case 3:
                        sub(holder.qty,holder.drinkTotal,holder.drinkPrice);
                        break;
                }
            }
        });

        holder.drinkSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                switch (holder.getAdapterPosition()){

                    case 0 :
                        if (b) {
                            addToCart(holder.drinkName, holder.drinkPrice, holder.drinkTotal, holder.qty);
                        }
                        if (!b){
                            Cart.remove(0);
                        }
                        break;

                    case 1 :
                        if (b) {
                            addToCart(holder.drinkName, holder.drinkPrice, holder.drinkTotal, holder.qty);
                        }
                        if (!b){
                            Cart.remove(1);
                        }
                        break;

                    case 2 :
                        if (b) {
                            addToCart(holder.drinkName, holder.drinkPrice, holder.drinkTotal, holder.qty);
                        }
                        if (!b){
                            Cart.remove(2);
                        }
                        break;

                    case 3 :
                        if (b) {
                            addToCart(holder.drinkName, holder.drinkPrice, holder.drinkTotal, holder.qty);
                        }
                        if (!b){
                            Cart.remove(3);
                        }
                        break;
                    }
            }
        });
    }



    public void add(EditText drinkqty, TextView txtTotal, TextView txtPrice) {
        int qty = Integer.parseInt(drinkqty.getText().toString());
        qty++;
        int ITEMPRICE = Integer.parseInt(txtPrice.getText().toString());
        ITEMTOTAL = ITEMPRICE * qty;
        if (qty > 0) {
            drinkqty.setText(qty + "");

        } else {
            ITEMTOTAL = ITEMPRICE;
            drinkqty.setText("1");
        }
        txtTotal.setText(ITEMTOTAL + "");
    }

    public void sub(EditText drinkqty, TextView txtTotal, TextView txtPrice) {
        int qty = Integer.parseInt(drinkqty.getText().toString());
        qty--;
        int ITEMPRICE = Integer.parseInt(txtPrice.getText().toString());
        ITEMTOTAL = ITEMPRICE * qty;
        if (qty > 0) {
            drinkqty.setText(qty + "");
        } else {
            drinkqty.setText("1");
            ITEMTOTAL = ITEMPRICE;
        }
        txtTotal.setText(ITEMTOTAL + "");
    }

    public  void addToCart(TextView drink_Name, TextView txtPrice, TextView txtTotal, EditText drinkqty)
    {
        String ITEMNAME = drink_Name.getText().toString();
        int ITEMPRICE = Integer.parseInt(txtPrice.getText().toString());
        int ITEMQTY = Integer.parseInt(drinkqty.getText().toString());
        int TOTAL = Integer.parseInt(txtTotal.getText().toString());

        Items fi=new Items();
        fi.setItemName(ITEMNAME);
        fi.setItemPrice(ITEMPRICE);
        fi.setQty(ITEMQTY);
        fi.setTotal(TOTAL);
        Cart.add(fi);
    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

}




