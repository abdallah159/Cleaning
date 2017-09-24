package iti.abdallah.cleaning.ui.map;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.ButterKnife;
import butterknife.OnClick;
import iti.abdallah.cleaning.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng userPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        ButterKnife.bind(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;

        // Move the camera to  Damita
        LatLng damita = new LatLng(31.419024, 31.814678);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(damita, 10));

        //Take user position when he click map
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                markerOptions.title("Your Place");
                mMap.clear();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
                //user position
                userPosition = new LatLng(latLng.latitude, latLng.longitude);
                mMap.addMarker(markerOptions);
                Log.v(latLng.toString(), "+++++");
            }
        });

    }

    @OnClick(R.id.continueBTN)
    public void fillForm() {
        if (userPosition == null) {
            Toast.makeText(getApplicationContext(), "Please select location", Toast.LENGTH_SHORT).show();
        } else {
            AlertDialog.Builder mBulder = new AlertDialog.Builder(MapsActivity.this);
            View mView = getLayoutInflater().inflate(R.layout.dialog_form, null);

            EditText fullName = mView.findViewById(R.id.fullnameET);
            EditText order = mView.findViewById(R.id.orderET);
            Button orderNow = mView.findViewById(R.id.orderBTN);
            orderNow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //Handle order now Button
                }
            });

            mBulder.setView(mView);
            AlertDialog dialog = mBulder.create();
            dialog.show();
        }

    }
}
