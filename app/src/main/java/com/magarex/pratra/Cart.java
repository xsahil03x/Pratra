package com.magarex.pratra;

import java.util.ArrayList;

/**
 * Created by HP on 8/26/2017.
 */

public class Cart
{
    static ArrayList<Items> myCart=new ArrayList<Items>();

    public static void add(Items fi)
    {
        myCart.add(fi);
    }

    public static int getSize()
    {
        return myCart.size();
    }

    public static void clear()
    {
        myCart.clear();
    }

    public static ArrayList<Items> getCart()
    {
        return myCart;
    }
    public static void remove(int position)
    {
        myCart.remove(position);
    }

    public static double getTotal()
    {
        double total=0;
        for(int i=0;i<myCart.size();i++)
        {
            total+=((Items)myCart.get(i)).getTotal();
        }
        return total;
    }
}
