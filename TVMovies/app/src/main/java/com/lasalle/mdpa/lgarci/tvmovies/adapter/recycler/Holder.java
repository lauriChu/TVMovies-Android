package com.lasalle.mdpa.lgarci.tvmovies.adapter.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lasalle.mdpa.lgarci.tvmovies.R;
import com.lasalle.mdpa.lgarci.tvmovies.model.Movie;
import com.lasalle.mdpa.lgarci.tvmovies.model.TVShow;

/**
 * Created by FurruPi on 2/2/17.
 */

public class Holder extends RecyclerView.ViewHolder {

    private TextView mName;
    private TextView mSecond;
    private TextView mThird;

    public Holder(View itemView) {
        super(itemView);
        mName = (TextView) itemView.findViewById(
                R.id.textView_name);
        mSecond = (TextView) itemView.findViewById(
                R.id.textView_director);
        mThird = (TextView) itemView.findViewById(
                R.id.textView_year);
    }

    public void setItemTextMovie(Movie movie) {
        mName.setText(movie.getName());
        mSecond.setText(movie.getDirector());
        mThird.setText(movie.getYear());
    }

    public void setItemTextShow(TVShow show) {
        mName.setText(show.getName());
        mSecond.setText(show.getNumSeasons());
        mThird.setText(show.getRealeaseYear());
    }
}