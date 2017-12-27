package com.magarex.pratra;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CakeFragment extends Fragment {

    private RecyclerView recyclerView;
    private View view;
    private ArrayList<Items> cakes = new ArrayList<Items>();

    public CakeFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_cake, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.list_Cakes);

        prepareData();
        recyclerView = (RecyclerView)view.findViewById(R.id.list_Cakes);
        CakesAdapter adapter = new CakesAdapter(getContext(),cakes);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    private void prepareData() {

        Items cake1 = new Items(R.drawable.butterscotch_cake,"ButterScotch",200);
        cakes.add(cake1);

        Items cake2 = new Items(R.drawable.chocolate_cake,"Chocolate",250);
        cakes.add(cake2);

        Items cake3 = new Items(R.drawable.fruit_cake,"Fruit Cake",250);
        cakes.add(cake3);

        Items cake4 = new Items(R.drawable.vanilla_cake,"Vanilla Cake",200);
        cakes.add(cake4);
    }

}
