package org.example;

import java.util.ArrayList;

class NetflixService implements searchAndShow {
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<TVShow> tvShows = new ArrayList<>();
    private User currentUser;

    //Constructors
    public NetflixService(User currentUser) {
        this.currentUser = currentUser;
    }

    //Getters and Setters
    public static ArrayList<User> getUsers() {
        return users;
    }

//    public void setCurrentUser(User currentUser){
//        this.currentUser = currentUser;
//    }

    public static void setUsers(ArrayList<User> users) {
        NetflixService.users = users;
    }

    public static ArrayList<TVShow> getTvShows() {
        return tvShows;
    }

    public static TVShow getASingleTVShow(String Title) {
        for (TVShow tvShow : tvShows) {
            if (tvShow.getTitle().equals(Title)) {
                return tvShow;
            }
        }
        return null;
    }

    public static void setTvShows(ArrayList<TVShow> tvShows) {
        NetflixService.tvShows = tvShows;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    //Service - Related Functions
    public void addTVShow(TVShow tvShow) {
        tvShows.add(tvShow);
    }

    public static boolean doesUserExist(String username) {
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static void createAccount(String username, String password) {
        if (!doesUserExist(username)) {
            User newUser = new User(username, password);
            users.add(newUser);
            System.out.println("AN ACCOUNT FOR USER " + newUser.getUserName() + " HAS BEEN SUCCESSFULLY CREATED");
        } else {
            System.out.println("THIS USERNAME ALREADY EXISTS");
        }
    }

    public void login(String username, String password) {
        for (User user : users) {
            if (user.getUserName().equals(username) && user.getPassWord().equals(password)) {
                setCurrentUser(user);
                System.out.println(user.getUserName() + " HAS BEEN SUCCESSFULLY LOGGED IN");
                return;
            }
        }
        System.out.println("USERNAME OR PASSWORD IS WRONG PLEASE TRY AGAIN");
    }

    public void logout() {
        System.out.println("User " + this.currentUser.getUserName() + " Successfully Logged Out!");
        this.currentUser = null;
    }

    public ArrayList<TVShow> searchByTitle(String title) {
        ArrayList<TVShow> list = new ArrayList<>();

        for (TVShow tvShow : tvShows) {
            if (tvShow.getTitle().equals(title)) {
                list.add(tvShow);
            }
        }
        if (list.size() != 0) {
            return list;
        }
        return null;
    }

    public ArrayList<TVShow> searchByGenre(String genre) {
        ArrayList<TVShow> list = new ArrayList<>();

        for (TVShow tvShow : tvShows) {
            if (tvShow.getGenre().equals(genre)) {
                list.add(tvShow);
            }
        }
        if (list.size() != 0) {
            return list;
        }
        return null;
    }

    public ArrayList<TVShow> searchByReleaseYear(int year) {
        ArrayList<TVShow> list = new ArrayList<>();

        for (TVShow tvShow : tvShows) {
            if (tvShow.getReleaseYear() == year) {
                list.add(tvShow);
            }
        }
        if (list.size() != 0) {
            return list;
        }
        return null;
    }

    @Override
    public void showList(ArrayList<TVShow> list) {
        if (list.size() != 0) {
            for (TVShow tvShow : list) {
                System.out.println(tvShow.toString());
            }
        } else {
            System.out.println("LIST IS EMPTY");
        }
    }


    @Override
    public boolean doesTVShowExist(String title) {
        for (TVShow tvShow : tvShows) {
            if (tvShow.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }
}

