package com.wave.livedataexample.service;

import com.wave.livedataexample.model.PokemonWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiService {

    @GET("ability/4")
    Call<PokemonWrapper> getPokemons();

}
