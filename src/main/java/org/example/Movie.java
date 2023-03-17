package org.example;

import java.util.ArrayList;

class Movie extends TVShow {
    /*
     *Movie is extended from TVShow and has extra attribute length.
     */

    private int length; // extra attribute


    public Movie() {
        super();
    }

    public Movie(String title, String genre, int releaseYear, int duration, double rating, ArrayList<String> cast, int length) {
        super(title, genre, releaseYear, duration, rating, cast);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return super.toString() + "The Length: " + this.length;
    }
}
