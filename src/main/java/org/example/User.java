package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class User {
    /*
    * The user should contain username password.
    * The user should contain an ArrayList of favorite shows and watch history.
    */
    private String userName;
    private String password;
    private ArrayList<TVShow> favouriteShow;

    public User (String userName, String password){
        this.userName = userName;
        this.password = password;
        this.favouriteShow = new ArrayList<>();
    }

    public String getUserName(){
        return userName;
    }
    public void setUserName(String username){
        this.userName = userName;
    }
    public String getpassword(){
        return password;
    }
    public void setpassword(String password){
        this.password = password;
    }
    public ArrayList<TVShow> getfavouriteShow(){
        return favouriteShow;
    }
    public void setFavouriteShow(ArrayList<TVShow> favouriteshow){
        this.favouriteShow = favouriteShow;
    }


//...........................METHODS.......................................................


    public ArrayList<TVShow> searchByTitle(String title){
        ArrayList<TVShow> save = new ArrayList<>();
        for (int i=0; i<favouriteShow.size(); i++)
        {
            if (title.equals(favouriteShow.get(i).getTitle()))
            {
                save.add(favouriteShow.get(i));
            }
        }
        return (save);
    }
    public ArrayList<TVShow> searchByGenre(String genre){
        ArrayList<TVShow> list = new ArrayList<>();
        for(TVShow show : favouriteShow){
            if(show.getGenre().contains(genre)){
                list.add(show);
            }
        }
        return list;
    }
    public ArrayList<TVShow> searchByReleaseYear(int year) {
        ArrayList<TVShow> list = new ArrayList<>();
        for(TVShow show : favouriteShow){
            if(show.getReleaseYear() == year){
                list.add(show);
            }
        }
        return list;
    }
    public void addToFavorites(TVShow show) {
        favouriteShow.add(show);
    }
    public ArrayList<TVShow> getRecommendations(NetflixService netflix) {
        ArrayList<TVShow> recommendations = new ArrayList<>();
        for (TVShow tvShow : netflix.getTvShowList()) {
            //Check if the TV show has not been already watched
            if (!favouriteShow.contains(tvShow)) {
                //Check if the TV show has the same genre as the last watched TV show by the user
                if (favouriteShow.size() > 0 && (tvShow.getGenre().contains(favouriteShow.get(favouriteShow.size() - 1).getGenre()) || favouriteShow.get(favouriteShow.size() - 1).getGenre().contains(tvShow.getGenre()))) {
                    recommendations.add(tvShow);
                }
                //Check if the TV show has a high rating
                else if (tvShow.getRating() > 8.0) {
                    recommendations.add(tvShow);
                }
            }
        }
        return recommendations;

    }
}