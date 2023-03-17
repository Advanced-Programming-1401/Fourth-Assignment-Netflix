package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    //don't limit yourself to our template ***
    static Scanner sc=new Scanner(System.in);
    static NetflixServise netflixService= new NetflixService();
    public static void main(String[] args) {
        Movie bladeRunner2049 = new Movie("Blade Runner 2049", "Science Fiction", 2017, 163, 8.0, new ArrayList<>(Arrays.asList("Ryan Gosling", "Harrison Ford", "Ana de Armas")), 164);
        Movie fiveFeetApart = new Movie("Five Feet Apart", "Romance", 2019, 116, 7.2, new ArrayList<>(Arrays.asList("Haley Lu Richardson", "Cole Sprouse", "Moises Arias")), 116);
        Movie interstellar = new Movie("Interstellar", "Science Fiction", 2014, 169, 8.6, new ArrayList<>(Arrays.asList("Matthew McConaughey", "Anne Hathaway", "Jessica Chastain")), 169);
        netflixService.addMovie(bladeRunner2049);
        netflixService.addMovie(fiveFeetApart);
        netflixService.addMovie(interstellar);

    }
    
    public static void netflixMenu(){
        System.out.println("Netflix Menu");
        System.out.println("1.Create Account");
        System.out.println("2.login");
        System.out.println("3.log out");
        System.out.println("4.Search by title");
        System.out.println("5.Search by genre");
        System.out.println("6.Search by release year");
        System.out.println("7.Search by release year in favorite");
        System.out.println("8.Search by title in favorites");
        System.out.println("10.get recomindation");
        System.out.println("11.add to favorites");
        System.out.println("12.See your favorites");
        System.out.println("13 Exit");
        int choice=sc.nextInt();
        switch(choice){
            case 1:{
                createAccount();
                netflixMenu();
                break;
            }
            case 2:{
                login();
                netflixMenu();
                break;
            }
            case 3:{
                logout();
                netflixMenu();
                break;
            }
            case 4:{
                searchByTitle();
                netflixMenu();
                break;
            }
            case 5:{
                serchByGenre();
                netflixMenu();
                break;
            }
            case 6:{
                searchByReleaseYear();
                netflixMenu();
                break;
            }
            case 7:{
                searchByTitleInFavorites();
                netflixMenu();
                break;
            }
            case 8:{
                searchByGenreInFavorite();
                netflixMenu();
                break;
            }
            case 9:{
                searchByReleaseYearInFavorites();
                netflixMenu();
                break;
            }
            case 10:{
                recomendations();
                netflixMenu();
                break;
            }
            case 11:{
                addToFavorites;
                netflixMenu();
                break;
            }
            case 12:{
                showFavorites();
                netflixMenu();
                break;
            }
            case 13:{
                System.out.println("bye");
                netflixMenu();
                break;
                // exit here
            }

        }
        public static void createAccount() {
            System.out.println("Enter userName");
            String username=sc.nextLine();
            System.out.println("enter password");
            String password=sc.nextLine();
            User user=netflixService.createAccount(username,password);
            if(user==null){
                System.out.println("usename is already taken");
            }
            else{
                System.out.println("created");
            }

        }
        //TODO33:
    }
}
