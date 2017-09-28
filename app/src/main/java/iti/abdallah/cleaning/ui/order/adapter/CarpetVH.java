package iti.abdallah.cleaning.ui.order.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import iti.abdallah.cleaning.R;
import iti.abdallah.cleaning.model.Carpet;

class CarpetVH extends RecyclerView.ViewHolder {

    @BindView(R.id.numberTV)
    TextView numberTV;
    @BindView(R.id.areaTV)
    TextView areaTV;

    CarpetVH(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void viewOrder(Carpet order) {
        Log.d("test", order.toString());
        numberTV.setText("#" + order.getNumber());
        areaTV.setText(order.getWidth() + " X " + order.getHeight());
    }
}
