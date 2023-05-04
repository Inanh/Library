package Library.src.components;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Users implements Serializable{
    private int idUser;
    private String userName;
    private String pass;
    private int[] list_of_books;

    public Users(){}

    //============================== GETTER ==================================//

    public int getIdUser(){ return idUser;}

    public String getUserName(){ return userName;}

    public String getPass(){  return pass; }

    public int[] getList(){return list_of_books;}  //redo if need

//============================== SETTER ==================================//

    public void setIdUser(int iu){ idUser = iu;}

    public void setUserName(String un){ userName= un;}

    public void setPass(String p){  pass= p; }

    //make function to add books

//============================== OTHER FUNCTIONS ==================================//

    public void addBooktoUserList(){
        
    }

    public void addUser(){

        Scanner sc = new Scanner(System.in);
        String pass,pass1;

        System.out.println("Name of the new user:");
        setUserName(sc.next());

        //do function to give an id to a user and not manualy
        System.out.println("Id:");
        setIdUser(sc.nextInt());
        //-------------------------------------------

        do{
            System.out.println("Pass:");
            pass=sc.next();
            System.out.println("Pass again:"); 
            pass1=sc.next();
            if(verifyPassword(pass, pass)){
                setPass(pass1);
            }
            else{
                System.out.println("Please insert equals passwords!");
            }
        }while(verifyPassword(pass, pass1));

        //and set array of books to zero
    }

    public boolean verifyPassword(String pass1,String pass2){

        return pass1.equals(pass2);
    }

    public void createNewFileforUsers(){
        try{
            File file = new File("users.txt");

            if(file.createNewFile()){}
    
        }catch(IOException e){
            e.printStackTrace();
        }
         
    }

    public void registerUser(){
        
    }

    public void addUser(Users u) {
        try{
            FileOutputStream fos = new FileOutputStream("books.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            addUser();
            oos.writeObject(u);
            oos.flush();
            oos.close();
            u = null;

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void readUserFile(String fileName) {
        try{
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Users.this.getClass().cast(ois.readObject());

            System.out.println("Name: " + Users.this.getUserName());
            System.out.println("ID : " + Users.this.getIdUser());
            System.out.println("Pass:"+ Users.this.getPass());
            System.out.println("Your Books:" + Arrays.toString(Users.this.getList()));

            ois.close();
                
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
 
}
