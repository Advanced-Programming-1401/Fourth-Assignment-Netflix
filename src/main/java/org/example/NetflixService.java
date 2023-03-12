package org.example;

import java.util.ArrayList;

class NetflixService {
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<TVShow> tvShows = new ArrayList<>();
    private User currentUser;

    //Constructors
    public NetflixService(User currentUser) {
        this.currentUser = currentUser;
    }

    //Getters and Setters
    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        NetflixService.users = users;
    }

    public static ArrayList<TVShow> getTvShows() {
        return tvShows;
    }

    public static void setTvShows(ArrayList<TVShow> tvShows) {
        NetflixService.tvShows = tvShows;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    //Service - Related Functions
    public void addTVShow(TVShow tvShow) {
        // Implement add tv show logic here
    }

    public void addMovie(Movie movie) {
        // Implement add movie logic here
    }

    public static boolean isUserExist(String username) {
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static void createAccount(String username, String password) {
        if (!isUserExist(username)) {
            User newUser = new User(username, password);
        } else {
            System.out.println("This user already exists");
        }
    }

    public static boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUserName().equals(username) && user.getPassWord().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void logout() {
        this.currentUser = null;
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

