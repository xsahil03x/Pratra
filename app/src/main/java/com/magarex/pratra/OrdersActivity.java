package com.magarex.pratra;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class OrdersActivity extends AppCompatActivity {

    private RecyclerView list_Orders;
    private ArrayList<Items> Orders = new ArrayList<Items>();
    private Button btnPlaceOrder;
    private TextView grand_Total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Orders");

        Cart cart = new Cart();
        Orders = cart.getCart();

        btnPlaceOrder = (Button)findViewById(R.id.btnPlaceOrder);
        grand_Total = (TextView)findViewById(R.id.grand_Total);

        list_Orders = (RecyclerView)findViewById(R.id.list_Orders);
        OrdersAdapter adapter = new OrdersAdapter(OrdersActivity.this,Orders);
        list_Orders.setAdapter(adapter);
        list_Orders.setLayoutManager(new LinearLayoutManager(this));

        grand_Total.setText("Total  : Rs. "+Cart.getTotal());

        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrdersActivity.this,BillingActivity.class);
                startActivity(intent);
            }
        });

    }
}
