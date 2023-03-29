package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class NetflixService {
    /*
     *The NetflixService should have an Arraylist of users, tv shows and movies.
     *The NetflixService should have a User object which represents current user.
     */
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<TVShow> tvShows = new ArrayList<>();
    static ArrayList<Movie> movies = new ArrayList<>();

    public static ArrayList<TVShow> getTvShows(){
        return tvShows;
    }

    public void addTVShow(TVShow tvShow){
        // Implement add tv show logic here
        ArrayList castAdd1 = new ArrayList();
        castAdd1.add("Rachel Brosnahan");
        castAdd1.add("Micheal Zegen");
        TVShow no1 = new TVShow("The Marvelous Mrs. Maisel",
                "Drama, Comedy",
                2017,
                6,
                8.7,
                castAdd1);
        tvShows.add(no1);
        ArrayList castAdd2 = new ArrayList();
        castAdd2.add("Jeremy Strong");
        castAdd2.add("Sarah Snook");
        TVShow no2 = new TVShow("Succession",
                "Satire, Dark comedy",
                2018,
                5,
                8.8,
                castAdd2);
        ArrayList castAdd3 = new ArrayList();
        castAdd3.add("Louis CK");
        castAdd3.add("Pamela Adlon");
        TVShow no3 = new TVShow("Louie",
                "Sitcom",
                2010,
                5,
                8.5,
                castAdd3);
    }

    public void addMovie(Movie movie){
        // Implement add movie logic here
        ArrayList castAdd1 = new ArrayList();
        castAdd1.add("Brad Pitt");
        castAdd1.add("Edward Norton");
        Movie no1 = new Movie("Fight Club",
                "Thriller, Drama",
                1999,
                1,
                8.8,
                castAdd1,
                139);
        movies.add(no1);
        ArrayList castAdd2 = new ArrayList();
        castAdd2.add("Jim Carrey");
        castAdd2.add("Ed Harris");
        Movie no2 = new Movie("The Truman Show",
                "Drama, Sci-fi",
                1998,
                1,
                8.2,
                castAdd2,
                103);
        movies.add(no2);
        ArrayList castAdd3 = new ArrayList();
        castAdd3.add("Quentin Tarantino");
        castAdd3.add("Leonardo DiCaprio");
        Movie no3 = new Movie("Django Unchained",
                "Western, Drama",
                2012,
                1,
                8.4,
                castAdd3,
                165);
        movies.add(no3);
    }

    public static void createAccount(String username, String password) {
        // Implement create account logic here
        ArrayList emptyFaveShows = new ArrayList();
        ArrayList emptyWatchHistory = new ArrayList();
        if (users.contains(username)){
            System.out.println("Username already exists! Choose another one");
        }
        if (users.contains(password)){
            System.out.println("Password already exists! Choose another one");
        }
        else{
            User new_user = new User(username, password, emptyFaveShows, emptyWatchHistory);
            users.add(new_user);
            System.out.println("ACCOUNT CREATED SUCCESSFULLY");
            System.out.println("Now we will send you to the main menu to login");
            Main.runMenu();
        }
    }

    public static boolean login(String username, String password) {
        // Implement login logic here
        for (User user : users){
            if (User.getUsername().equals(username) && User.getPassword().equals(password)){
                System.out.println("Welcome to your account!");
                Main.userMenu();
            }
            else{
                System.out.println("Username or password is wrong");
                return false;
            }
        }
        return false;
    }

    public static void logout() {
        // Implement logout logic here
        Main.runMenu();
    }

    public static ArrayList<TVShow> searchTVShowByTitle(String title) {
        // Implement search by title logic here
        Scanner sc = new Scanner(System.in);
        for (TVShow tvShow : tvShows){
            if (TVShow.getTitle().equals(title)){
                System.out.println("TV show " + title + " found!");
                System.out.println("Please select an option");
                System.out.println("1. Watch TV show");
                System.out.println("2. Add TV show to favorites");
                System.out.println("3. Go back");
                int choice;
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        User.addToWatchHistory(tvShow);
                        User.addToFavorites(tvShow);
                        System.out.println("Enjoy!");
                        break;
                    case 2:
                        User.addToFavorites(tvShow);
                    case 3:
                        Main.userMenu();
                }
            }
        }
        return null;
    }

    public static ArrayList<TVShow> searchTVShowByGenre(String genre) {
        // Implement search by genre logic here
        ArrayList<TVShow> foundTVShow = new ArrayList();
        for (TVShow tvShow : tvShows){
            if (TVShow.getGenre().equals(genre)){
                foundTVShow.add(tvShow);
            }
        }
        return foundTVShow;
    }

    public static ArrayList<TVShow> searchTVShowbyReleaseYear(int year) {
        // Implement search by release year logic here
        ArrayList<TVShow> foundTVShow = new ArrayList();
        for (TVShow tvShow : tvShows){
            if (TVShow.getReleaseYear() == year){
                foundTVShow.add(tvShow);
            }
        }
        return foundTVShow;
    }
    public static ArrayList<Movie> searchMovieByTitle(String title) {
        // Implement search by title logic here
        Scanner sc = new Scanner(System.in);
        for (Movie movie : movies){
            if (Movie.getTitle().equals(title)){
                System.out.println("Movie " + title + " found!");
                System.out.println("Please select an option");
                System.out.println("1. Watch movie");
                System.out.println("2. Add movie to favorites");
                System.out.println("3. Go back");
                int choice;
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        User.addToWatchHistory(movie);
                        User.addToFavorites(movie);
                        System.out.println("Enjoy!");
                        break;
                    case 2:
                        User.addToFavorites(movie);
                    case 3:
                        Main.userMenu();
                }
            }
        }
        return null;
    }

    public static ArrayList<Movie> searchMovieByGenre(String genre) {
        // Implement search by genre logic here
        ArrayList<Movie> foundMovie = new ArrayList();
        for (Movie movie : movies){
            if (Movie.getGenre().equals(genre)){
                foundMovie.add(movie);
            }
        }
        return foundMovie;
    }

    public static ArrayList<Movie> searchMovieByReleaseYear(int year) {
        // Implement search by release year logic here
        ArrayList<Movie> foundMovie = new ArrayList();
        for (Movie movie : movies){
            if (Movie.getReleaseYear() == year){
                foundMovie.add(movie);
            }
        }
        return foundMovie;
    }
}

