package com.lasalle.mdpa.lgarci.tvmovies.activity.manager;

import com.lasalle.mdpa.lgarci.tvmovies.model.Movie;
import com.lasalle.mdpa.lgarci.tvmovies.model.TVShow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FurruPi on 2/2/17.
 */

public class Manager {

    private List<Movie> movies;
    private List<TVShow> shows;

    public Manager(ArrayList<Movie> movies, ArrayList<TVShow> shows) {
        this.movies = movies;
        this.shows = shows;
    }

    public int getItemCountMovies(){
        return movies.size();
    }

    public int getItemCountShows(){
        return shows.size();
    }

    public void addMovies(Movie movie){
        movies.add(movie);
    }

    public Movie getMovieAtPosition(int position){
        return movies.get(position);
    }

    public void addShows(TVShow tvShow){
        shows.add(tvShow);
    }

    public TVShow getShowAtPosition(int position){
        return shows.get(position);
    }


}
