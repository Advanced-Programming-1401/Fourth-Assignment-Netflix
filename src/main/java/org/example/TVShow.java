package org.example;

import java.util.ArrayList;

class TVShow {
    /*
    *The TVShow should have a title , genre, release year, duration and a rating.
     *The TVShow should have an ArrayList of the cast.
     */
    private String title;
    private String genre;
    private int releaseYear;
    private int duration;
    private double rating;
    private ArrayList<String> cast;

    TVShow(String title, String genre, int releaseYear, int duration, double rating, ArrayList<String> cast){
        this.cast = cast;
        this.duration = duration;
        this.rating = rating;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.title = title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setDurationMinute(int duration) {
        this.duration = duration;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
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

    public double getRating() {
        return rating;
    }

    public ArrayList<String> getCast() {
        return cast;
    }
    public void addCast(String name){
        cast.add(name);
    }
}
