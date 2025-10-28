package com.eldev.miapp.viewmodel;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SplashViewModel extends ViewModel {


    private final MutableLiveData<Boolean> irSiguienta = new MutableLiveData<>();

    public LiveData<Boolean> navegacionLista() {
        return irSiguienta;
    }

    public void calcularTiempoDelSplash() {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            irSiguienta.setValue(true);
        }, 1000);
    }


}
