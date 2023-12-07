package mypakage;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Library l1 = new Library();
		
		
		Scanner sc = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("ENTER USER NAME : ");
		String username = in.nextLine();
		System.out.println("ENTER USER ID : ");
		String userid = in.nextLine();
		
		
		UserIO user1 = new UserIO(username, userid);
//		String bookname = sc.nextLine();
//		l1.searchBook(bookname);
		Scanner c = new Scanner(System.in);
		char choice;
		do {
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("\nOPTIONS : \n 1 - ADD BOOK \n 2 - DISPLAY ALL BOOKS \n 3 - SEARCH FOR A BOOK FROM LIBRARY \n 4 - BORROW A BOOK \n 5 - REMOVE A BOOK \n\n 0 TO EXIT\n");
		System.out.println("--------------------------------------------------------------------------");
		int option = sc.nextInt();
		
		
		boolean startLoop = true;
		Scanner loop = new Scanner(System.in);
		
		outer:{
			while(startLoop) {
				switch(option) {
		
		case 1:

			String title  , author , isbn;
			Scanner dc = new Scanner(System.in);
			
			System.out.println("ENTER TITLE OF THE BOOK : ");
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");
			title = dc.nextLine();
			
			System.out.println("ENTER AUTHOR OF THE BOOK : ");
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");
			author = dc.nextLine();
			
			System.out.println("ENTER ISBN OF THE BOOK : ");
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");
			isbn = dc.nextLine();
			
			
			Book book1 = new Book(title , author , isbn);
			l1.addBook(book1);
			break;
			
		case 2:
		
			System.out.println("\t******************************");
			l1.displayBooks();
			System.out.println("\n\t******************************\n");
			break;
			
			
		case 3:
			//search a book
			System.out.println("\nENTER TITLE OF THE BOOK YOU WANT TO FIND :");
			System.out.println("     ******************************");
			Scanner b1 = new Scanner(System.in);
			title = b1.nextLine();

            Book foundBook = l1.searchBook(title);

            

            System.out.println("\n\nBOOK FOUNDED : " + foundBook);
			l1.searchBook(title);
			System.out.println("     ******************************");
			break;
			
		case 4:
			//borrow a book
			try {
			System.out.println("\nENTER TITLE OF THE BOOK YOU WANT TO BORROW :");
			System.out.println("   xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			Scanner bc = new Scanner(System.in);
			title = bc.nextLine();

            Book foundBook1 = l1.searchBook(title);
            
			user1.borrowBook(foundBook1);
			user1.displayUserInfo();
			user1.saveInfo();
			System.out.println("\n   xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
			}
			catch(BookNotFoundException e) {
				System.out.println("CANNOT BORROW ! :(");
			}
			break;	
		
		case 5:
			//remove a book
			try {
			System.out.println("\nENTER TITLE OF THE BOOK YOU WANT TO REMOVE :");
			System.out.println("    **********************************\n");
			Scanner b2 = new Scanner(System.in);
			title = b2.nextLine();

			System.out.println("    **********************************");
            l1.removeBook(title);
            System.out.println("    **********************************");
			}
			catch(BookNotFoundException e) {
				System.out.println("CAN'T FIND THE BOOK ! :(");
			}
			break;
		
		case 0:
			//
			System.exit(0);
			break;
		
		default:
			System.out.println("INVALID OPTION :)  !");
				}
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("\nDO YOU WANT TO CONTINUE ?(y/n)");
        String restart = loop.next();
        startLoop = restart.equalsIgnoreCase("y");
				}
			
			}
		
		System.out.println("\nDO YOU WANT TO RESTART THE PROGRAM ? (y/n)\n");
		choice = c.next().charAt(0); 
	}while(choice == 'Y' | choice == 'y');
}
}
