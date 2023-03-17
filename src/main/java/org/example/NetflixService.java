package org.example;

import java.util.ArrayList;

class NetflixService {
    /*
     *The NetflixService should have an Arraylist of users, tv shows and movies.
     *The NetflixService should have a User object which represents current user.
     */
    ArrayList<User> userList;
    ArrayList<TVShow> tvShowList;
    ArrayList<Movie> movieList;
    private User user;

    public NetflixService(){
        this.userList = new ArrayList<>();
        this.tvShowList = new ArrayList<>();
        this.movieList= new ArrayList<>();
    }

    public void addUser(User user) {
        userList.add(user);
    }


    public void addTVShow(TVShow tvShow){
        // Implement add tv show logic here
        tvShowList.add(tvShow);
    }

    public void addMovie(Movie movie){
        // Implement add movie logic here
        movieList.add(movie);
    }

    public void createAccount(String username, String password) {
        // Implement create account logic here
        User user = new User(username, password);
        addUser(user);
    }

    public boolean login(String username, String password) {
        // Implement login logic here
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                this.user = user;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        // Implement logout logic here
        user = null;
    }

    public ArrayList<TVShow> searchByTitle(String title) {
        // Implement search by title logic here
        ArrayList<TVShow> result = new ArrayList<>();
        for (TVShow tvShow : tvShowList) {
            if (tvShow.getTitle().equals(title)) {
                result.add(tvShow);
            }
        }
        return result;
    }

    public ArrayList<TVShow> searchByGenre(String genre) {
        // Implement search by genre logic here
        ArrayList<TVShow> result = new ArrayList<>();
        for (TVShow tvShow : tvShowList) {
            if (tvShow.getGenre().equals(genre)) {
                result.add(tvShow);
            }
        }
        return result;
    }

    public ArrayList<TVShow> searchByReleaseYear(int year) {
        // Implement search by release year logic here
        ArrayList<TVShow> result = new ArrayList<>();
        for (TVShow tvShow : tvShowList) {
            if (tvShow.getReleaseYear() == year) {
                result.add(tvShow);
            }
        }
        return result;
    }
    public ArrayList<Movie> searchMoviesByLength(ArrayList length) {
        ArrayList<Movie> result = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getLength() == length) {
                result.add(movie);
            }
        }
        return result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

