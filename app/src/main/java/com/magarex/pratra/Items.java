package com.magarex.pratra;

/**
 * Created by HP on 8/19/2017.
 */

public class Items {

    private int ItemImg;
    private String ItemName;
    private int ItemPrice;
    private int qty;
    private int total;

    public Items(){

    }

    public Items(int ItemImg, String ItemName, int ItemPrice) {
        this.ItemImg = ItemImg;
        this.ItemName = ItemName;
        this.ItemPrice = ItemPrice;
    }

    public int getItemImg() {
        return ItemImg;
    }

    public void setItemImg(int itemImg) {
        ItemImg = itemImg;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(int itemPrice) {
        ItemPrice = itemPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
