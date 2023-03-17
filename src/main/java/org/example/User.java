package org.example;

import java.util.ArrayList;

class User {
    /*
    * The user should contain username password.
    * The user should contain an ArrayList of favorite shows and watch history.
    * FUNCTION: the user should have a function to watch a show and add it to watch history.
    *  *** NOTE: All search functions in user are for searching in favorite shows ***
    */
    private String username;
    private String password;
    ArrayList<User> userList;
    ArrayList<TVShow> favoriteShowList ;
    ArrayList<TVShow> watchHistoryList ;

    public User(String username , String password){
        this.username =username;
        this.password =password;
        this.favoriteShowList = new ArrayList<>();
        this.watchHistoryList = new ArrayList<>();
        this.userList = new ArrayList<>();
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void watchShow(TVShow tvShow){
        watchHistoryList.add(tvShow);
    }

    public ArrayList<TVShow> getWatchHistoryList() {
        return watchHistoryList;
    }

    public void setWatchHistoryList(ArrayList<TVShow> watchHistoryList) {
        this.watchHistoryList = watchHistoryList;
    }


    public ArrayList<TVShow> searchByTitle(String title) {
        // Implement search by title in favorite shows  logic here
        ArrayList<TVShow> result = new ArrayList<>();
        for (TVShow tvShow : favoriteShowList)
        {
            if(title.compareTo(tvShow.getTitle())== 0)
            {
                result.add(tvShow);
            }
        }
        return result;
    }
    public ArrayList<TVShow> searchByGenre(String genre) {
        // Implement search by genre in favorite shows  logic here
        ArrayList<TVShow> result = new ArrayList<>();
        for (TVShow tvShow : favoriteShowList)
        {
            if(genre.compareTo(tvShow.getGenre())== 0)
            {
                result.add(tvShow);
            }
        }
        return result;
    }
    public ArrayList<TVShow> searchByReleaseYear(int year) {
        // Implement search by release year in favorite shows logic here
        ArrayList<TVShow> result = new ArrayList<>();
        for (TVShow tvShow : favoriteShowList)
        {  //cause this is int and can't use compare method
            if(year == tvShow.getReleaseYear())
            {
                result.add(tvShow);
            }
        }
        return result;
    }
    public void addToFavorites(TVShow show) {
        // Implement add to favorites logic here
        favoriteShowList.add(show);
        System.out.println("ADD SUCCESSFULLY");
    }

    public ArrayList<TVShow> getFavoriteShowList() {
        return favoriteShowList;
    }

    public void setFavoriteShowList(ArrayList<TVShow> favoriteShowList) {

        this.favoriteShowList = favoriteShowList;
    }
    public void viewFavorites() {
        // Implement view favorites logic here
        System.out.print("Your favorites are :\n" + favoriteShowList);
    }

    /*public ArrayList<TVShow> getRecommendations() {
        // Implement get recommendations logic here
        /*System.out.println(" Suggested Movie ");
        if(getGenre().equals("Mystery")){
            System.out.print("The Woman In the Window\nMurder Mystery\nKnives out\n");
        }
        if(genre.equals("Psychology/Fiction")){
            System.out.print("Seven\nFight Club\nBlack Swan\n");
        }
        System.out.println(" Suggested TV Show ");
        if(genre.equals("Mystery")){
            System.out.print("Sharp Objects\nDefending Jacob\nThe Undoing\n");
        }
        if(genre.equals("Psychology/Fiction")){
            System.out.print("Lost\nDark\nStranger Things\n");
        }
        return null;*/
        /*private  NetflixService netflixService = new NetflixService();
        private  User currentUser = null;

            ArrayList<TVShow> recommendedShows = new ArrayList<>();

            if (currentUser != null) {
                // Get the user's watch history
                ArrayList<TVShow> watchHistory = currentUser.getWatchHistoryList();

                // Get all TV shows from the Netflix service
                ArrayList<TVShow> allShows = netflixService.getTvShows();

                // For each show in the user's watch history, add all shows in the same genre to the recommended list
                for (TVShow watchedShow : watchHistory) {
                    String genre = watchedShow.getGenre();
                    for (TVShow show : allShows) {
                        if (show.getGenre().equals(genre) && !watchHistory.contains(show) && !recommendedShows.contains(show)) {
                            recommendedShows.add(show);
                        }
                    }
                }

                // If there are no shows recommended based on genre, add the top-rated shows
                if (recommendedShows.isEmpty()) {
                    for (TVShow show : allShows) {
                        if (!watchHistory.contains(show) && show.getRating().equals("5")) {
                            recommendedShows.add(show);
                        }
                    }
                }
            }

            return recommendedShows;
        }

    }*/

    public void addHistory(TVShow tvShow){
        watchHistoryList.add(tvShow);
    }
    public void addFavorit(TVShow tvShow){
        favoriteShowList.add(tvShow);
    }
    public void addHistory(Movie movie){
        watchHistoryList.add(movie);
    }
    public void addFavorit(Movie movie){
        favoriteShowList.add(movie);
    }



    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", favoriteShowList=" + favoriteShowList +
                ", watchHistoryList=" + watchHistoryList +
                ", userList=" + userList +
                '}';
    }

}
