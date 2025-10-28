package com.eldev.miapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.eldev.miapp.R;
import com.eldev.miapp.ui.login.LoginActivity;
import com.eldev.miapp.viewmodel.SplashViewModel;

public class SplashActivity extends AppCompatActivity {

    private SplashViewModel splashViewModel;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashViewModel = new ViewModelProvider(this).get(SplashViewModel.class);
        logo = findViewById(R.id.logo);

        splashViewModel.navegacionLista().observe(this, senalnavegar -> {
            if (senalnavegar != null && senalnavegar) {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        splashViewModel.calcularTiempoDelSplash();
        logo.setAlpha(0f);
        logo.animate().alpha(1f).setDuration(500);
    }



}
