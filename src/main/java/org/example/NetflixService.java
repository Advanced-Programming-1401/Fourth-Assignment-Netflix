package org.example;

import java.util.ArrayList;
import java.util.*;

class NetflixService {
    private ArrayList<Movie> movieList;
    private ArrayList<TVShow> tvShowList;
    private HashMap<String,User> userList;
    private User currentUser;
    public NetflixService(){
        this.movieList= new ArrayList<>();
        this.tvShowList= new ArrayList<>();
        this.userList=new HashMap<>();
        this.currentUser=null;
    }
    public ArrayList<Movie> getMovieList(){
        return movieList;
    }
    public ArrayList<TVShow> getTVShowList(){
        return tvShowList;
    }
    public User getCurrentUser(){
        return currentUser;
    }
    public void addTVShow(TVShow tvShow){
        tvShowList.add(tvShow);
    }

    /*
     *The NetflixService should have an Arraylist of users, tv shows and movies.
     *The NetflixService should have a User object which represents current user.
     */



    public void addMovie(Movie movie){
        movieList.add(movie);
    }

    public User createAccount(String username, String password) {
        if(!userList.containsKey(username)) {
            User user = new User(username , password);
            userList.put(username , user);
            return user;
        }
        return null;
    }

    public boolean login(String username, String password) {
        // Implement login logic here
        if(userList.containsKey(username) && Objects.equals(userList.get(username).getPassword(), password)){
            currentUser = userList.get(username);
            return true;
        }
        else{
            return false;
        }
    }

    public void logout() {
        // Implement logout logic here
    }

    public ArrayList<TVShow> searchByTitle(String title) {
        ArrayList<TVShow> list = new ArrayList<>();
        for(TVShow show : tvShowList){
            if(show.getTitle().contains(title)){
                list.add(show);
            }
        }
        for(TVShow show : movieList){
            if(show.getTitle().contains(title)){
                list.add(show);
            }
        }
        return list;
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

