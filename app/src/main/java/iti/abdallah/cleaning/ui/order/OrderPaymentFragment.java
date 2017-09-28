package iti.abdallah.cleaning.ui.order;

import android.app.Activity;
import android.content.Context;
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

public class OrderPaymentFragment extends Fragment {

    @BindView(R.id.visaTV)
    TextView visaTV;
    @BindView(R.id.cashTV)
    TextView cashTV;

    private static final String ORDER_KEY = "order";
    OnFinishOrder onFinishOrder;
    private Order order;

    public OrderPaymentFragment() {}

    public static OrderPaymentFragment newInstance(Order order) {
        OrderPaymentFragment fragment = new OrderPaymentFragment();
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
            Log.d("s2", "sucess" + order.toString());
        } else {
            order = new Order();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_payment, container, false);
        ButterKnife.bind(this, view);
        if(order.getPaymentType().equals("cash"))
            selectCash();
        else
            selectVisa();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;

        if (context instanceof Activity) {
            activity = (Activity) context;

            try {
                onFinishOrder = (OnFinishOrder) activity;
                Log.d("test", activity.toString());
            } catch (Exception e) {
                throw new ClassCastException(activity.toString()
                        + " must implement OnHeadlineSelectedListener");
            }
        }
    }

    @OnClick(R.id.finishL)
    void finishStep() {
        onFinishOrder.onFinishOrder(order);
    }

    public interface OnFinishOrder {
        void onFinishOrder(Order order);
    }

    @OnClick(R.id.visaTV)
    void selectVisa() {
        order.setPaymentType("visa");
        visaTV.setBackgroundResource(R.color.colorAccent);
        cashTV.setBackgroundResource(R.color.whiteColor);
        visaTV.setTextColor(ContextCompat.getColor(getContext(), R.color.whiteColor));
        cashTV.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
    }

    @OnClick(R.id.cashTV)
    void selectCash() {
        order.setPaymentType("cash");
        cashTV.setBackgroundResource(R.color.colorAccent);
        visaTV.setBackgroundResource(R.color.whiteColor);
        cashTV.setTextColor(ContextCompat.getColor(getContext(), R.color.whiteColor));
        visaTV.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));    }
}
