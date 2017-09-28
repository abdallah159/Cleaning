package iti.abdallah.cleaning.ui.map;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.maps.model.LatLng;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import iti.abdallah.cleaning.R;
import iti.abdallah.cleaning.model.Location;
import iti.abdallah.cleaning.model.Order;
import iti.abdallah.cleaning.ui.about.AboutActivity;
import iti.abdallah.cleaning.ui.about.AboutFragment;
import iti.abdallah.cleaning.ui.cart.CartFragment;
import iti.abdallah.cleaning.ui.order.OrderFragment;
import iti.abdallah.cleaning.ui.order.OrderPaymentFragment;
import iti.abdallah.cleaning.ui.profile.ProfileActivity;

public class MapsActivity extends AppCompatActivity implements OrderPaymentFragment.OnFinishOrder,
        NavigationView.OnNavigationItemSelectedListener, MapFragment.OnFragmentInteractionListener {

    @BindView(R.id.orderL)
    LinearLayout orderL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_container, MapFragment.newInstance());
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else if (orderL.getVisibility() != View.GONE) {
            orderL.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onFinishOrder(Order order) {
        orderL.setVisibility(View.GONE);
        Log.d("order on finish", order.toString());
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            openMap();
        } else if (id == R.id.nav_gallery) {
            openCart();
        } else if (id == R.id.nav_slideshow) {
            openAbout();
        } else if (id == R.id.nav_manage) {
            openProfile();
        } else if(id == R.id.nav_exit) {
            exitApp();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void exitApp() {
        //ToDo exit app
    }

    private void openProfile() {
        startActivity(new Intent(this, ProfileActivity.class));
    }

    private void openAbout() {
        startActivity(new Intent(this, AboutActivity.class));
    }

    private void openCart() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_container, CartFragment.newInstance())
                .commit();
    }

    private void openMap() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_container, MapFragment.newInstance())
                .commit();
    }

    @Override
    public void onAddOrderClick(LatLng userPosition) {
        if (userPosition != null) {
            Order order = new Order();
            order.setLocation(new Location(userPosition));

            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, OrderFragment.newInstance(order));
            transaction.commit();

            orderL.setVisibility(View.VISIBLE);
        }
    }
}
