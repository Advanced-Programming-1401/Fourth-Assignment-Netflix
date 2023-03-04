package org.example;

import java.util.ArrayList;

class NetflixService {
    private ArrayList<User> users;
    private ArrayList<TVShow> tvShows;
    private ArrayList<Movie> movies;
    private User currentUser;

    public NetflixService() {
        this.users = new ArrayList<User>();
        this.tvShows = new ArrayList<TVShow>();
        this.movies = new ArrayList<Movie>();
    }

    public void createAccount(String username, String password) {
        // Implement create account logic here
    }

    public boolean login(String username, String password) {
        // Implement login logic here
        return false;
    }

    public void logout() {
        // Implement logout logic here
    }

    public ArrayList<TVShow> searchByTitle(String title) {
        // Implement search by title logic here
        return null;
    }

    public ArrayList<TVShow> searchByGenre(String genre) {
        // Implement search by genre logic here
        return null;
    }

    public ArrayList<TVShow> searchByReleaseYear(int year) {
        // Implement search by release year logic here
        return null;
    }


}

