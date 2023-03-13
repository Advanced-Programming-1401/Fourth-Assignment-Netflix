package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        NetflixService netflix = new NetflixService(null);
        System.out.println("-------------------------------WELCOME TO NETFLIX SITE-------------------------------");

        //INITIALIZING DEFAULT MOVIE IN SITE
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Denzel Washington");
        cast.add("Marton Csokas");
        cast.add("Chloe Grace Moretz");

        Movie defaultMovie = new Movie(2, "The Equalizer", "Action", 2014, 7.2, cast);
        NetflixService.tvShows.add(defaultMovie);

        runMenu(netflix);
    }

    public static void runMenu(NetflixService netflix) {

        System.out.println("CHOOSE ONE OPTION FROM BELOW:\n");
        System.out.println("1- CREATE AN NEW ACCOUNT\n2- LOGIN AS USER\n3- EXIT");
        int menuOption = input.nextInt();
        input.nextLine();

        switch (menuOption) {
            case 1 -> {
                System.out.println("ENTER : 1-USERNAME, 2-PASSWORD");
                String userName = input.nextLine();
                String passWord = input.nextLine();
                NetflixService.createAccount(userName, passWord);  //checks if it's possible creates an account otherwise shows a message
                runMenu(netflix);
            }
            case 2 -> {
                System.out.println("ENTER : 1-USERNAME, 2-PASSWORD");
                String userName = input.nextLine();
                String passWord = input.nextLine();
                if (netflix.login(userName, passWord)) {
                    //checks whether userName and passWord is Valid Otherwise shows a message
                    System.out.println("------------------------- " + netflix.getCurrentUser().getUserName() + " -------------------------");
                    userPage(netflix);
                } else {
                    runMenu(netflix);
                }
            }
            case 3 -> {
                System.out.println("PROGRAM SUCCESSFULLY TERMINATED");
                return;
            }
        }
    }

    public static void userPage(NetflixService netflix) {
        System.out.println("CHOOSE ONE OPTION FROM BELOW\n");
        System.out.println("1- SEARCH THROUGH ALL OF TV-SHOWS\n2- SEARCH THROUGH YOUR FAVORITE TV-SHOWS\n3- RECOMMENDED TV-SHOWS FROM YOUR FAVORITES\n4- ADD TO YOUR FAVORITES\n5- ADD TV-SHOW TO ALL THE MOVIES\n6- BACK TO MAIN MENU\n");
        int optionMenu = input.nextInt();
        input.nextLine();

        switch (optionMenu) {
            case 1 -> {
                //SEARCH THROUGH ALL OF TV-SHOWS
                System.out.println("CHOOSE SEARCH OPTION:\n");
                System.out.println("1- SEARCH BY TITLE\n2- SEARCH BY GENRE\n3- SEARCH BY RELEASE YEAR");
                optionMenu = input.nextInt();
                input.nextLine();

                switch (optionMenu) {
                    case 1 -> {
                        //SEARCH BY TITLE
                        System.out.println("ENTER TITLE:");
                        netflix.showList(netflix.searchByTitle(input.nextLine()));
                    }
                    case 2 -> {
                        //SEARCH BY GENRE
                        System.out.println("ENTER GENRE:");
                        netflix.showList(netflix.searchByGenre(input.nextLine()));
                    }
                    case 3 -> {
                        //SEARCH BY RELEASE YEAR
                        System.out.println("ENTER RELEASE YEAR:");
                        netflix.showList(netflix.searchByReleaseYear(input.nextInt()));
                        input.nextLine();
                    }
                }
            }
            case 2 -> {
                //SEARCH THROUGH USER's FAVORITE TV-SHOWS
                System.out.println("CHOOSE SEARCH OPTION:\n");
                System.out.println("1- SEARCH BY TITLE\n2- SEARCH BY GENRE\n3- SEARCH BY RELEASE YEAR");
                optionMenu = input.nextInt();
                input.nextLine();

                switch (optionMenu) {
                    case 1 -> {
                        //SEARCH BY TITLE
                        System.out.println("ENTER TITLE:");
                        netflix.showList(netflix.getCurrentUser().searchByTitle(input.nextLine()));
                    }
                    case 2 -> {
                        //SEARCH BY GENRE
                        System.out.println("ENTER GENRE:");
                        netflix.showList(netflix.getCurrentUser().searchByGenre(input.nextLine()));
                    }
                    case 3 -> {
                        //SEARCH BY RELEASE YEAR
                        System.out.println("ENTER RELEASE YEAR:");
                        netflix.showList(netflix.getCurrentUser().searchByReleaseYear(input.nextInt()));
                        input.nextLine();
                    }
                }

            }
            case 3 -> {
                //SHOW A LIST OF RECOMMENDED MOVIES
                netflix.getCurrentUser().showList(netflix.getCurrentUser().getRecommendations());
            }
            case 4 -> {
                //ADD TO USER's FAVORITE TV-SHOWS
                System.out.println("ENTER TITLE OF THE TV-SHOW: ");
                String title = input.nextLine();
                if (netflix.doesTVShowExist(title)) {   //CHECKS ALL THE MOVIES
                    if (!netflix.getCurrentUser().doesTVShowExist(title)) { //CHECKS USER FAVORITE MOVIES
                        netflix.getCurrentUser().addToFavorites(NetflixService.getASingleTVShow(title));
                    } else {
                        System.out.println("USER HAS ALREADY HAVE THIS TV-SHOW IN HIS FAVORITES");
                    }
                } else {
                    System.out.println("THIS TV-SHOW DOESN'T EXIST");
                }
            }
            case 5 -> {
                //ADD TV-SHOW TO ALL THE MOVIES
                System.out.println("ENTER 1-TITLE, 2-GENRE, 3-RELEASE YEAR, 4-RATING");
                String title = input.nextLine();
                String genre = input.nextLine();
                int releaseYear = input.nextInt();
                input.nextLine();
                double rating = input.nextDouble();
                input.nextLine();

                if (netflix.doesTVShowExist(title)) {
                    System.out.println("THIS TV-SHOW ALREADY EXIST YOU CAN'T ADD IT");
                } else {
                    System.out.println("ENTER CAST ONE BY ONE AND INPUT A -1 WHEN YOU ARE DONE");
                    ArrayList<String> cast = new ArrayList<>();
                    while (true) {
                        String menuOption = input.nextLine();
                        if (!menuOption.equals("-1")) {
                            cast.add(menuOption);
                        } else {
                            break;
                        }
                    }
                    TVShow tvShow = new TVShow(title, genre, releaseYear, rating, cast);
                    NetflixService.tvShows.add(tvShow);
                    System.out.println("TV-SHOW HAS BEEN SUCCESSFULLY ADDED");
                }
            }
            case 6 -> {
                runMenu(netflix);
            }
        }
        userPage(netflix);
    }
}
