# 4th Assignment Report

![](https://github.com/kianaghamsari/Second-Assignment/blob/develop/uni.png)

## Kiana Ghamsari - 400222079


# Introduction 

In this program, the simulation of Netflix has been created.
A user can sign up, log in, search for different TV shows or Movies, add shows to favorites, or watch later. The project recommends some shows to a user sorted by their rating.


The program includes 5 classes:
* User
* TVShow
* NetflixService
* Movie
* Main

# Design and Implementation
Here, the details of these classes are provided:

![Netflix](https://user-images.githubusercontent.com/90266554/226000477-f4b0a933-a22a-48bd-a657-fae74017b662.jpeg)

In main:
* First, the user enters his username. If the entered username exists, the program asks for the password to log in. If it doesn't exist, it tries to sign up the new user
* After logging in, the main menu shows up which contains querying a show, seeing the list of recommendations and user's favorites.
* The user can search among either his favorite shows or all shows by title, genre, and release year. 
* Adding a show to the users' watch later list is also possible.
* A GUI is also provided by Java Swing
* When the program starts, initial data is loaded. The data includes: title, genre, release year, duration, rating, cast
* class `Movie` is inherited from `TVShow` which contains one extra field: "length"

# Conclusion

* I experienced using inheritance and encapsulation
* I could have implemented a new class called "Cast" that contains actors and actresses and each show could contain a ManyToMany field to Cast class. So there could be a search option by the name of the cast
