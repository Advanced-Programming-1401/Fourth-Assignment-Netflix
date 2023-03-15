package org.example;

import java.util.ArrayList;

class TVShow {
    private String title;
    private String genre;
    // Release year
    private int year;
    // In minutes
    private int duration;
    // Rate out of 10
    private float rating;

    private ArrayList<String> cast;

    public TVShow(String title, String genre, int year, int duration, float rating, ArrayList<String> cast) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.duration = duration;
        this.rating = rating;
        this.cast = cast;
    }

    public String getTitle() {
        return this.title;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getYear() {
        return this.year;
    }

    public int getDuration() {
        return this.duration;
    }

    public float getRating() {
        return this.rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
