package org.example;

import java.util.ArrayList;

class TVShow {
    private String title;
    private String genre;
    private int releaseYear;
    private int duration;
    private double rating;
    private ArrayList<String> castMember;
    /*
    *The TVShow should have a title , genre, release year, duration and a rating.
     *The TVShow should have an ArrayList of the cast.
     */
    public TVShow(String title,String genre,int releaseYear,int duration,double rating,ArrayList<String> castMember){
        this.title=title;
        this.genre=genre;
        this.releaseyear=releaseYear;
        this.duration=duration;
        this.durationMinute=durationMinute;
        this.rating=rating;
        this.castMember=castMember;
    }
    public String getTitle(){
        return title;
    }
    public String getGenre(){
        return genre;
    }
    public int getreleaseYear(){
        return releaseYear;
    }
    public int getDurationMinute(){
        return durationMinute;
    }
    public double getRating(){
        return rating;
    }
    public ArrayList<String> getCastMember(){
        return castMember;
    }
    public void addCastMember(String name){
        castMember.add(name);
    }
}
