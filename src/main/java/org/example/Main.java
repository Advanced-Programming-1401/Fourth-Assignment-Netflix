package org.example;

import java.util.Scanner;

public class Main {
    //don't limit yourself to our template ***


    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu() {
        String username, password, password1;
        System.out.println("Welcome to Netflix!");
        System.out.println("Please choose an option : ");
        System.out.println("1. Create account");
        System.out.println("2. Login");
        System.out.println("3. Exit Netflix");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Please enter a username for your account : ");
                username = sc.next();
                System.out.println("Please enter a password for your account : ");
                password = sc.next();
                System.out.println("Please enter your password again");
                password1 = sc.next();
                if (password.equals(password1)) {
                    NetflixService.createAccount(username, password);
                }
                else{
                    System.out.println("Passwords don't match!");
                    runMenu();
                }
                break;
            case 2:
                System.out.println("Please enter your account's username : ");
                username = sc.next();
                System.out.println("Please enter your account's password : ");
                password = sc.next();
                NetflixService.login(username, password);
            case 3:
                System.out.println("Hope we see you again soon!");
                System.exit(0);
            default:
                System.out.println("This option is not available!");
                break;
        }
    }
    public static void userMenu(){
        String title, genre;
        int releaseYear;
        System.out.println("Welcome to your account!");
        System.out.println("Please select an option : ");
        System.out.println("1. Search movie by title");
        System.out.println("2. Search movie by genre");
        System.out.println("3. Search movie by release year");
        System.out.println("4. Search TV show by title");
        System.out.println("5. Search TV show by genre");
        System.out.println("6. Search TV show by release year");
        System.out.println("7. Search your favorite or previously watched TV show by title");
        System.out.println("8. Search your favorite or previously watched TV show by genre");
        System.out.println("9. Search your favorite or previously watched TV show by release year");
        System.out.println("10. view your favorite TV shows");
        System.out.println("11. view watch history");
        System.out.println("12. Get TV show recommendations");
        System.out.println("13. Logout");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter the movie title");
                title = sc.next();
                NetflixService.searchMovieByTitle(title);
                break;
            case 2:
                System.out.println("Enter the movie genre");
                genre = sc.next();
                NetflixService.searchMovieByGenre(genre);
                break;
            case 3:
                System.out.println("Enter the movie release year");
                releaseYear = sc.nextInt();
                NetflixService.searchMovieByReleaseYear(releaseYear);
                break;
            case 4:
                System.out.println("Enter the movie title");
                title = sc.next();
                NetflixService.searchTVShowByTitle(title);
                break;
            case 5:
                System.out.println("Enter the movie genre");
                genre = sc.next();
                NetflixService.searchTVShowByGenre(genre);
                break;
            case 6:
                System.out.println("Enter the movie release year");
                releaseYear = sc.nextInt();
                NetflixService.searchTVShowbyReleaseYear(releaseYear);
                break;
            case 7:
                System.out.println("Enter the movie title");
                title = sc.next();
                User.searchByTitle(title);
                break;
            case 8:
                System.out.println("Enter the movie genre");
                genre = sc.next();
                User.searchByGenre(genre);
                break;
            case 9:
                System.out.println("Enter the movie release year");
                releaseYear = sc.nextInt();
                User.searchByReleaseYear(releaseYear);
                break;
            case 10:
                User.viewFavorites();
            case 11:
                User.viewWatchHistory();
            case 12:
                User.getRecommendations();
            case 13:
                NetflixService.logout();
            default:
                System.out.println("This option does not exist!");
        }
    }
}
