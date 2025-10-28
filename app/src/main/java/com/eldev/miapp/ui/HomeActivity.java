package com.eldev.miapp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.eldev.miapp.R;
import com.eldev.miapp.ui.fragments.ExplorarFragment;
import com.eldev.miapp.ui.fragments.PerfilFragment;
import com.eldev.miapp.ui.fragments.RegistroFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNav = findViewById(R.id.btn_nav);


        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            int id = item.getItemId();

            if (id == R.id.nav_registros) {
                selectedFragment = new RegistroFragment();
            } else if (id == R.id.nav_explorar) {
                selectedFragment = new ExplorarFragment();
            } else if (id == R.id.nav_profile) {
                selectedFragment = new PerfilFragment();
            }


            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .replace(R.id.main, selectedFragment)
                        .commit();
            }

            return true;
        });

        bottomNav.setSelectedItemId(R.id.nav_registros);
    }
}
