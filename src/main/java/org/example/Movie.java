package org.example;

import java.util.ArrayList;

class Movie extends TVShow {
    private int lengthMinute;
    /*
     *Movie is extended from TVShow and has extra attribute length.
     */
    public Movie(String title,String genre, int releaseYear, int durationMinate,double rating ,ArrayList<String> castMember,int lengthMinute)
    {

        super(title,genre,releaseYear,durationMinate,rating,castMember);
        this.lengthMinute=lengthMinute;
    }
    public int getLengthMinute(){
        return lengthMinute;
    }
}
