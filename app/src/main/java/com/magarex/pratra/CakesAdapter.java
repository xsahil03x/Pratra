package com.magarex.pratra;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.magarex.pratra.DrinksAdapter.ITEMTOTAL;

/**
 * Created by HP on 8/23/2017.
 */

public class CakesAdapter extends RecyclerView.Adapter<CakesViewHolder> {

    private Context context;
    private ArrayList<Items> cakes;

    public CakesAdapter(Context context, ArrayList<Items> cakes) {
        this.context = context;
        this.cakes = cakes;
    }

    @Override
    public CakesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_cake_row,null);
        CakesViewHolder holder = new CakesViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final CakesViewHolder holder, int position) {

        holder.cakes.setImageResource(cakes.get(position).getItemImg());
        holder.cakeName.setText(cakes.get(position).getItemName());
        holder.cakePrice.setText(""+cakes.get(position).getItemPrice());

        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (holder.getAdapterPosition()) {
                    case 0:
                        add(holder.qty,holder.cakeTotal,holder.cakePrice);
                        break;
                    case 1:
                        add(holder.qty,holder.cakeTotal,holder.cakePrice);
                        break;
                    case 2:
                        add(holder.qty,holder.cakeTotal,holder.cakePrice);
                        break;
                    case 3:
                        add(holder.qty,holder.cakeTotal,holder.cakePrice);
                }

            }
        });

        holder.btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (holder.getAdapterPosition()){

                    case 0:
                        sub(holder.qty,holder.cakeTotal,holder.cakePrice);
                        break;
                    case 1:
                        sub(holder.qty,holder.cakeTotal,holder.cakePrice);
                        break;
                    case 2:
                        sub(holder.qty,holder.cakeTotal,holder.cakePrice);
                        break;
                    case 3:
                        sub(holder.qty,holder.cakeTotal,holder.cakePrice);
                        break;
                }
            }
        });

        holder.cakeSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                switch (holder.getAdapterPosition()){

                    case 0 :
                        if (b) {
                            addToCart(holder.cakeName, holder.cakePrice, holder.cakeTotal, holder.qty);
                        }
                        if (!b){
                            Cart.remove(0);
                        }
                        break;

                    case 1 :
                        if (b) {
                            addToCart(holder.cakeName, holder.cakePrice, holder.cakeTotal, holder.qty);
                        }
                        if (!b){
                            Cart.remove(1);
                        }
                        break;

                    case 2 :
                        if (b) {
                            addToCart(holder.cakeName, holder.cakePrice, holder.cakeTotal, holder.qty);
                        }
                        if (!b){
                            Cart.remove(2);
                        }
                        break;

                    case 3 :
                        if (b) {
                            addToCart(holder.cakeName, holder.cakePrice, holder.cakeTotal, holder.qty);
                        }
                        if (!b){
                            Cart.remove(3);
                        }
                        break;
                }
            }
        });
    }

    public void add(EditText cakeqty, TextView txtTotal, TextView txtPrice) {
        int qty = Integer.parseInt(cakeqty.getText().toString());
        qty++;
        int ITEMPRICE = Integer.parseInt(txtPrice.getText().toString());
        ITEMTOTAL = ITEMPRICE * qty;
        if (qty > 0) {
            cakeqty.setText(qty + "");

        } else {
            ITEMTOTAL = ITEMPRICE;
            cakeqty.setText("1");
        }
        txtTotal.setText(ITEMTOTAL + "");
    }

    public void sub(EditText cakeqty, TextView txtTotal, TextView txtPrice) {
        int qty = Integer.parseInt(cakeqty.getText().toString());
        qty--;
        int ITEMPRICE = Integer.parseInt(txtPrice.getText().toString());
        ITEMTOTAL = ITEMPRICE * qty;
        if (qty > 0) {
            cakeqty.setText(qty + "");
        } else {
            cakeqty.setText("1");
            ITEMTOTAL = ITEMPRICE;
        }
        txtTotal.setText(ITEMTOTAL + "");
    }

    public  void addToCart(TextView cake_Name, TextView txtPrice, TextView txtTotal, EditText cakeqty)
    {
        String ITEMNAME = cake_Name.getText().toString();
        int ITEMPRICE = Integer.parseInt(txtPrice.getText().toString());
        int ITEMQTY = Integer.parseInt(cakeqty.getText().toString());
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
        return cakes.size();
    }
}
