package org.example;

import java.util.ArrayList;

class Movie extends TVShow {
    private int length;

    public Movie(String title, String genre, int year, int duration, float rating, ArrayList<String> cast, int length)
    {
        super(title, genre, year, duration, rating, cast);
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
