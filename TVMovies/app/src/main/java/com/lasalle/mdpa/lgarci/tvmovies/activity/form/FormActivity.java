package com.lasalle.mdpa.lgarci.tvmovies.activity.form;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lasalle.mdpa.lgarci.tvmovies.R;
import com.lasalle.mdpa.lgarci.tvmovies.adapter.OnMovieListener;
import com.lasalle.mdpa.lgarci.tvmovies.adapter.OnTVShowListener;
import com.lasalle.mdpa.lgarci.tvmovies.adapter.TabLayoutAdapter;
import com.lasalle.mdpa.lgarci.tvmovies.model.Movie;
import com.lasalle.mdpa.lgarci.tvmovies.model.TVShow;


import java.util.ArrayList;


/**
 * Created by FurruPi on 2/2/17.
 */

public class FormActivity  extends AppCompatActivity implements OnTVShowListener, OnMovieListener {

    public static final String TV_SHOW_TITLE = "TV Show";
    public static final String MOVIE_TITLE = "Movie";

    private ArrayList<Movie> movies;
    private ArrayList<TVShow> shows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        movies = new ArrayList<>();
        shows = new ArrayList<>();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.activity_tab_layout_container);
        ViewPager viewPager = (ViewPager) findViewById(R.id.activity_tab_layout_view_pager);

        viewPager.setAdapter(new TabLayoutAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onMovieAdded(Movie movie) {
        movies.add(movie);
    }

    @Override
    public void onTVShowAdded(TVShow tvShow) {
        shows.add(tvShow);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent();
        intent.putExtra(TV_SHOW_TITLE, shows);
        intent.putExtra(MOVIE_TITLE, movies);
        setResult(RESULT_OK, intent);
        finish();
    }

    /**
     * Created by FurruPi on 2/2/17.
     */

    public static class MovieFormFragment extends Fragment {

        private TextInputEditText nameEditText, directorEditText, yearEditText;
        private Button button;
        private OnMovieListener listener;

        @Override
        public void onAttach(Context context) {
            listener = (OnMovieListener) getActivity();
            super.onAttach(context);
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View fragmentLayoutView = inflater.inflate(R.layout.fragment_tvform, container, false);
            button = (Button) fragmentLayoutView.findViewById(R.id.button);
            nameEditText = (TextInputEditText) fragmentLayoutView.findViewById(R.id.editText_name);
            directorEditText = (TextInputEditText) fragmentLayoutView.findViewById(R.id.editText_seasons);
            yearEditText = (TextInputEditText) fragmentLayoutView.findViewById(R.id.editText_year);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = nameEditText.getText().toString();
                    String director = directorEditText.getText().toString();
                    String year = yearEditText.getText().toString();
                    listener.onMovieAdded(new Movie(name, director, year));
                }
            });

            return fragmentLayoutView;

        }
    }
}
