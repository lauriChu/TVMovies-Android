package com.lasalle.mdpa.lgarci.tvmovies.adapter.recycler;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.lasalle.mdpa.lgarci.tvmovies.R;
import com.lasalle.mdpa.lgarci.tvmovies.activity.manager.Manager;
import com.lasalle.mdpa.lgarci.tvmovies.adapter.recycler.Holder;
import com.lasalle.mdpa.lgarci.tvmovies.model.Movie;
import com.lasalle.mdpa.lgarci.tvmovies.model.TVShow;

import java.util.ArrayList;


/**
 * Created by FurruPi on 2/2/17.
 */

public class RecyclerAdapter  extends RecyclerView.Adapter<Holder> {

    private Activity mActivity;
    private Manager mManager;
    private boolean isTVShow;

    public RecyclerAdapter(Activity activity, boolean tvShow, Manager manager)
    {
        mActivity = activity;
        isTVShow = tvShow;
        mManager = manager;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mActivity.getLayoutInflater().inflate(
                R.layout.recycler_item,
                parent,
                false);

        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        if (isTVShow){
            TVShow show = mManager.getShowAtPosition(position);
            holder.setItemTextShow(show);
        }else{
            Movie movie = mManager.getMovieAtPosition(position);
            holder.setItemTextMovie(movie);
        }
    }

    @Override
    public int getItemCount() {
        return isTVShow ? mManager.getItemCountShows() : mManager.getItemCountMovies();
    }

}