package iti.abdallah.cleaning.ui.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import iti.abdallah.cleaning.R;
import iti.abdallah.cleaning.model.Carpet;
import iti.abdallah.cleaning.model.Order;
import iti.abdallah.cleaning.ui.order.adapter.CarpetsAdapter;

public class OrderFragment extends Fragment {

    @BindView(R.id.carpetsRV)
    RecyclerView carpetsRV;

    private static final String ORDER_KEY = "order";
    private Order order;

    CarpetsAdapter carpetsAdapter;
    ArrayList<Carpet> carpets = new ArrayList<>();

    public OrderFragment() {
    }

    public static OrderFragment newInstance(Order order) {
        OrderFragment fragment = new OrderFragment();
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
        } else {
            order = new Order();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        ButterKnife.bind(this, view);

        carpetsAdapter = new CarpetsAdapter(carpets);
        carpetsRV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false));
        carpetsRV.setAdapter(carpetsAdapter);
        return view;
    }

    @OnClick(R.id.addCarpetsL)
    void addCarpet() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_add_carpet, null);

        final EditText widthET = view.findViewById(R.id.widthET);
        final EditText highET = view.findViewById(R.id.highET);

        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();
        view.findViewById(R.id.addCarpetB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((widthET != null || !widthET.getText().toString().isEmpty()) &&
                        (highET != null || !highET.getText().toString().isEmpty())) {
                    addCarpetRV(widthET.getText().toString(), highET.getText().toString());
                    dialog.dismiss();
                }
            }
        });
    }

    void addCarpetRV(String width, String high) {
        Carpet carpet = new Carpet(carpets.size() + 1, width, high);
        carpets.add(carpet);
        carpetsAdapter.notifyItemInserted(carpets.size() - 1);
        carpetsRV.scrollToPosition(carpets.size() - 1);
    }

    @OnClick(R.id.nextL)
    void nextStep() {
        if (carpets == null || carpets.isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_error_empty_carpets, null);
            builder.setView(view);
            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            order.setCarpets(carpets);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, OrderTypeFragment.newInstance(order));
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
