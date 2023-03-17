package org.example;

import java.util.ArrayList;
import javax.swing.*;

class NetflixService {
    /*
     *The NetflixService should have an Arraylist of users, tv shows and movies.
     *The NetflixService should have a User object which represents current user.
     */

    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<TVShow> tvShows = new ArrayList<TVShow>();
    private ArrayList<Movie> movies = new ArrayList<Movie>();
    private User user;

    public ArrayList<User> getUsers() {
        return users;
    }
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<TVShow> getTvShows() {
        return tvShows;
    }
    public void setTvShows(ArrayList<TVShow> tvShows) {
        this.tvShows = tvShows;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }
    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public User getUser() {
        return this.user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    
    public void addTVShow(TVShow tvShow){
        // Implement add tv show logic here
        if (!tvShows.contains(tvShow)) {
            tvShows.add(tvShow);
            JOptionPane.showMessageDialog(null, "The TV show \"" + tvShow.getTitle() + "\" has been successfully added.");
        } else {
            JOptionPane.showMessageDialog(null, "The TV show \"" + tvShow.getTitle() + "\" already exists.");
        }
    }

    public void addMovie(Movie movie){
        // Implement add movie logic here
        if (!tvShows.contains(movie)) {
            movies.add(movie);
            JOptionPane.showMessageDialog(null, "The movie \"" + movie.getTitle() + "\" has been successfully added.");
        } else {
            JOptionPane.showMessageDialog(null, "The movie \"" + movie.getTitle() + "\" already exists.");
        }
    }

    public boolean doesUserExist(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) 
                return true;
        }
        return false;
    }

    public void createAccount(String username, String password) {
        // Implement create account logic here
        if (!doesUserExist(username)) {
            User newUser = new User(username,password);
            users.add(newUser);
            JOptionPane.showMessageDialog(null,"Welcome \"" + username + "\"!\nYour account has been created successfully!");
        } else {
            JOptionPane.showMessageDialog(null,"The username \"" + username + "\" already exists.");
        }
    }

    public boolean userIsAuthenticated(String username, String password) {
        if (doesUserExist(username)) {
            for (User user : users) {
                if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password))
                    return true;
            }
        }
        return false;
    }

    public boolean login(String username, String password) {
        // Implement login logic here
        if (doesUserExist(username)) {
            if (userIsAuthenticated(username, password)) {
                this.user = new User(username, password);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "The username & password you entered do not match. Please try again ");
                return false;
            }
        } else {
            JOptionPane.showInputDialog(null, "The username \"" + username + "\" doesn't exist to log in.");
            return false;
        }
    }

    public void logout() {
        // Implement logout logic here
        JOptionPane.showMessageDialog(null, "Goodbye " + user.getUsername() + "!");
        user = null;
    }

    public ArrayList<TVShow> searchByTitle(String title) {
        // Implement search by title logic here
        ArrayList<TVShow> searchByTitleList = new ArrayList<TVShow>();

        for (TVShow tvShow : tvShows) {
            if (tvShow.getTitle().contains(title)) {
                searchByTitleList.add(tvShow);
            }
        }

        return searchByTitleList;
    }

    public ArrayList<TVShow> searchByGenre(String genre) {
        // Implement search by genre logic here
        ArrayList<TVShow> searchByGenreList = new ArrayList<TVShow>();

        for (TVShow tvShow : tvShows) {
            if (tvShow.getGenre().contains(genre)) {
                searchByGenreList.add(tvShow);
            }
        }

        return searchByGenreList;
    }

    public ArrayList<TVShow> searchByReleaseYear(int year) {
        // Implement search by release year logic here
        ArrayList<TVShow> searchByReleaseYearList = new ArrayList<TVShow>();

        for (TVShow tvShow : tvShows) {
            if (tvShow.getReleaseYear() == year) {
                searchByReleaseYearList.add(tvShow);
            }
        }

        return searchByReleaseYearList;
    }


}

