package mypakage;

public class Book{
	
	String title, author;
	String ISBN;
	
	Book(String title, String author, String isbn){
		this.title = title;
		this.author = author;
		this.ISBN = isbn;
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	
	public String toString(){
        return "\tTitle: "+title+"\n\tAuthor: "+author+"\n\tISBN: "+ISBN;
    }

	
}
