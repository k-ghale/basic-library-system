package mypakage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



//Library Class - has all books
class Library {
	
 private ArrayList<Book> books = new ArrayList<>();
 private static Library instance = new Library();

 Library() {
     loadBooksFromFile(); // LOAD BOOKS
 }

 public static Library getInstance() {
     return instance;
 }

 public void addBook(Book book) {
     books.add(book);
     saveBooksToFile();
 }

 public void displayBooks() {
     for (Book book : books) {
         System.out.println(book+"\n");
     }
 }

 public Book searchBook(String title) throws BookNotFoundException {
     for (Book book : books) {
         if (book.getTitle().equalsIgnoreCase(title)) {
             return book;
         }
     }
     throw new BookNotFoundException("BOOK NOT FOUND: " + title);
 }

 private void loadBooksFromFile() {
     // Load 
 	try {
         File file = new File("D:Library.txt");
         Scanner scanner = new Scanner(file);

         while (scanner.hasNextLine()) {
             String line = scanner.nextLine();
             String[] parts = line.split(",");
             if (parts.length == 3) {
                 String title = parts[0].trim();
                 String author = parts[1].trim();
                 String isbn = parts[2].trim();
                 Book book = new Book(title, author, isbn);
                 books.add(book);
             }
         }
         scanner.close();
     } catch (FileNotFoundException e) {
         System.out.println("ERROR LOADING : " + e.getMessage());
     }
 }
 
 
 private void saveBooksToFile() {
     // Save
 	try {
         File file = new File("D:Library.txt");
         FileWriter writer = new FileWriter(file);

         for (Book book : books) {
             writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getISBN() + "\n");
         }
         
         writer.close();
     } catch (IOException e) {
         System.out.println("ERROR SAVING : " + e.getMessage());
     }
 }
 
 public void removeBook(String title) throws BookNotFoundException {
     Book bookToRemove = null;
     
     for (Book book : books) {
         if (book.getTitle().equalsIgnoreCase(title)) {
             bookToRemove = book;
             break;
         }
     }
     
     if (bookToRemove != null) {
         books.remove(bookToRemove);
         saveBooksToFile(); // Save
         System.out.println("BOOK REMOVED : " + bookToRemove);
     } else {
         throw new BookNotFoundException("BOOK NOT FOUND: " + title);
     }
 }
 
 
 }