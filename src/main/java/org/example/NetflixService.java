package org.example;

import java.util.*;

class NetflixService {
    /*
     *The NetflixService should have an Arraylist of users, tv shows and movies.
     *The NetflixService should have a User object which represents current user.
     */
    Scanner input = new Scanner(System.in);

    private List<User> usersList;
    private List<TVShow> TVshowList;
    private List<Movie> movieList;

    public NetflixService() {
        this.usersList = new ArrayList<>();
        this.TVshowList = new ArrayList<>();
        this.movieList = new ArrayList<>();
    }

    public void addTVShow(TVShow tvShow){
        // Implement add tv show logic here
        TVshowList.add(tvShow);
    }

    public void addMovie(Movie movie){
        // Implement add movie logic here
        movieList.add(movie);
    }

    public void createAccount(User user) {
        usersList.add(user);
    }

    public boolean login(String username, String password) {
        for(User user : usersList){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public void logout() {

    }

    public ArrayList<TVShow> searchByTitle(String title){
        ArrayList<TVShow> found = new ArrayList<TVShow>();
        for(TVShow tvshow: TVshowList){
            if(TVshowList.contains(title)){
                found.add(tvshow);
            }
        }
        return found;
    }

    public ArrayList<TVShow> searchByGenre(String genre){
        ArrayList<TVShow> found = new ArrayList<TVShow>();
        for(TVShow tvshow: TVshowList){
            if(TVshowList.contains(genre)){
                found.add(tvshow);
            }
        }
        return found;
    }

    public ArrayList<TVShow> searchByReleaseYear(int year) {
        ArrayList<TVShow> found = new ArrayList<TVShow>();
        for(TVShow tvshow: TVshowList){
            if(TVshowList.contains(year)){
                found.add(tvshow);
            }
        }
        return found;
    }


}

