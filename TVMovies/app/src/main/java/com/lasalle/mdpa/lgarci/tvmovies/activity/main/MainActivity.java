package com.lasalle.mdpa.lgarci.tvmovies.activity.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lasalle.mdpa.lgarci.tvmovies.R;
import com.lasalle.mdpa.lgarci.tvmovies.activity.form.FormActivity;
import com.lasalle.mdpa.lgarci.tvmovies.activity.list.ListActivity;
import com.lasalle.mdpa.lgarci.tvmovies.model.Movie;
import com.lasalle.mdpa.lgarci.tvmovies.model.TVShow;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button addButton, listButton;

    private ArrayList<Movie> movies;
    private ArrayList<TVShow> shows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = (Button) findViewById(R.id.button_add);
        listButton = (Button) findViewById(R.id.button_list);

        movies = new ArrayList<>();
        shows = new ArrayList<>();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FormActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                intent.putExtra(FormActivity.MOVIE_TITLE, movies);
                intent.putExtra(FormActivity.TV_SHOW_TITLE, shows);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == -1){
            ArrayList<Movie> movies = (ArrayList<Movie>) data.getExtras().get(FormActivity.MOVIE_TITLE);
            this.movies.addAll(movies);
            ArrayList<TVShow> shows = (ArrayList<TVShow>) data.getExtras().get(FormActivity.TV_SHOW_TITLE);
            this.shows.addAll(shows);
        }
    }
}

