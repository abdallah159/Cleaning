package iti.abdallah.cleaning.ui.order.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import iti.abdallah.cleaning.R;
import iti.abdallah.cleaning.model.Carpet;

public class CarpetsAdapter extends RecyclerView.Adapter<CarpetVH> {

    private ArrayList<Carpet> orders = new ArrayList<>();

    public CarpetsAdapter(ArrayList<Carpet> orders) {
        this.orders = orders;
    }

    @Override
    public CarpetVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CarpetVH(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order, null));
    }

    @Override
    public void onBindViewHolder(CarpetVH holder, int position) {
        holder.viewOrder(orders.get(position));
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }
}
