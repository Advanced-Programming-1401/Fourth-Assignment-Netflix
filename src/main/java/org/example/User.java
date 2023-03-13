package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

class User implements searchAndShow{
    private String userName;
    private String passWord;
    private ArrayList<TVShow> favorites;
    private ArrayList<TVShow> watchHistory;
    private HashMap<TVShow, USEROPINION> likedTvShow;

    //Constructor
    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        this.favorites = new ArrayList<>();
        this.watchHistory = new ArrayList<>();
        this.likedTvShow = new HashMap<>();
    }

    //Getter and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public ArrayList<TVShow> getFavorites() {
        return favorites;
    }

    public void setFavorites(ArrayList<TVShow> favorites) {
        this.favorites = favorites;
    }

    public ArrayList<TVShow> getWatchHistory() {
        return watchHistory;
    }

    public void setWatchHistory(ArrayList<TVShow> watchHistory) {
        this.watchHistory = watchHistory;
    }

    public HashMap<TVShow, USEROPINION> getLikedTvShow() {
        return likedTvShow;
    }

    public ArrayList<TVShow> searchByTitle(String title) {
        ArrayList<TVShow> list = new ArrayList<>();

        for (TVShow tvShow : getFavorites()) {
            if (tvShow.getTitle().equalsIgnoreCase(title)) {
                list.add(tvShow);
            }
        }
        if (list.size() != 0) {
            return list;
        }
        return null;
    }

    public ArrayList<TVShow> searchByGenre(String genre) {
        ArrayList<TVShow> list = new ArrayList<>();

        for (TVShow tvShow : getFavorites()) {
            if (tvShow.getGenre().equalsIgnoreCase(genre)) {
                list.add(tvShow);
            }
        }
        if (list.size() != 0) {
            return list;
        }
        return null;
    }

    public ArrayList<TVShow> searchByReleaseYear(int year) {
        ArrayList<TVShow> list = new ArrayList<>();

        for (TVShow tvShow : getFavorites()) {
            if (tvShow.getReleaseYear() == year) {
                list.add(tvShow);
            }
        }
        if (list.size() != 0) {
            return list;
        }
        return null;
    }

    @Override
    public void showList(ArrayList<TVShow> list) {
        if (list != null) {
            for (TVShow tvShow : list) {
                System.out.println(tvShow.toString());
            }
        } else {
            System.out.println("NOTHING FOUND TO SHOW");
        }
        System.out.println();
    }
    public void showList(HashMap<TVShow, USEROPINION> likedTvShow){
        if (likedTvShow.size() == 0){
            System.out.println("NOTHING FOUND TO SHOW");
        }
        else {
            System.out.println("A LIST OF LIKED AND DISLIKED TV-SHOWS");
            for (TVShow tvShow : likedTvShow.keySet()){
                System.out.println(tvShow.getTitle() + " IS " + likedTvShow.get(tvShow));
            }
        }
        System.out.println();
    }

    public void addToFavorites(TVShow show) {
        this.favorites.add(show);
        System.out.println(show.getTitle() + " HAS BEEN SUCCESSFULLY ADDED TO YOUR FAVORITES\n");
    }

    public void viewFavorites() {
        if (this.favorites.size() != 0) {
            System.out.println("A list of favorite shows:\n");
            for (TVShow tvShow : this.favorites) {
                System.out.println("Title: " + tvShow.getTitle() + ", Genre: " + tvShow.getGenre() + ", Release Year: " + tvShow.getReleaseYear() + ", Rating: " + tvShow.getRating());
            }
        } else {
            System.out.println("You have no favorite Tv show");
        }
    }

    public ArrayList<TVShow> getRecommendations() {
        if (this.favorites.size() != 0) {
            for (int i = 0; i < this.favorites.size(); i++) {
                for (int j = 0; j < this.favorites.size(); j++) {

                    if (this.favorites.get(j).getRating() > this.favorites.get(i).getRating()) {
                        //sorting array
                        Collections.swap(this.favorites, j, i);
                    }
                }
            }

            ArrayList<TVShow> list = new ArrayList<>();
            //best three movies
            switch (this.favorites.size()) {
                case 1 -> {
                    //RETURNS LIST ONLY WITH ONE TV-SHOW
                    list.add(this.favorites.get(0));
                }
                case 2 -> {
                    //RETURN LIST ALONG WITH FIRST AND SECOND TV-SHOW
                    list.add(this.favorites.get(0));
                    list.add(this.favorites.get(1));
                }
                case 3 -> {
                    //RETURN LIST ALONG WITH FIRST AND SECOND TV-SHOW
                    list.add(this.favorites.get(0));
                    list.add(this.favorites.get(1));
                    list.add(this.favorites.get(2));
                }
            }
            return list;
        }
        return null;
    }

    @Override
    public boolean doesTVShowExist(String title) {
        for (TVShow tvShow : this.favorites) {
            if (tvShow.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }
    public void likeTvShow (TVShow tvShow){
        this.likedTvShow.putIfAbsent(tvShow, USEROPINION.INDIFFERENT);

        if (this.likedTvShow.get(tvShow) == USEROPINION.LIKED){
            System.out.println("YOU HAVE ALREADY LIKED THIS TV-SHOW, YOU CANNOT DO IT AGAIN\n");
        }
        else {
            this.likedTvShow.replace(tvShow, USEROPINION.LIKED);
            System.out.println("YOU HAVE LIKED " + tvShow.getTitle() + "\n");
        }
    }
    public void dislikeTvShow (TVShow tvShow){
        this.likedTvShow.putIfAbsent(tvShow, USEROPINION.INDIFFERENT);

        if (this.likedTvShow.get(tvShow) == USEROPINION.DISLIKED){
            System.out.println("YOU HAVE ALREADY DISLIKED THIS TV-SHOW, YOU CANNOT DO IT AGAIN\n");
        }
        else {
            this.likedTvShow.replace(tvShow, USEROPINION.DISLIKED);
            System.out.println("YOU HAVE DISLIKED " + tvShow.getTitle() + "\n");
        }
    }
}
