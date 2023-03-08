package org.example;

import java.util.ArrayList;

class User {
    private String username;
    private String password;
    private ArrayList<TVShow> favorites;
    private ArrayList<TVShow> viewingHistory;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.favorites = new ArrayList<TVShow>();
        this.viewingHistory = new ArrayList<TVShow>();
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
    public void addToFavorites(TVShow show) {
        // Implement add to favorites logic here
    }
    public void viewFavorites() {
        // Implement view favorites logic here
    }
    public ArrayList<TVShow> getRecommendations() {
        // Implement get recommendations logic here
        return null;
    }
}
