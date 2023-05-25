package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static NetflixService netflixService = new NetflixService();

    public static void main(String[] args) {

        //---------------------------------------------------------movie templates------------------------------------------------------

        Movie fiveFeetApart = new Movie("Five Feet Apart", "Romance", 2019, 116, 7.2, new ArrayList<>(Arrays.asList("Haley Lu Richardson", "Cole Sprouse", "Moises Arias")), 116);
        Movie interstellar = new Movie("Interstellar", "Science Fiction", 2014, 169, 8.6, new ArrayList<>(Arrays.asList("Matthew McConaughey", "Anne Hathaway", "Jessica Chastain")), 169);
        Movie wolfOfWallStreet = new Movie("The Wolf of Wall Street", "Comedy/Drama", 2013, 180, 8.2, new ArrayList<>(Arrays.asList("Leonardo DiCaprio", "Jonah Hill", "Margot Robbie")), 180);

        netflixService.addMovie(fiveFeetApart);
        netflixService.addMovie(interstellar);
        netflixService.addMovie(wolfOfWallStreet);


        //---------------------------------------------------------TvShow templates------------------------------------------------------
        TVShow friends = new TVShow("Friends", "Sitcom", 1994, 236, 8.9, new ArrayList<>(Arrays.asList("Jennifer Aniston", "Courteney Cox", "Lisa Kudrow")));
        TVShow breakingBad = new TVShow("Breaking Bad", "Crime Drama", 2008, 62, 9.4, new ArrayList<>(Arrays.asList("Bryan Cranston", "Aaron Paul", "Anna Gunn")));

        netflixService.addTVShow(friends);
        netflixService.addTVShow(breakingBad);


        //------------------------------------menu stuff----------------------------------
        netflixService.createAccount("farid","1234");
        netflixMenu();
    }

    public static void netflixMenu(){
        System.out.println("\nNetflix Menu");
        System.out.println("1.Create Account");
        System.out.println("2.Login");
        System.out.println("3.Logout");
        System.out.println("4.Search by Title");
        System.out.println("5.Search by Genre");
        System.out.println("6.Search by Release Year");
        System.out.println("7.Search by Release Year in favourites");
        System.out.println("8.Search by Title in favourites");
        System.out.println("9.Search by Genre in favourites");
        System.out.println("10.Get recommendations");
        System.out.println("11.Add to favourites");
        System.out.println("12.See your favourites");
        System.out.println("13.Exit");
        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                createAccount();
                netflixMenu();
                break;
            case 2:
                login();
                netflixMenu();
                break;
            case 3:
                logout();
                netflixMenu();
                break;
            case 4:
                searchByTitle();
                netflixMenu();
                break;
            case 5:
                searchByGenre();
                netflixMenu();
                break;
            case 6:
                searchByReleaseYear();
                netflixMenu();
                break;
            case 7:
                searchByTitleInFavourites();
                netflixMenu();
                break;
            case 8:
                searchByGenreInFavourites();
                netflixMenu();
                break;
            case 9:
                searchByReleaseYearInFavourites();
                netflixMenu();
                break;
            case 10:
                recommendations();
                netflixMenu();
                break;
            case 11:
                addToFavourites();
                netflixMenu();
                break;
            case 12:
                showFavourites();
                netflixMenu();
                break;
            case 13:
                System.out.println("Goodbye!");
                return;
            default:
                System.out.println("Invalid choice! Please try again.");
                netflixMenu();
        }
    }
    public static void createAccount() {
        System.out.println("Enter a username:");
        String username = input.nextLine();
        System.out.println("Enter a password:");
        String password = input.nextLine();
        User user = netflixService.createAccount(username, password);
        if (user == null) {
            System.out.println("Username is already taken.");
        } else {
            System.out.println("Account created successfully.");
        }
    }
    public static void login() {
        if (netflixService.getCurrentUser() != null) {
            System.out.println("You are already logged in as " + netflixService.getCurrentUser().getUserName() + ".");
            return;
        }

        System.out.println("Enter your username:");
        String username = input.nextLine();
        System.out.println("Enter your password:");
        String password = input.nextLine();

        if (netflixService.login(username, password)) {
            System.out.println("You logged in successfully.");
            //some menu to watch or something
        } else {
            System.out.println("Wrong password or username!");
            login();
        }
    }
    public static void logout() {
        if (netflixService.getCurrentUser() == null) {
            System.out.println("You are not logged in.");
        } else {
            System.out.println("Goodbye, " + netflixService.getCurrentUser().getUserName() + "!");
            netflixService.logout();
        }
    }
    public static void searchByTitle() {
        System.out.println("Enter a title:");
        String title = input.nextLine();
        ArrayList<TVShow> tvShow = netflixService.searchByTitle(title);
        if (tvShow.size() == 0) {
            System.out.println("No TV show or movie found with that title.");
        } else {
            for (TVShow show : tvShow) {
                System.out.println("Title: " + show.getTitle());
                System.out.println("Genre: " + show.getGenre());
                System.out.println("Release Year: " + show.getReleaseYear());
                System.out.println("-----------------------");
            }
        }
    }
    public static void searchByGenre(){
        System.out.println("Enter a genre:");
        String genre = input.nextLine();
        ArrayList<TVShow> tvShow = netflixService.searchByGenre(genre);
        if (tvShow.size() == 0) {
            System.out.println("No TV show or movie found with that genre.");
        }
        else {
            for (TVShow show : tvShow) {
                System.out.println("Title: " + show.getTitle());
                System.out.println("Genre: " + show.getGenre());
                System.out.println("Release Year: " + show.getReleaseYear());
                System.out.println("-----------------------");
            }
        }
    }
    public static void searchByReleaseYear(){
        System.out.println("Enter a Year:");
        int year = input.nextInt();
        ArrayList<TVShow> tvShow = netflixService.searchByReleaseYear(year);
        if (tvShow.size() == 0) {
            System.out.println("No TV show or movie found in that year.");
        }
        else {
            for (TVShow show : tvShow) {
                System.out.println("Title: " + show.getTitle());
                System.out.println("Genre: " + show.getGenre());
                System.out.println("Release Year: " + show.getReleaseYear());
                System.out.println("-----------------------");
            }
        }
    }
    public static void searchByTitleInFavourites() {
        System.out.println("Enter a title:");
        String title = input.nextLine();
        ArrayList<TVShow> tvShow = netflixService.getCurrentUser().searchByTitle(title);
        if (tvShow.size() == 0) {
            System.out.println("No TV show or movie found with that title.");
        } else {
            for (TVShow show : tvShow) {
                System.out.println("Title: " + show.getTitle());
                System.out.println("Genre: " + show.getGenre());
                System.out.println("Release Year: " + show.getReleaseYear());
                System.out.println("-----------------------");
            }
        }
    }
    public static void searchByGenreInFavourites(){
        System.out.println("Enter a genre:");
        String genre = input.nextLine();
        ArrayList<TVShow> tvShow = netflixService.getCurrentUser().searchByGenre(genre);
        if (tvShow.size() == 0) {
            System.out.println("No TV show or movie found with that genre.");
        }
        else {
            for (TVShow show : tvShow) {
                System.out.println("Title: " + show.getTitle());
                System.out.println("Genre: " + show.getGenre());
                System.out.println("Release Year: " + show.getReleaseYear());
                System.out.println("-----------------------");
            }
        }
    }
    public static void searchByReleaseYearInFavourites(){
        System.out.println("Enter a Year:");
        int year = input.nextInt();
        ArrayList<TVShow> tvShow = netflixService.getCurrentUser().searchByReleaseYear(year);
        if (tvShow.size() == 0) {
            System.out.println("No TV show or movie found in that year.");
        }
        else {
            for (TVShow show : tvShow) {
                System.out.println("Title: " + show.getTitle());
                System.out.println("Genre: " + show.getGenre());
                System.out.println("Release Year: " + show.getReleaseYear());
                System.out.println("-----------------------");
            }
        }
    }
    public static void recommendations() {
        ArrayList<TVShow> recommendationsList = netflixService.getCurrentUser().getRecommendations(netflixService);
        System.out.println("Here are some Movies and Shows you might enjoy:");
        for(TVShow show : recommendationsList){
            System.out.println("Title: " + show.getTitle());
            System.out.println("Genre: " + show.getGenre());
            System.out.println("Release Year: " + show.getReleaseYear());
            System.out.println("-----------------------");
        }
    }
    public static void addToFavourites(){
        System.out.println("Enter a title");
        String title = input.nextLine();
        if(netflixService.getCurrentUser().getfavouriteShow().contains(netflixService.searchForTitle(title))){
            System.out.println("You have already added this movie to your favourites!");
            return;
        }
        if(netflixService.searchForTitle(title) != null) {
            netflixService.getCurrentUser().addToFavorites(netflixService.searchForTitle(title));
            System.out.println("Movie has been added to the favourites.");
        }
        else{
            System.out.println("Movie not found!");
        }
    }
    public static void showFavourites(){
        System.out.println("These are your favourites Show and Movies:");
        ArrayList<TVShow> favourites = netflixService.getCurrentUser().getfavouriteShow();
        for(TVShow show : favourites){
            System.out.println("Title: " + show.getTitle());
            System.out.println("Genre: " + show.getGenre());
            System.out.println("Release Year: " + show.getReleaseYear());
            System.out.println("-----------------------");
        }
    }
}

