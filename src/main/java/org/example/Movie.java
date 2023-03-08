package org.example;

import java.util.ArrayList;

class Movie extends TVShow {
    private int length;
    public Movie(String title, String genre, int releaseYear, int length, ArrayList<String> cast, double rating)
    {
        super(title, genre, releaseYear, 0, cast, rating);
        this.length = length;
    }
    public int getLength() {
        return length;
    }
}
