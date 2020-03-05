package com.wave.livedataexample.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wave.livedataexample.R;
import com.wave.livedataexample.model.Pokemon;

import java.util.List;

/**
 * Created on : Feb 26, 2019
 * Author     : AndroidWave
 */
public class PokemonAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final String TAG = "PokemonAdapter";

    private List<Pokemon> mPokemonList;

    public PokemonAdapter(List<Pokemon> pokemonList) {
        mPokemonList = pokemonList;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.blog_item, parent, false));
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        if (mPokemonList != null && mPokemonList.size() > 0) {
            return mPokemonList.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends BaseViewHolder {

        TextView tvTitle;
        TextView tvDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }

        protected void clear() {
            tvTitle.setText("");
            tvDescription.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            final Pokemon mPokeon = mPokemonList.get(position);

            if (mPokeon.getmIsHidden()) {
                tvTitle.setText("true");
            } else
                tvTitle.setText("false");

            tvDescription.setText("TESTE: " + mPokeon.getmSlot());

        }
    }

}
