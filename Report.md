
# 4th Assignment Report

# Ali Sawari 401222077


[^1]: Spring 2023


# Introduction:

 The purpose of the assignment is to get to know and use classes, OOP and polymorphism in our code.
In this assignment we are meant to create a Netflix service which consists of users, shows and movies. To do so we abstract each of these and create a class for them.

 In a nutshell, classes were made for **NetflixService**, **User**, **TVShow** and **Movie**. **NetflixService** is basically a collection of users, shows, movies and also some methods to manipulate these data. What **TVShow** holds are title, genre, release year, duration and rating. **Movie** is inherited from **TVShow** and only contains the extra property `length`. A **User**, which consists of a username, password a list of favorite shows and history, can watch show/movie or add it to favorites.

Bonus Objectives that have been done:
1: Input Validation (partially)

# Design and Implementation

![classes UML](https://raw.githubusercontent.com/Retriever5500/Fourth-Assignment-Netflix/dev/NetflixUML.png)

 To make each of these, we create an initial library of class **NetflixService** and create lists of users, shows and movies. Also, we create three methods to search shows/movies by title, genre and release year. Eventually, for **NetflixService**, we create login and register methods and store the current user.

 For **User**, we create a list of favorite shows, a history, and two strings for username and password and methods for searching and viewing favorites. For **TVShow**, we create two strings for its title and genre; plus one integer for release year and one float to store its rating. **Movie** is inherited from **TVShow** and has only the extra integer property `length`.

# Testing
 In menu when a user is trying to register, if the user enters a username that has been already used the registaration process will fail. Moreover, when the user has registered successfuly, if they enter the wrong password during log in, the process will fail.

 If we search by title/genre/release year in Netflix or user's favorites, we observe that the correct corresponding shows/movies. Also a user can watch a show or movie(which will add it to history) and add it to favorites. Lastly, all of shows/movies marked as favorite can be viewed by the user.

# Conclusion

 We learned how to break down our code to smaller bits and abstract some structures. And also, more importantly, how to use inheritance and polymorphism in our code.
