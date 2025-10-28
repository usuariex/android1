package com.eldev.miapp.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.eldev.miapp.R;
import com.eldev.miapp.data.ApiService;
import com.eldev.miapp.data.RetrofitClient;
import com.eldev.miapp.ui.HomeActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    private EditText inputEmail, inputPass;
    private Button botonIngresar;
    ImageView togglePass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        inputEmail = findViewById(R.id.inputEmail);
        inputPass = findViewById(R.id.inputPass);
        botonIngresar = findViewById(R.id.btnIngresar);
        togglePass = findViewById(R.id.togglePass);


        final boolean[] isPasswordVisible = {false};

        togglePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordVisible[0]) {
                    inputPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    togglePass.setImageResource(R.drawable.eye_closed);
                } else {
                    inputPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    togglePass.setImageResource(R.drawable.eye_open);
                }
                inputPass.setSelection(inputPass.getText().length());
                isPasswordVisible[0] = !isPasswordVisible[0];
            }
        });

    }


    public void irAHome(View v) {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);

    }
}
