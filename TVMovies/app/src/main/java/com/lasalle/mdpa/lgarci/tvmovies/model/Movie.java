package com.lasalle.mdpa.lgarci.tvmovies.model;

import java.io.Serializable;

/**
 * Created by FurruPi on 2/2/17.
 */

public class Movie implements Serializable {

    private String name;
    private String director;
    private String year;

    public Movie(String name, String director, String year) {
        this.name = name;
        this.director = director;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
