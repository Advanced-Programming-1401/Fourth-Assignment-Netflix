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
    private ArrayList<String> cast = new ArrayList<String>();

    public TVShow() {

    }

    public TVShow(String title, String genre, int releaseYear, int duration, double rating, ArrayList<String> cast) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.rating = rating;
        this.cast = cast;
    }


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
    
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    public ArrayList<String> getCast() {
        return cast;
    }
    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }

    public String printCast() {
        String castString = "";
        for (int i = 0; i < this.cast.size(); i++) {
            castString += "* " + this.cast.get(i) + "\n";
        }
        return castString;
    }

    @Override
    public String toString() {
        return "\nHere is the information of the TV Show " + this.title + ":\nThe Title: " + this.title + "\nThe Genre: " + this.genre + "\nThe Release Year: " + this.releaseYear + "\nThe Duration: " + this.duration + "\nThe Rating: " + this.rating + "\nThe Cast:\n" + printCast();
    }

}
