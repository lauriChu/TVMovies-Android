package com.lasalle.mdpa.lgarci.tvmovies.activity.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.lasalle.mdpa.lgarci.tvmovies.R;
import com.lasalle.mdpa.lgarci.tvmovies.activity.form.FormActivity;
import com.lasalle.mdpa.lgarci.tvmovies.activity.list.fragment.MovieListFragment;
import com.lasalle.mdpa.lgarci.tvmovies.activity.list.fragment.TVShowListFragment;
import com.lasalle.mdpa.lgarci.tvmovies.model.Movie;
import com.lasalle.mdpa.lgarci.tvmovies.model.TVShow;

import java.util.ArrayList;

/**
 * Created by FurruPi on 2/2/17.
 */

public class ListActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_list);
        super.onCreate(savedInstanceState);
        final ArrayList<TVShow> shows = (ArrayList<TVShow>) getIntent().getExtras().get(FormActivity.TV_SHOW_TITLE);
        final ArrayList<Movie> movies = (ArrayList<Movie>) getIntent().getExtras().get(FormActivity.MOVIE_TITLE);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_search:
                        MovieListFragment movieListFragment = new MovieListFragment();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(FormActivity.MOVIE_TITLE, movies);
                        movieListFragment.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, movieListFragment).commit();
                        break;
                    case R.id.action_settings:
                        TVShowListFragment tvShowListFragment = new TVShowListFragment();
                        Bundle bundle2 = new Bundle();
                        bundle2.putSerializable(FormActivity.TV_SHOW_TITLE, shows);
                        tvShowListFragment.setArguments(bundle2);
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, tvShowListFragment).commit();
                        break;
                }
                return true;
            }
        });
    }
}
