package org.example;

import java.util.ArrayList;

class TVShow {
    private String title;
    private String genre;
    private int releaseYear;
    private float rating;
    private ArrayList<String> cast = new ArrayList<>();

    //Constructor
    public TVShow(String title, String genre, int releaseYear, float rating, ArrayList<String> cast) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.cast = cast;
    }

    //Getter and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }

    @Override
    public String toString() {
        return "TVShow{Title: " + this.title + ", " +
                "Genre: " + this.genre + ", " +
                "Release Year: " + this.releaseYear + ", " +
                "Rating: " + this.rating + "}";
    }
}
