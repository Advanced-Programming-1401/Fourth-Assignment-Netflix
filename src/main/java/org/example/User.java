package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class User {
    private String userName;
    private String passWord;
    private ArrayList<TVShow> favorites;
    private ArrayList<TVShow> watchHistory;

    //Constructor
    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        this.favorites = new ArrayList<>();
        this.watchHistory = new ArrayList<>();
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

    public ArrayList<TVShow> searchByTitle(String title) {
        ArrayList<TVShow> list = new ArrayList<>();

        for (TVShow tvShow : getFavorites()) {
            if (tvShow.getTitle().equals(title)) {
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
            if (tvShow.getGenre().equals(genre)) {
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

    public void addToFavorites(TVShow show) {
        this.favorites.add(show);
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
                        Collections.swap(this.favorites, j, i);
                    }
                }
            }

            ArrayList<TVShow> list = new ArrayList<>();
            //best three movies
            list.add(this.favorites.get(0));
            list.add(this.favorites.get(1));
            list.add(this.favorites.get(2));
            return list;
        }
        return null;
    }
}
