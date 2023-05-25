package org.example;

import java.util.ArrayList;

class Movie extends TVShow {
    private int length;

    public Movie(String title, String genre, int releaseYear, int durationMinute, double rating, ArrayList<String> castMember, int lengthMinute) {
        super(title, genre, releaseYear, durationMinute, rating, castMember);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}