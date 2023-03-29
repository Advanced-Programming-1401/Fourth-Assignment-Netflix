package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static org.example.NetflixService.getTvShows;
import static org.example.NetflixService.tvShows;

class User {
    /*
    * The user should contain username password.
    * The user should contain an ArrayList of favorite shows and watch history.
    * FUNCTION: the user should have a function to watch a show and add it to watch history.
    *  *** NOTE: All search functions in user are for searching in favorite shows ***
    */
    private static String username;
    private static String password;
    static ArrayList<TVShow> faveShows = new ArrayList();
    static ArrayList<TVShow> watchHistory = new ArrayList();
    public User(String username, String password, ArrayList<String> faveShows, ArrayList<String> watchHistory){
        this.username = username;
        this.password = password;
    }

    public static String getUsername(){
        return username;
    }
    //
    public void setUsername(){
        this.username = username;
    }
    public static String getPassword(){
        return password;
    }
    public void setPassword(){
        this.password = password;
    }
    public ArrayList<TVShow> getFaveShows(){
        return faveShows;
    }
    public ArrayList<TVShow> setFaveShows(){
        this.faveShows = faveShows;
        return faveShows;
    }
    public ArrayList<TVShow> getWatchHistory(){
        return watchHistory;
    }
    public ArrayList<TVShow> setWatchHistory(){
        this.watchHistory = watchHistory;
        return watchHistory;
    }
    public static ArrayList<TVShow> searchByTitle(String title) {
        // Implement search by title in favorite shows logic here
        ArrayList<TVShow> foundTVShow = new ArrayList();
        Scanner sc = new Scanner(System.in);
        for (TVShow tvShow : faveShows){
            if (TVShow.getTitle().equals(title)){
                System.out.println("This show is in your favorites list");
                System.out.println("Would you like to watch this show again?");
                System.out.println("Press 1 for YES and 2 for NO");
                int choice;
                choice = sc.nextInt();
                if (choice == 1){
                    System.out.println("Enjoy!");
                }
                if (choice == 2){
                    Main.userMenu();
                }
                if (choice > 3){
                    System.out.println("This option does not exist!");
                }
            }
        }
        return null;
    }
    public static ArrayList<TVShow> searchByGenre(String genre) {
        // Implement search by genre in favorite shows  logic here
        ArrayList<TVShow> foundTVShow = new ArrayList();
        for (TVShow tvShow : faveShows){
            if (TVShow.getGenre().equals(genre)){
                foundTVShow.add(tvShow);
            }
        }
        return foundTVShow;
    }
    public static ArrayList<TVShow> searchByReleaseYear(int year) {
        // Implement search by release year in favorite shows logic here
        ArrayList<TVShow> foundTVShow = new ArrayList();
        for (TVShow tvShow : faveShows){
            if (TVShow.getReleaseYear() == year){
                foundTVShow.add(tvShow);
            }
        }
        return foundTVShow;
    }
    public static void addToFavorites(TVShow show) {
        // Implement add to favorites logic here
        faveShows.add(show);
    }
    public static void addToWatchHistory(TVShow show){
        // Implement add to watch history logic here
        watchHistory.add(show);
    }
    public static ArrayList<TVShow> viewFavorites() {
        // Implement view favorites logic here
        return faveShows;
    }
    public static ArrayList<TVShow> viewWatchHistory() {
        return watchHistory;
    }
    public static TVShow getRecommendations() {
        // Implement get recommendations logic here
        for (TVShow tvshows : getTvShows()) {
            Random rand = new Random();
            TVShow randomShow = getTvShows().get(rand.nextInt(tvShows.size()));
            return randomShow;
        }
        return null;
    }
}
