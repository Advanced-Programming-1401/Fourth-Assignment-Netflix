package org.example;

import java.util.ArrayList;

class NetflixService {
    private ArrayList<User> users;
    private ArrayList<TVShow> shows;
    private ArrayList<Movie> movies;

    private User currentUser;

    public NetflixService() {
        this.users = new ArrayList<User>();
        this.shows = new ArrayList<TVShow>();
        this.movies = new ArrayList<Movie>();
        this.currentUser = null;
    }

    public User getCurrentUser() {
        return this.currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public void addTVShow(TVShow tvShow){
        shows.add(tvShow);
    }

    public void addMovie(Movie movie){
        shows.add(movie);
    }

    public boolean createAccount(String username, String password) {
        for(User user : users) {
            if(user.getUsername().equals(username)) {
                return false;
            }
        }

        User newUser = new User(username, password);
        users.add(newUser);
        return true;
    }

    public boolean login(String username, String password) {
        for(User user : users) {
            if(user.getUsername().equals(username)) {
                if(user.getPassword().equals(password)) {
                    this.currentUser = user;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void logout() {
        this.currentUser = null;
    }

    public ArrayList<TVShow> searchByTitle(String title) {
        ArrayList<TVShow> resultedShows = new ArrayList<TVShow>();
        for(TVShow show : shows) {
            if(show.getTitle().contains(title)) {
                resultedShows.add(show);
            }
        }

        for(Movie movie : movies) {
            if(movie.getTitle().contains(title)) {
                resultedShows.add(movie);
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
        for(TVShow show : shows) {
            if(show.getGenre().equals(genre)) {
                resultedShows.add(show);
            }
        }

        for(Movie movie : movies) {
            if(movie.getGenre().equals(genre)) {
                resultedShows.add(movie);
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
        for(TVShow show : shows) {
            if(show.getYear() == year) {
                resultedShows.add(show);
            }
        }

        for(Movie movie : movies) {
            if(movie.getYear() == year) {
                resultedShows.add(movie);
            }
        }

        if(resultedShows.size() == 0) {
            return null;
        } else {
            return resultedShows;
        }
    }
}

