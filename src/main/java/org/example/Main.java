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
    
    public static void runMenu(){
        //TODO:
    }
}
