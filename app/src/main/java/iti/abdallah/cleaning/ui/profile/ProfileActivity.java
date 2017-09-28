package iti.abdallah.cleaning.ui.profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import iti.abdallah.cleaning.R;
import iti.abdallah.cleaning.ui.about.AboutFragment;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, ProfileFragment.newInstance())
                .commit();
    }
}
