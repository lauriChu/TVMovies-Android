package com.lasalle.mdpa.lgarci.tvmovies.model;

import java.io.Serializable;

/**
 * Created by FurruPi on 2/2/17.
 */

public class TVShow implements Serializable{

    private String name;
    private String numSeasons;
    private String realeaseYear;

    public TVShow(String name, String numSeasons, String realeaseYear) {
        this.name = name;
        this.numSeasons = numSeasons;
        this.realeaseYear = realeaseYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumSeasons() {
        return numSeasons;
    }

    public void setNumSeasons(String numSeasons) {
        this.numSeasons = numSeasons;
    }

    public String getRealeaseYear() {
        return realeaseYear;
    }

    public void setRealeaseYear(String realeaseYear) {
        this.realeaseYear = realeaseYear;
    }
}
