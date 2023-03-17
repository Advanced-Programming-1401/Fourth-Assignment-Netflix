package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.*;

class User {
    /*
    * The user should contain username password.
    * The user should contain an ArrayList of favorite shows and watch history.
    * FUNCTION: the user should have a function to watch a show and add it to watch history.
    *  *** NOTE: All search functions in user are for searching in favorite shows ***
    */

    private String username;
    private String password;
    public ArrayList<TVShow> favoriteShows = new ArrayList<TVShow>();
    private ArrayList<TVShow> watchHistory = new ArrayList<TVShow>();
    private ArrayList<TVShow> watchLater = new ArrayList<TVShow>();


    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<TVShow> getFavoriteShows() {
        return favoriteShows;
    }
    public void setFavoriteShows(ArrayList<TVShow> favoriteShows) {
        this.favoriteShows = favoriteShows;
    }

    public ArrayList<TVShow> getWatchHistory() {
        return watchHistory;
    }
    public void setWatchHistory(ArrayList<TVShow> watchHistory) {
        this.watchHistory = watchHistory;
    }

    public ArrayList<TVShow> getWatchLater() {
        return watchLater;
    }
    public void setWatchLater(ArrayList<TVShow> watchLater) {
        this.watchLater = watchLater;
    }


    public ArrayList<TVShow> searchByTitle(String title) {
        // Implement search by title in favorite shows  logic here
        ArrayList<TVShow> searchByTitleList = new ArrayList<TVShow>();

        for (TVShow tvShow : this.favoriteShows) {
            if (tvShow.getTitle().contains(title)) {
                searchByTitleList.add(tvShow);
            }
        }

        return searchByTitleList;
    }


    public ArrayList<TVShow> searchByGenre(String genre) {
        // Implement search by genre in favorite shows  logic here
        ArrayList<TVShow> searchByGenreList = new ArrayList<TVShow>();

        for (TVShow tvShow : this.favoriteShows) {
            if (tvShow.getGenre().contains(genre)) {
                searchByGenreList.add(tvShow);
            }
        }

        return searchByGenreList;
    }


    public ArrayList<TVShow> searchByReleaseYear(int year) {
        // Implement search by release year in favorite shows logic here
        ArrayList<TVShow> searchByReleaseYearList = new ArrayList<TVShow>();

        for (TVShow tvShow : this.favoriteShows) {
            if (tvShow.getReleaseYear() == year) {
                searchByReleaseYearList.add(tvShow);
            }
        }

        return searchByReleaseYearList;
    }


    public void addToFavorites(TVShow show) {
        // Implement add to favorites logic here
        if (!this.getFavoriteShows().contains(show)) {
            this.favoriteShows.add(show);
            JOptionPane.showMessageDialog(null, "The show \"" + show.getTitle() + "\" added to your Favorites successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "The show \"" + show.getTitle() + "\" already exists.");
        }
    }

    
    public ArrayList<TVShow> viewFavorites() {
        // Implement view favorites logic here
        if (this.favoriteShows.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nothing has been added to your Favorites.");
            return null;
        } else {
            JOptionPane.showMessageDialog(null, "Your favorites: \n" + this.favoriteShows.toString());
            return this.favoriteShows;
        }
    }

    public ArrayList<TVShow> sortByRatings(ArrayList<TVShow> arrayList) {
        arrayList.sort(Comparator.comparing(TVShow::getRating));
        return arrayList;
    }

    public ArrayList<TVShow> reverseAnArrayList(ArrayList<TVShow> arrayList) {
        Collections.reverse(arrayList);
        return arrayList;
    }
    
    public ArrayList<TVShow> getRecommendations(ArrayList<TVShow> tvShows) {
        // Implement get recommendations logic here
        ArrayList<TVShow> recommendationsList = new ArrayList<>();
        int limit = 5;
        if (tvShows.size() > limit) {
            switch (this.favoriteShows.size()) {
                case 0:
                    limit += 3;
                    break;
                case 1:
                    recommendationsList.add(this.favoriteShows.get(0));
                    limit += 2;
                    break;
                case 2:
                    recommendationsList.add(this.favoriteShows.get(0));
                    recommendationsList.add(this.favoriteShows.get(1));
                    limit += 1;
                    break;
                default:
                    recommendationsList.add(this.favoriteShows.get(0));
                    recommendationsList.add(this.favoriteShows.get(1));
                    recommendationsList.add(this.favoriteShows.get(2));
                    break;
            }
            if (!watchHistory.isEmpty()) 
                recommendationsList.add(watchHistory.get(watchHistory.size()-1));
            else limit++;

            if (!watchLater.isEmpty())
                recommendationsList.add(watchLater.get(watchLater.size()-1));
            else limit++;

            for (int i = 0; i < limit; i++) {
                recommendationsList.add(reverseAnArrayList(sortByRatings(tvShows)).get(i));
            }
            return recommendationsList;
        } else {
            return reverseAnArrayList(sortByRatings(tvShows));
        }

    }

    public void watchAShow(TVShow show) {
        watchHistory.add(show);
    }

    public void addToWatchLater(TVShow show) {
        if (!watchLater.contains(show)) {
            watchLater.add(show);
            JOptionPane.showMessageDialog(null, "The show \"" + show.getTitle() + "\" added to Watch Later!");
        } else {
            JOptionPane.showMessageDialog(null, "The show \"" + show.getTitle() + "\" already exists in Watch Later.");
        }

    }

}

