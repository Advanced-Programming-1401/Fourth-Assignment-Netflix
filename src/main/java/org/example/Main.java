package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static String seperator = "---------------------------------------------------";

    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu(){
        NetflixService netflix = initilizeNetflix();
        Scanner scanner = new Scanner(System.in);


        System.out.println(seperator);
        System.out.println("Welcome to Netflix!");
        System.out.println(seperator);

        boolean runner = true;
        while(runner) {
            int option;
            System.out.println("Options: ");
            System.out.println("1: Log In");
            System.out.println("2: Register");
            System.out.println("3: Exit");
            option = scanner.nextInt();
            scanner.nextLine();

            String username = "";
            String password = "";
            switch(option) {
                case 1:
                    System.out.print("Enter your username: ");
                    username = scanner.nextLine();

                    System.out.print("Enter your password: ");
                    password = scanner.nextLine();

                    if(netflix.login(username, password)) {
                        System.out.print("Logged in successfully!");
                        System.out.println(seperator);
                        userMenu(netflix);
                    } else {
                        System.out.print("Logging failed.");
                    }
                    break;
                
                case 2:
                    System.out.print("Enter your username: ");
                    username = scanner.nextLine();

                    System.out.print("Enter your password: ");
                    password = scanner.nextLine();

                    if(netflix.createAccount(username, password)) {
                        System.out.println("Account created successfuly!");
                    } else {
                        System.out.println("Account creation failed.");
                    }
                    break;
                
                case 3:
                    System.out.println("Bye!");
                    runner = false;
                    break;
            }

            System.out.println(seperator);
        }
    }

    public static void userMenu(NetflixService netflix) {
        Scanner scanner = new Scanner(System.in);
        boolean runner = true;

        System.out.println(seperator);
        System.out.println("Welcome " + netflix.getCurrentUser().getUsername());
        System.out.println(seperator);

        while(runner) {
            ArrayList<TVShow> chosenShows;
            int option;

            System.out.println("Options: ");
            System.out.println("1: Search show/movie by title");
            System.out.println("2: Search show/movie by genre");
            System.out.println("3: Search show/movie by release year");

            System.out.println("4: Search favorites by title");
            System.out.println("5: Search favorites by genre");
            System.out.println("6: Search favorites by release year");

            System.out.println("7: View favorites");
            System.out.println("8: View recommendations");

            System.out.println("9: Log Out");

            option = scanner.nextInt();
            scanner.nextLine();

            System.out.println(seperator);

            int index;
            int chosenIndex;
            switch (option) {
                case 1:
                    String title;
                    System.out.print("Type a title: ");
                    title = scanner.nextLine();
                    
                    chosenShows = netflix.searchByTitle(title);
                    
                    System.out.print("Results: ");

                    if(chosenShows == null) {
                        System.out.print("No shows/movies found!");
                        break;
                    }

                    index = 1;
                    for(TVShow show : chosenShows) {
                        System.out.println(index + ":");
                        System.out.println("Title: " + show.getTitle());
                        System.out.println("Genre: " + show.getGenre());
                        System.out.println("Release year: " + show.getYear());
                        System.out.println(seperator);
                        index++;
                    }

                    System.out.print("Choose a show/movie (or type 0 to exit): ");
                    chosenIndex = scanner.nextInt();
                    scanner.nextLine();

                    if(chosenIndex == 0) {
                        break;
                    } else {
                        userDoShow(netflix, chosenShows.get(chosenIndex-1), false);
                    }
                    break;

                case 2:
                    String genre;
                    System.out.print("Type a genre: ");
                    genre = scanner.nextLine();
                    
                    chosenShows = netflix.searchByGenre(genre);
                    
                    System.out.print("Results: ");

                    if(chosenShows == null) {
                        System.out.print("No shows/movies found!");
                        break;
                    }

                    index = 1;
                    for(TVShow show : chosenShows) {
                        System.out.println(index + ":");
                        System.out.println("Title: " + show.getTitle());
                        System.out.println("Genre: " + show.getGenre());
                        System.out.println("Release year: " + show.getYear());
                        System.out.println(seperator);
                        index++;
                    }

                    System.out.print("Choose a show/movie (or type 0 to exit): ");
                    chosenIndex = scanner.nextInt();
                    scanner.nextLine();

                    if(chosenIndex == 0) {
                        break;
                    } else {
                        userDoShow(netflix, chosenShows.get(chosenIndex-1), false);
                    }
                    break;

                case 3:
                    int year;
                    System.out.print("Type a year: ");
                    year = scanner.nextInt();
                    scanner.nextLine();
                    
                    chosenShows = netflix.searchByReleaseYear(year);
                    
                    System.out.print("Results: ");

                    if(chosenShows == null) {
                        System.out.print("No shows/movies found!");
                        break;
                    }

                    index = 1;
                    for(TVShow show : chosenShows) {
                        System.out.println(index + ":");
                        System.out.println("Title: " + show.getTitle());
                        System.out.println("Genre: " + show.getGenre());
                        System.out.println("Release year: " + show.getYear());
                        System.out.println(seperator);
                        index++;
                    }

                    System.out.print("Choose a show/movie (or type 0 to exit): ");
                    chosenIndex = scanner.nextInt();
                    scanner.nextLine();

                    if(chosenIndex == 0) {
                        break;
                    } else {
                        userDoShow(netflix, chosenShows.get(chosenIndex-1), false);
                    }
                    break;

                case 4:
                    String favoriteTitle;
                    System.out.print("Type a title: ");
                    favoriteTitle = scanner.nextLine();
                    
                    chosenShows = netflix.getCurrentUser().searchByTitle(favoriteTitle);
                    
                    System.out.print("Results: ");

                    if(chosenShows == null) {
                        System.out.print("No shows/movies found!");
                        break;
                    }

                    index = 1;
                    for(TVShow show : chosenShows) {
                        System.out.println(index + ":");
                        System.out.println("Title: " + show.getTitle());
                        System.out.println("Genre: " + show.getGenre());
                        System.out.println("Release year: " + show.getYear());
                        System.out.println(seperator);
                        index++;
                    }

                    System.out.print("Choose a show/movie (or type 0 to exit): ");
                    chosenIndex = scanner.nextInt();
                    scanner.nextLine();

                    if(chosenIndex == 0) {
                        break;
                    } else {
                        userDoShow(netflix, chosenShows.get(chosenIndex-1), true);
                    }
                    break;

                case 5:
                    String favoriteGenre;
                    System.out.print("Type a genre: ");
                    favoriteGenre = scanner.nextLine();
                    
                    chosenShows = netflix.getCurrentUser().searchByGenre(favoriteGenre);
                    
                    System.out.print("Results: ");

                    if(chosenShows == null) {
                        System.out.print("No shows/movies found!");
                        break;
                    }

                    index = 1;
                    for(TVShow show : chosenShows) {
                        System.out.println(index + ":");
                        System.out.println("Title: " + show.getTitle());
                        System.out.println("Genre: " + show.getGenre());
                        System.out.println("Release year: " + show.getYear());
                        System.out.println(seperator);
                        index++;
                    }

                    System.out.print("Choose a show/movie (or type 0 to exit): ");
                    chosenIndex = scanner.nextInt();
                    scanner.nextLine();

                    if(chosenIndex == 0) {
                        break;
                    } else {
                        userDoShow(netflix, chosenShows.get(chosenIndex-1), true);
                    }
                    break;

                case 6:
                    int favoriteYear;
                    System.out.print("Type a year: ");
                    favoriteYear = scanner.nextInt();
                    scanner.nextLine();
                    
                    chosenShows = netflix.getCurrentUser().searchByReleaseYear(favoriteYear);
                    
                    System.out.print("Results: ");

                    if(chosenShows == null) {
                        System.out.print("No shows/movies found!");
                        break;
                    }

                    index = 1;
                    for(TVShow show : chosenShows) {
                        System.out.println(index + ":");
                        System.out.println("Title: " + show.getTitle());
                        System.out.println("Genre: " + show.getGenre());
                        System.out.println("Release year: " + show.getYear());
                        System.out.println(seperator);
                        index++;
                    }

                    System.out.print("Choose a show/movie (or type 0 to exit): ");
                    chosenIndex = scanner.nextInt();
                    scanner.nextLine();

                    if(chosenIndex == 0) {
                        break;
                    } else {
                        userDoShow(netflix, chosenShows.get(chosenIndex-1), true);
                    }
                    break;

                case 7:
                    netflix.getCurrentUser().viewFavorites();
                    System.out.print("Choose a show/movie (or type 0 to exit): ");
                    chosenIndex = scanner.nextInt();
                    scanner.nextLine();

                    if(chosenIndex == 0) {
                        break;
                    } else {
                        userDoShow(netflix, netflix.getCurrentUser().getFavorites().get(chosenIndex-1), true);
                    }
                    break;

                case 8:
                    chosenShows = netflix.getCurrentUser().getFavorites();
                    System.out.print("Results: ");

                    if(chosenShows == null) {
                        System.out.print("No shows/movies found!");
                        break;
                    }

                    index = 1;
                    for(TVShow show : chosenShows) {
                        System.out.println(index + ":");
                        System.out.println("Title: " + show.getTitle());
                        System.out.println("Genre: " + show.getGenre());
                        System.out.println("Release year: " + show.getYear());
                        System.out.println(seperator);
                        index++;
                    }

                    System.out.print("Choose a show/movie (or type 0 to exit): ");
                    chosenIndex = scanner.nextInt();
                    scanner.nextLine();

                    if(chosenIndex == 0) {
                        break;
                    } else {
                        userDoShow(netflix, chosenShows.get(chosenIndex-1), true);
                    }
                    break;

                case 9:
                    System.out.println("Goodbye " + netflix.getCurrentUser().getUsername());
                    netflix.setCurrentUser(null);
                    runner = false;
                    break;
            }
            
            System.out.println(seperator);
        }
        

    }

    public static void userDoShow(NetflixService netflix, TVShow show, boolean fromFavorites) {
        Scanner scanner = new Scanner(System.in);

        int showOption;
        System.out.println("Choose an option: ");

        System.out.println("1: Watch");
        if(!fromFavorites) {
            System.out.println("2: Add to favorites");
            System.out.println("3: Exit");
        } else {
            System.out.println("2: Exit");
        }
        showOption = scanner.nextInt();
        scanner.nextLine();

        if(showOption == 1) {
            netflix.getCurrentUser().watch(show);
        } else if(showOption == 2) {
            if(!fromFavorites) {
                netflix.getCurrentUser().addToFavorites(show);
            }
        }
    }

    public static NetflixService initilizeNetflix() {
        NetflixService inititalNetflix = new NetflixService();

        // Random cast
        ArrayList<String> randomCast = new ArrayList<String>();
        randomCast.add("Ahmad");
        randomCast.add("Mohammad");
        randomCast.add("Mosavi");

        // Random TV Shows
        TVShow showOne = new TVShow("Day", "Drama", 2016, 180, 7.5f, randomCast);
        TVShow showTwo = new TVShow("Night", "Documentary", 2013, 190, 9.1f, randomCast);
        TVShow showThree = new TVShow("Evening", "Comedy", 1998, 214, 3.6f, randomCast);   

        inititalNetflix.addTVShow(showOne);
        inititalNetflix.addTVShow(showTwo);
        inititalNetflix.addTVShow(showThree);

        // Random Movies
        Movie movieOne = new Movie("Movie Day", "Drama", 2016, 180, 7.5f, randomCast, 123);
        Movie movieTwo = new Movie("Movie Night", "Documentary", 2013, 190, 9.1f, randomCast, 111);
        Movie movieThree = new Movie("Movie Evening", "Comedy", 1998, 214, 3.6f, randomCast, 99);   

        inititalNetflix.addMovie(movieOne);
        inititalNetflix.addMovie(movieTwo);
        inititalNetflix.addMovie(movieThree);


        return inititalNetflix;
    }
}
