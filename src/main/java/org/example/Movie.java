package org.example;

import java.util.ArrayList;

class Movie extends TVShow {
    private double length;

    //Constructor
    public Movie(double length, String title, String genre, int releaseYear, float rating, ArrayList<String> cast) {
        super(title, genre, releaseYear, rating, cast);
        this.length = length;
    }

    //Getter and Setters
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Movie{Title: " + getTitle() + ", " +
                "Genre: " + getGenre() + ", " +
                "Release Year: " + getReleaseYear() + ", " +
                "Rating: " + getRating() + ", " +
                "Movie Length: " + getLength() + "}";
    }
}
