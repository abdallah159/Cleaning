package iti.abdallah.cleaning.ui.cart.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import iti.abdallah.cleaning.R;
import iti.abdallah.cleaning.model.Order;

public class OrdersAdapter extends RecyclerView.Adapter<OrderVH> {

    ArrayList<Order>  orders = new ArrayList<>();

    public OrdersAdapter(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public OrderVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OrderVH(LinearLayout.inflate(parent.getContext()
                , R.layout.item_order_cart, null));
    }

    @Override
    public void onBindViewHolder(OrderVH holder, int position) {
        holder.setOrder(orders.get(position));
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }
}
