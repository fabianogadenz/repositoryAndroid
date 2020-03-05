package com.wave.livedataexample.model;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.wave.livedataexample.service.RestApiService;
import com.wave.livedataexample.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonRepository {
    private ArrayList<Pokemon> pokemons = new ArrayList<>();
    private MutableLiveData<List<Pokemon>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public PokemonRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Pokemon>> getMutableLiveData() {
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<PokemonWrapper> call = apiService.getPokemons();

        call.enqueue(new Callback<PokemonWrapper>() {
            @Override
            public void onResponse(Call<PokemonWrapper> call, Response<PokemonWrapper> response) {
                PokemonWrapper mPokemonWrapper = response.body();
                if (mPokemonWrapper != null && mPokemonWrapper.getPokemon() != null) {
                    pokemons = (ArrayList<Pokemon>) mPokemonWrapper.getPokemon();
                    mutableLiveData.setValue(pokemons);
                }
            }

            @Override
            public void onFailure(Call<PokemonWrapper> call, Throwable t) {
                Log.d("debug", t.getStackTrace().toString());
            }
        });
        return mutableLiveData;
    }
}
