package iti.abdallah.cleaning.ui.cart;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import iti.abdallah.cleaning.R;
import iti.abdallah.cleaning.model.Order;
import iti.abdallah.cleaning.ui.cart.adapter.OrdersAdapter;

public class CartFragment extends Fragment {

    @BindView(R.id.ordersRV)
    RecyclerView ordersRV;

    ArrayList<Order> orders;
    OrdersAdapter ordersAdapter;

    public CartFragment() {}

    public static CartFragment newInstance() {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        ButterKnife.bind(this, view);
        getActivity().setTitle("Orders");
        return view;
    }

}
