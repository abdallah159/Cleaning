package iti.abdallah.cleaning.ui.order;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import iti.abdallah.cleaning.R;
import iti.abdallah.cleaning.model.Order;


public class OrderTypeFragment extends Fragment {

    @BindView(R.id.normalTV)
    TextView normalTV;
    @BindView(R.id.fastTV)
    TextView fastTV;

    private static final String ORDER_KEY = "order";
    private Order order;

    public OrderTypeFragment() {}

    public static OrderTypeFragment newInstance(Order order) {
        OrderTypeFragment fragment = new OrderTypeFragment();
        Bundle args = new Bundle();
        args.putSerializable(ORDER_KEY, order);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            order = (Order) getArguments().getSerializable(ORDER_KEY);
            Log.d("s1", "sucess" + order.toString());
        } else {
            order = new Order();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_type, container, false);
        ButterKnife.bind(this, view);
        if(order.getServiceType().equals("normal"))
            selectNormalService();
        else
            selectFastService();
        return view;
    }

    @OnClick(R.id.nextL)
    void nextStep() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, OrderPaymentFragment.newInstance(order));
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @OnClick(R.id.fastTV)
    void selectFastService() {
        order.setServiceType("fast");
        fastTV.setBackgroundResource(R.color.colorAccent);
        normalTV.setBackgroundResource(R.color.whiteColor);
        fastTV.setTextColor(ContextCompat.getColor(getContext(), R.color.whiteColor));
        normalTV.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
    }

    @OnClick(R.id.normalTV)
    void selectNormalService() {
        order.setServiceType("normal");
        normalTV.setBackgroundResource(R.color.colorAccent);
        fastTV.setBackgroundResource(R.color.whiteColor);
        normalTV.setTextColor(ContextCompat.getColor(getContext(), R.color.whiteColor));
        fastTV.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
    }
}
