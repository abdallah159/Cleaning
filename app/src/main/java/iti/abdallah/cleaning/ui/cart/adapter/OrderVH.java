package iti.abdallah.cleaning.ui.cart.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import iti.abdallah.cleaning.model.Order;


class OrderVH extends RecyclerView.ViewHolder {

    private Order order;

    public OrderVH(View itemView) {
        super(itemView);
    }


    public void setOrder(Order order) {
        this.order = order;

    }
}
