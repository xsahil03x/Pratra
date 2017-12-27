package com.magarex.pratra;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class DrinkFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private ArrayList<Items> drinks = new ArrayList<Items>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_drink, container, false);

        prepareData();
        recyclerView = (RecyclerView)view.findViewById(R.id.list_Drinks);
        DrinksAdapter adapter = new DrinksAdapter(getContext(),drinks);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    private void prepareData() {

        Items drink1 = new Items(R.drawable.cappuccino,"Cappuccino",200);
        drinks.add(drink1);

        Items drink2 = new Items(R.drawable.americano,"Americano",250);
        drinks.add(drink2);

        Items drink3 = new Items(R.drawable.mint_tea,"Mint Tea",180);
        drinks.add(drink3);

        Items drink4 = new Items(R.drawable.lassi,"Lassi",200);
        drinks.add(drink4);
    }
}

