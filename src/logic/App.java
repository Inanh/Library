package Library.src.logic;

import Library.src.components.Users;
import Library.src.components.Books;

public class App {

    private Menus menu = new Menus();
    private Books book = new Books();
    private Users users = new Users();

    public App(){}

    public Menus getMenu(){return menu;}
    public Books getBooks(){ return book;}
    public Users getUsers(){ return users;}

    public void test(){
        getMenu().firstMenu();
        //getMenu().secondMenu();
        //getBooks().createNewFileforBooks();
        //getBooks().addBookToList(book);
        //getBooks().readBookOnList("books.txt");
    }

    //addbook -> check if it is admin

}
