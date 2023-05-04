package Library.src.logic;

import Library.src.components.Books;
import Library.src.components.Users;

import java.util.Scanner;

public class Menus {

    private final Books book = new Books();
    private final Users users = new Users();
    private final Login login = new Login();


    Menus(){}

    public void firstMenu(){
        Scanner menu = new Scanner(System.in);
        int option=0;
        do{
            System.out.println("========= WELCOME TO THE LIBRARY =========");
            System.out.println("    1: Login");
            System.out.println("    2: Register");
            System.out.println("    3: Exit");
            System.out.println("Your option:");

            option = menu.nextInt();

            switch (option) {
                case 1 -> {
                    loginMenu();
                }

                case 2 -> {
                    users.addUser();
                }

                case 3 -> {
                    optionExit();
                    menu.close();
                }
                default -> {
                    System.out.println("Invalid option.");
                    menu.close();
                }
            }
        }while(option!=3);
    }

    public void loginMenu(){
        Scanner sc = new Scanner(System.in);
        String username, pass;
        System.out.println("Username: ");
        username = sc.next();
        System.out.println("Password: ");
        pass = sc.next();

        boolean checkname = login.isAdmin(username,pass);
        //boolean checkpass = login.verifyParameters(username, pass);
        System.out.println(checkname);
        //System.out.println(checkpass);

        if(checkname) {
            adminMenu();
        }
        else{
            if(login.verifyParameters(username,pass))
                commonUserMenu();
        }

    }

    public void commonUserMenu(){

        Scanner menu = new Scanner(System.in);
        int option = 0;
        do{
            System.out.println("    1: Add Book to your personal list");
            System.out.println("    2: Your Account");
            System.out.println("    3: Check list of all the books");
            System.out.println("    4: Exit");
            System.out.println("Your option:");

            option = menu.nextInt();

            switch(option){

                case 1 -> {
                    // ADD BOOK TO PERSONAL LIST
                    goBackMenu();
                }

                case 2 ->{}

                case 3 -> {
                    optionCheckBookList();
                    menu.close();
                }

                case 4 -> {
                    optionExit();
                    menu.close();
                }

                default -> {
                    System.out.println("Invalid option.");
                    menu.close();
                }
            }
        }while(option!=4);
    }

    public void adminMenu(){

        Scanner menu = new Scanner(System.in);
        int option = 0;
        do{
            System.out.println("    1: Add Book");
            System.out.println("    2: Remove Book");
            System.out.println("    3: Check list of all the books");
            System.out.println("    4: Add User");
            System.out.println("    5: Remove User");
            System.out.println("    6: Check list of all the users");
            System.out.println("    7: Exit");
            System.out.println("Your option:");

            option = menu.nextInt();

            switch(option){

                case 1 -> {
                    optionAddBook();
                    goBackMenu();
                }

                case 2 ->{
                    book.removeBook();
                    goBackMenu();
                }

                case 3 -> {
                    optionCheckBookList();
                    goBackMenu();
                }

                case 7 -> {
                    optionExit();
                    menu.close();
                }

                default -> {
                    System.out.println("Invalid option.");
                    menu.close();
                }
            }
        }while(option!=7);
    }

    public void goBackMenu(){

        Scanner sc = new Scanner(System.in);
        int option = 0;
        do{
            System.out.println(" ");
            System.out.println(" Would you like to go back?");
            System.out.println("   1: Yes");
            System.out.println("   2: No");
            System.out.println("   3: Exit");
            System.out.println("Your option:");

            option= sc.nextInt();

            switch(option){

                case 1 -> {
                    //  VERIFY IF IT IS ADMIN OR NOT  ( keep user to verify function: whatKindUser)
                    commonUserMenu();
                    sc.close();
                }

                case 2 ->{}

                case 3 -> {
                    optionExit();
                    sc.close();
                }

                default -> {
                    System.out.println("Invalid option.");
                    sc.close();
                }
            }
        }while(option!=3);
    }

    public void optionAddBook(){
        book.createNewFilerBooks();
        book.addBookToList(book);
        goBackMenu();
    }

    public void optionCheckBookList(){
        book.createNewFilerBooks();
        book.readBookOnList("books.txt");
        goBackMenu();
    }

    public void optionExit(){
        System.out.println("You just exist the online library. Thank you!");
        System.exit(0);
    }

}