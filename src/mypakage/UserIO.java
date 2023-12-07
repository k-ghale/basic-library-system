package mypakage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UserIO {

	String name;
	String ID;
	private ArrayList<Book> booksBorrowed = new ArrayList<>();
	
	UserIO(String name , String ID){
		this.name = name;
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	//method
	public void borrowBook(Book book) {
        booksBorrowed.add(book);
    }
	
	public void displayUserInfo() {
        System.out.println("NAME: " + name + ", ID: " + ID);
        System.out.println("BOOKS BORROWED:");
        for (Book book : booksBorrowed) {
            System.out.println(book);
        }
    }
	
	public void saveInfo() {
		try {
	         File file = new File("D:UserInfo.txt");
	         FileWriter writer = new FileWriter(file);

	         for (Book book : booksBorrowed) {
	        	 writer.write("NAME: " + name + ", ID: " + ID);
	        	 writer.write("\nBOOKS BORROWED:");
	             writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getISBN() + "\n");
	         }
	         
	         writer.close();
	     } catch (IOException e) {
	         System.out.println("ERROR SAVING : " + e.getMessage());
	     }
	 }
	
	
}
