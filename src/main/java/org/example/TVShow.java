package org.example;

import java.util.ArrayList;

class TVShow {
    /*
    *The TVShow should have a title , genre, release year, duration and a rating.
     *The TVShow should have an ArrayList of the cast.
     */
    private static String title;
    private static String genre;
    private static int releaseYear;
    private int duration;
    private double rating;

    private ArrayList<String> cast;

    public TVShow(String title, String genre, int releaseYear, int duration, double rating, ArrayList<String> cast){
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.rating = rating;
        this.cast = cast;
    }

    public static String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public static int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ArrayList<String> getCast() {
        return cast;
    }
    public ArrayList<String> setCast(){
        this.cast = cast;
        return cast;
    }


    @Override
    public String toString() {
        return "TVShow{" +
                "title = " + title +
                ", genre = " + genre +
                ", release year = " + releaseYear +
                ", duration = " + duration +
                ", rating = " + rating +
                ", cast = " + cast +
                '}';
    }

}
