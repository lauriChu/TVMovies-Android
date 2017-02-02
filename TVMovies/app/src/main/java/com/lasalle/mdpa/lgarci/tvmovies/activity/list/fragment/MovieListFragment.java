package com.lasalle.mdpa.lgarci.tvmovies.activity.list.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lasalle.mdpa.lgarci.tvmovies.R;
import com.lasalle.mdpa.lgarci.tvmovies.activity.form.FormActivity;
import com.lasalle.mdpa.lgarci.tvmovies.activity.manager.Manager;
import com.lasalle.mdpa.lgarci.tvmovies.adapter.recycler.RecyclerAdapter;
import com.lasalle.mdpa.lgarci.tvmovies.model.Movie;

import java.util.ArrayList;

/**
 * Created by FurruPi on 2/2/17.
 */

public class MovieListFragment extends Fragment {

    ArrayList<Movie> movies;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        movies = (ArrayList<Movie>) getArguments().get(FormActivity.MOVIE_TITLE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentLayoutView = inflater.inflate(R.layout.fragment_movie_list, container, false);
        RecyclerView recyclerView = (RecyclerView) fragmentLayoutView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new RecyclerAdapter(getActivity(), false, new Manager(movies, null)));
        return fragmentLayoutView;
    }
}
