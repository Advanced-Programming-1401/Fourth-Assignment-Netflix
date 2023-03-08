package org.example;

import java.util.ArrayList;

class TVShow {
    private String title;
    private String genre;
    private int releaseYear;
    private int duration;
    private ArrayList<String> cast;
    private double rating;
    public TVShow(String title, String genre, int releaseYear, int duration, ArrayList<String> cast, double
            rating) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.cast = cast;
        this.rating = rating;
    }
    public String getTitle() {
        return title;
    }
    public String getGenre() {
        return genre;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public int getDuration() {
        return duration;
    }
    public ArrayList<String> getCast() {
        return cast;
    }
    public double getRating() {
        return rating;
    }
}
