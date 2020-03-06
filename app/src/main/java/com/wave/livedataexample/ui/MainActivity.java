package com.wave.livedataexample.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.wave.livedataexample.R;
import com.wave.livedataexample.model.Pokemon;
import com.wave.livedataexample.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;
    SwipeRefreshLayout swipeRefresh;
    private MainViewModel mainViewModel;
    Button btnFilter;

    PokemonAdapter mPokemonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializationViews();
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        getPokemons();
        // lambda expression
        swipeRefresh.setOnRefreshListener(() -> {
            getPokemons();
        });

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnFilter.setText("filtrado");
                getPokemonsFilter();
            }
        });
    }


    private void initializationViews() {
        swipeRefresh = findViewById(R.id.swiperefresh);
        mRecyclerView = findViewById(R.id.blogRecyclerView);
        btnFilter = findViewById(R.id.btnFilter);
    }

    public void getPokemons() {
        swipeRefresh.setRefreshing(true);
        mainViewModel.getAllPokemon().observe(this, new Observer<List<Pokemon>>() {
            @Override
            public void onChanged(@Nullable List<Pokemon> Pokemon) {
                swipeRefresh.setRefreshing(false);
                prepareRecyclerView(Pokemon);
            }
        });
    }

    public void getPokemonsFilter() {
        swipeRefresh.setRefreshing(true);
        mainViewModel.getFilterPokemon().observe(this, new Observer<List<Pokemon>>() {
            @Override
            public void onChanged(@Nullable List<Pokemon> Pokemon) {
                swipeRefresh.setRefreshing(false);
                prepareRecyclerView(Pokemon);
            }
        });
    }

    private void prepareRecyclerView(List<Pokemon> pokemonList) {

        mPokemonAdapter = new PokemonAdapter(pokemonList);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mPokemonAdapter);
        mPokemonAdapter.notifyDataSetChanged();

    }
}
