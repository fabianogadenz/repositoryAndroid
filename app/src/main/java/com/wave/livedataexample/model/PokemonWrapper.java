package com.wave.livedataexample.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class PokemonWrapper {

    @SerializedName("pokemon")
    private List<Pokemon> mPokemon;

    public List<Pokemon> getPokemon() {
        return mPokemon;
    }

    public void setPokemon(List<Pokemon> data) {
        mPokemon = data;
    }


}
