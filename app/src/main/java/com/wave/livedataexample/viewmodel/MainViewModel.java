package com.wave.livedataexample.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.wave.livedataexample.model.Pokemon;
import com.wave.livedataexample.model.PokemonRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private PokemonRepository pokemonRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        pokemonRepository = new PokemonRepository(application);
    }

    public LiveData<List<Pokemon>> getAllPokemon() {
        return pokemonRepository.getMutableLiveData();
    }


}
