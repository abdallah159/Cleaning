package iti.abdallah.cleaning.ui.about;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import iti.abdallah.cleaning.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, AboutFragment.newInstance())
                .commit();
    }
}
