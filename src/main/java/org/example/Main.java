package org.example;

public class Main {
    //don't limit yourself to our template ***

    private static NetflixService netflixService = new NetflixService();
    private static User currentUser = null;
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        // Creating some sample users
        netflixService.createAccount("user1", "password1");
        netflixService.createAccount("user2", "password2");

        runMenu();
    }

    public static void runMenu(){
        //TODO:
        int choice = 0;
        do {
            System.out.println("Netflix Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Logout");
            System.out.println("4. Search TV Shows by Title");
            System.out.println("5. Search TV Shows by Genre");
            System.out.println("6. Search TV Shows by Release Year");
            System.out.println("7. Add TV Show");
            System.out.println("8. Add Movie");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    netflixService.createAccount(username, password);
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    boolean loginSuccess = netflixService.login(loginUsername, loginPassword);
                    if (loginSuccess) {
                        currentUser = netflixService.getCurrentUser();
                        System.out.println("Welcome, " + currentUser.getUsername() + "!");
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;
                case 3:
                    if (currentUser != null) {
                        netflixService.logout();
                        currentUser = null;
                        System.out.println("Logged out successfully.");
                    } else {
                        System.out.println("You are not logged in.");
                    }
                    break;
                case 4:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    netflixService.searchByTitle(title);
                    break;
                case 5:
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    netflixService.searchByGenre(genre);
                    break;
                case 6:
                    System.out.print("Enter release year: ");
                    int year = scanner.nextInt();
                    netflixService.searchByReleaseYear(year);
                    break;
                case 7:
                    if (currentUser != null) {
                        System.out.print("Enter title: ");
                        String tvShowTitle = scanner.nextLine();
                        System.out.print("Enter genre: ");
                        String tvShowGenre = scanner.nextLine();
                        System.out.print("Enter release year: ");
                        int tvShowYear = scanner.nextInt();
                        scanner.nextLine(); // Consume the leftover newline character
                        System.out.print("Enter duration: ");
                        String tvShowDuration = scanner.nextLine();
                        System.out.print("Enter rating: ");
                        String tvShowRating = scanner.nextLine();
                        System.out.print("Enter cast (separated by commas): ");
                        String castString = scanner.nextLine();
                        String[] castArray = castString.split(",");
                        netflixService.addTVShow(new TVShow(tvShowTitle, tvShowGenre, tvShowYear, tvShowDuration, tvShowRating,
                    }
                case 8:
                    if (currentUser != null) {
                        System.out.println("Logging out...");
                        netflixService.logout();
                        currentUser = null;
                    } else {
                        System.out.println("You are not logged in!");
                    }
                    break;

                case 9:
                    if (currentUser != null) {
                        System.out.println("You are already logged in!");
                    } else {
                        System.out.print("Enter your username: ");
                        String username = scanner.next();
                        System.out.print("Enter your password: ");
                        String password = scanner.next();

                        if (netflixService.login(username, password)) {
                            System.out.println("Login successful!");
                            currentUser = netflixService.getUser();
                        } else {
                            System.out.println("Invalid username or password!");
                        }
                    }
                    break;

            }
        }
    }
}
