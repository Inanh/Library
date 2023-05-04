package Library.src.components;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.*;


public class Books implements Serializable{
    private String name;
    private int id;
    private String genre;

    public Books(){}

    Books(String name, int id,String genre){
        this.name= name;
        this.id = id;
        this.genre = genre;
    }

//============================== GETTER ==================================//

    public String getBookName(){ return name;}

    public int getId(){  return id; }

    public String getGenre(){return genre;}

//============================== SETTER ==================================//

    public void setName(String n){ name =n; }

    public void setId(int i){ id =i;}

    public void setGenre(String g){ genre =g;}

//============================== OTHER FUNCTIONS ==================================//

    public void createNewFilerBooks(){
        try{
            File file = new File("books.txt");

            if(file.createNewFile()){
                System.out.println("File created: " + file.getName());
            }
            else{
                System.out.println("The current file already exists.");
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void addBook(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Name of the new book:");
        setName(sc.next());
        System.out.println("Id:");
        setId(sc.nextInt());
        System.out.println("Genre:");
        setGenre(sc.next());  
    }

    public void addBookToList(Books b) {
        try{
            FileOutputStream fos = new FileOutputStream("books.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            addBook();
            oos.writeObject(b);
            oos.flush();
            oos.close();
            b = null;
            System.out.println("Successfully book added");

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void readBookOnList(String fileName) {

        try{
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Books.this.getClass().cast(ois.readObject());

            System.out.println("Name: " + Books.this.getBookName());
            System.out.println("ID : " + Books.this.getId());
            System.out.println("Genre:"+ Books.this.getGenre());

            ois.close();
                
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void removeBook(){

    }
}


