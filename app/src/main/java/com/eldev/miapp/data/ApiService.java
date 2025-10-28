package com.eldev.miapp.data;

import com.eldev.miapp.model.Registro;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("registros")
    Call<List<Registro>> getRegistros();
}
