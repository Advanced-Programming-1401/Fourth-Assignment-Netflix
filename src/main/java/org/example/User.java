package org.example;

import java.util.ArrayList;

class User {
    /*
    * The user should contain username password.
    * The user should contain an ArrayList of favorite shows and watch history.
    * FUNCTION: the user should have a function to watch a show and add it to watch history.
    *  *** NOTE: All search functions in user are for searching in favorite shows ***
    */
    private String username;
    private String password;

    private ArrayList<TVShow> favoriteShows;
    private ArrayList<TVShow> history;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.favoriteShows = new ArrayList<TVShow>();
        this.history = new ArrayList<TVShow>();
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public ArrayList<TVShow> getFavorites() {
        return this.favoriteShows;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFavorites(ArrayList<TVShow> shows) {
        this.favoriteShows = shows;
    }

    public ArrayList<TVShow> searchByTitle(String title) {
        ArrayList<TVShow> resultedShows = new ArrayList<TVShow>();
        for(TVShow show : favoriteShows) {
            if(show.getTitle().contains(title)) {
                resultedShows.add(show);
            }
        }

        if(resultedShows.size() == 0) {
            return null;
        } else {
            return resultedShows;
        }
    }

    public ArrayList<TVShow> searchByGenre(String genre) {
        ArrayList<TVShow> resultedShows = new ArrayList<TVShow>();
        for(TVShow show : favoriteShows) {
            if(show.getGenre().equals(genre)) {
                resultedShows.add(show);
            }
        }

        if(resultedShows.size() == 0) {
            return null;
        } else {
            return resultedShows;
        }
    }

    public ArrayList<TVShow> searchByReleaseYear(int year) {
        ArrayList<TVShow> resultedShows = new ArrayList<TVShow>();
        for(TVShow show : favoriteShows) {
            if(show.getYear() == year) {
                resultedShows.add(show);
            }
        }

        if(resultedShows.size() == 0) {
            return null;
        } else {
            return resultedShows;
        }
    }

    public void watch(TVShow show) {
        history.add(show);
    } 

    public void addToFavorites(TVShow show) {
        favoriteShows.add(show);
    }

    public void viewFavorites() {
        int index = 1;
        for(TVShow show : favoriteShows) {
            System.out.println(index + ":");
            System.out.println("Title: " + show.getTitle());
            System.out.println("Genre: " + show.getGenre());
            System.out.println("Release year: " + show.getYear());
            System.out.println("---------------------------------------------------");
            index++;
        }
    }

    public ArrayList<TVShow> getRecommendations() {
        // Implement get recommendations logic here
        return null;
    }
}
