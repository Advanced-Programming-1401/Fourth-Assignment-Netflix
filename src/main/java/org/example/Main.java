package org.example;

import java.util.ArrayList;

import javax.swing.*;

public class Main {
    //don't limit yourself to our template ***
    static NetflixService netflixService = new NetflixService();

    public static void main(String[] args) {
        shows();
        runMenu();
    }

    public static void runMenu(){
        while(true) {
            String username = JOptionPane.showInputDialog(null, "NETFLIX\n*****Netflix - Watch TV Shows Online, Watch Movies Online*****\nReady to watch? Enter a username to create or restart your membership.");
            if (username == null) {
                break;
            } else {
                if (netflixService.doesUserExist(username)) { // login
                    String password = JOptionPane.showInputDialog(null, "Hello " + username + "!\nPlease enter your password: ");
                    if(netflixService.login(username, password)) {
                        String userMenuOption = JOptionPane.showInputDialog(null, "Welcome to your page " + username + "!" + "\nWhat would you like to do?\n" + displayUserMenu());
                        switch (userMenuOption) {
                            case "1": // Watch a Show
                                String watchOption_title = JOptionPane.showInputDialog(null, "Enter the Title of the show you want to watch: ");
                                if (!netflixService.searchByTitle(watchOption_title).isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "Let's watch " + netflixService.searchByTitle(watchOption_title).get(0));
                                    netflixService.getUser().watchAShow(netflixService.searchByTitle(watchOption_title).get(0));
                                } else {
                                    JOptionPane.showMessageDialog(null, "Nothing Found!");
                                }
                                break;
                            case "2": // Get Recommendations
                            JOptionPane.showMessageDialog(null, "Recommended TVShows and movies: \n" + netflixService.getUser().getRecommendations(netflixService.getTvShows()));
                                break;
                            case "3": // View Favorites                          
                                String searchOption_Favorites = JOptionPane.showInputDialog(null, "Search By: \n" + searchShowsList());
                                switch (searchOption_Favorites) {
                                    case "1": // Search By a Title in Favorites
                                        String title = JOptionPane.showInputDialog(null, "Enter the Title: ");
                                        if(netflixService.getUser().searchByTitle(title).isEmpty())
                                            JOptionPane.showMessageDialog(null, "Nothing Found!");
                                        else 
                                            JOptionPane.showMessageDialog(null, netflixService.getUser().searchByTitle(title));
                                            netflixService.getUser().viewFavorites();
                                        break;
                                    case "2": // Search By a Genre in Favorites
                                        String genre = JOptionPane.showInputDialog(null, "Enter the Genre: ");
                                        if(netflixService.getUser().searchByGenre(genre).isEmpty())
                                            JOptionPane.showMessageDialog(null, "Nothing Found!");
                                        else 
                                            JOptionPane.showMessageDialog(null, netflixService.getUser().searchByGenre(genre));
                                            netflixService.getUser().viewFavorites();
                                        break;
                                    case "3": // Search By a Release Year in Favorites
                                        String releaseYear = JOptionPane.showInputDialog(null, "Enter the Release Year: ");
                                        if(netflixService.getUser().searchByReleaseYear(Integer.parseInt(releaseYear)).isEmpty())
                                            JOptionPane.showMessageDialog(null, "Nothing Found!");
                                        else 
                                            JOptionPane.showMessageDialog(null, netflixService.getUser().searchByReleaseYear(Integer.parseInt(releaseYear)));
                                            netflixService.getUser().viewFavorites();
                                        break;

                                    default:
                                        runMenu();
                                        break;
                                }
                                break;
                            case "4": // Search Shows
                                String searchOption_all = JOptionPane.showInputDialog(null, "Search By: \n" + searchShowsList());
                                switch (searchOption_all) {
                                    case "1": // Search By a Title
                                        String title = JOptionPane.showInputDialog(null, "Enter the Title: ");
                                        if(netflixService.searchByTitle(title).isEmpty())
                                            JOptionPane.showMessageDialog(null, "Nothing Found!");
                                        else 
                                            JOptionPane.showMessageDialog(null, netflixService.searchByTitle(title));
                                        break;
                                    case "2": // Search By a Genre
                                        String genre = JOptionPane.showInputDialog(null, "Enter the Genre: ");
                                        if(netflixService.searchByGenre(genre).isEmpty())
                                            JOptionPane.showMessageDialog(null, "Nothing Found!");
                                        else 
                                            JOptionPane.showMessageDialog(null, netflixService.searchByGenre(genre));
                                        break;
                                    case "3": // Search By a Release Year
                                        String releaseYear = JOptionPane.showInputDialog(null, "Enter the Release Year: ");
                                        if(netflixService.searchByReleaseYear(Integer.parseInt(releaseYear)).isEmpty())
                                            JOptionPane.showMessageDialog(null, "Nothing Found!");
                                        else 
                                            JOptionPane.showMessageDialog(null, netflixService.searchByReleaseYear(Integer.parseInt(releaseYear)));
                                        break;
                                    default:
                                        runMenu();
                                        break;
                                }
                                break;
                            case "5": // Add Shows
                                String addOption = JOptionPane.showInputDialog(null, "Add To: \n" + addShowsList());
                                switch (addOption) {
                                    case "1": // Add to Your Favorites
                                        String titleAddToFavorites = JOptionPane.showInputDialog(null, "Enter a Title to add to your Favorites: \n");
                                        if (!netflixService.searchByTitle(titleAddToFavorites).isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Let's add " + netflixService.searchByTitle(titleAddToFavorites).get(0));
                                            netflixService.getUser().addToFavorites(netflixService.searchByTitle(titleAddToFavorites).get(0));
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Nothing Found!");
                                        }

                                        break;
                                    case "2": // Add to Your Watch Later
                                        String titleAddToWatchLater = JOptionPane.showInputDialog(null, "Enter a Title to add to your Watch Later: \n");
                                        if (!netflixService.searchByTitle(titleAddToWatchLater).isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Let's add " + netflixService.searchByTitle(titleAddToWatchLater).get(0));
                                            netflixService.getUser().addToWatchLater(netflixService.searchByTitle(titleAddToWatchLater).get(0));
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Nothing Found!");
                                        }
                                        break;
                                    default:
                                        runMenu();
                                        break;
                                }
                                break;
                            case "6": // Log Out
                                netflixService.logout();
                                runMenu();
                                break;
                            default:
                                runMenu();
                                break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "The username & password you entered do not match. Please try again ");
                        runMenu();
                    }
                } else { // sign up
                    String createdPassword = JOptionPane.showInputDialog(null, "Welcome " + username + "!\nLet's create an account.\nEnter a password: ");
                    netflixService.createAccount(username, createdPassword);
                    runMenu();
                }
            }
        }
    }

    public static String displayUserMenu() {
        return "1: Watch a Show\n2: Get Recommendations\n3: View Favorites\n4: Search Shows\n5: Add Shows\n6: Log Out";
    }

    public static String searchShowsList() {
        return "1: Search by a Title\n2: Search by a Genre\n3: Search by a Release Year";
    }

    public static String addShowsList() {
        return "1: Add to Your Favorites\n2: Add to Your Watch Later";
    }

    public static void shows() {

        ArrayList<String> cast1 = new ArrayList<>();
        cast1.add("Kit Harington");
        cast1.add("Richard Madden");
        cast1.add("Peter Dinklage");
        TVShow tvShow1 = new TVShow("Game of Thrones", "Action, Adventure, Drama", 2011, 55, 9.2, cast1);
        
        ArrayList<String> cast2 = new ArrayList<>();
        cast2.add("Bryan Cranston");
        cast2.add("Aaron Paul");
        TVShow tvShow2 = new TVShow("Breaking bad","Drama",2008,50,9.5,cast2);

        ArrayList<String> cast3 = new ArrayList<>();
        cast3.add("Alvaro Morte");
        cast3.add("Ursula Corbero");
        cast3.add("Itziar Ituno");
        TVShow tvShow3 = new TVShow("Money Heist", "Crime", 2017, 41, 9.4, cast3);

        ArrayList<String> cast4 = new ArrayList<>();
        cast4.add("Cillian Murphy");
        cast4.add("Joe Cole");
        cast4.add("Annabelle Wallis");
        TVShow tvShow4 = new TVShow("Peaky Blinders","Drama",2013,60,8.8,cast4);

        ArrayList<String> cast5 = new ArrayList<>();
        cast5.add("Tom Hiddleston");
        cast5.add("Sophia Di Martino");
        TVShow tvShow5 = new TVShow("Loki", "Action, Adventure, Fantasy", 2021, 3, 8.2, cast5);

        ArrayList<String> cast6 = new ArrayList<>();
        cast6.add("Justin Roiland");
        cast6.add("Spencer Grammer");
        TVShow tvShow6 = new TVShow("Rick and Morty","Animation-Adventure-Comedy",2013,23,9.1,cast6);

        ArrayList<String> cast7 = new ArrayList<>();
        cast7.add("Ali Hemmat Momivand");
        cast7.add("Bijan Alimohamadi");
        cast7.add("Shahrooz Malek Arayi");
        TVShow tvShow7 = new TVShow("The Heroes", "Animation, Drama, History", 2008, 34, 10, cast7);

        ArrayList<String> castM1 = new ArrayList<>();
        castM1.add("Robert Downey Jr.");
        castM1.add("Sebastian Stan");
        castM1.add("Elizabeth Olsen");
        TVShow movie1 = new Movie("Avengers: Infinity war","Adventure, Action",2018,149,8.5,castM1,149);

        ArrayList<String> castM2 = new ArrayList<>();
        castM2.add("Chris Evans");
        castM2.add("Scarlett Johansson");
        castM2.add("Chris Hemsworth");
        TVShow movie2 = new Movie("Avengers: Endgame","Action, Adventure, Drama",2019,181,8.4, castM2,181);

        ArrayList<String> castM3 = new ArrayList<>();
        castM3.add("Chris Evans");
        castM3.add("Robert Downey Jr.");
        castM3.add("Sebastian Stan");
        TVShow movie3 = new Movie("Captain America: Civil War","Action, Sci-Fi",2016,146,7.8, castM3,146);

        ArrayList<String> castM4 = new ArrayList<>();
        castM4.add("Matthew McConaughey");
        castM4.add("Jessica Chastain");
        castM4.add("Timothée Chalamet");
        TVShow movie4 = new Movie("Interstellar","Adventure-Drama",2014,169,8.6, castM4,169);

        ArrayList<String> castM5 = new ArrayList<>();
        castM5.add("Leonardo DiCaprio");
        castM5.add("Tom Hardy");
        castM5.add("Cillian Murphy");
        TVShow movie5 = new Movie("Inception","Action-Adventure",2010,148,8.8,castM5,148);



        netflixService.addTVShow(tvShow1);
        netflixService.addTVShow(tvShow2);
        netflixService.addTVShow(tvShow3);
        netflixService.addTVShow(tvShow4);
        netflixService.addTVShow(tvShow5);
        netflixService.addTVShow(tvShow6);
        netflixService.addTVShow(tvShow7);
        netflixService.addTVShow(movie1);
        netflixService.addTVShow(movie2);
        netflixService.addTVShow(movie3);
        netflixService.addTVShow(movie4);
        netflixService.addTVShow(movie5);

    }
}
