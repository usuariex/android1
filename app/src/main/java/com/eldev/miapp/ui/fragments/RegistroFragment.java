package com.eldev.miapp.ui.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eldev.miapp.R;
import com.eldev.miapp.data.ApiService;
import com.eldev.miapp.data.RetrofitClient;
import com.eldev.miapp.model.Registro;
import com.eldev.miapp.ui.adapters.RegistroAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroFragment extends Fragment {

    private RecyclerView rvRegistros;
    private Handler handler = new Handler();
    private Runnable updateTask;
    private static final int INTERVAL = 1000; // 1 segundo

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.regsitros_reservas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvRegistros = view.findViewById(R.id.rvReservasPasadas);
        rvRegistros.setLayoutManager(new LinearLayoutManager(getContext()));

        updateTask = new Runnable() {
            @Override
            public void run() {
                cargarRegistros();
                handler.postDelayed(this, INTERVAL);
            }
        };

        handler.post(updateTask);
    }

    private void cargarRegistros() {
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);
        Call<List<Registro>> call = apiService.getRegistros();

        call.enqueue(new Callback<List<Registro>>() {
            @Override
            public void onResponse(Call<List<Registro>> call, Response<List<Registro>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    RegistroAdapter adapter = new RegistroAdapter(response.body());
                    rvRegistros.setAdapter(adapter);
                } else {
                    Log.e("RegistroFragment", "Respuesta vacía o no exitosa");
                }
            }

            @Override
            public void onFailure(Call<List<Registro>> call, Throwable t) {
                Log.e("RegistroFragment", "Error de conexión: " + t.getMessage());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacks(updateTask);
    }
}
