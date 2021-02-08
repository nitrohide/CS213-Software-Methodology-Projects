import java.util.Scanner;
import java.util.StringTokenizer;

public class Kiosk {
    final int starting_serial=10001;
    public void run() {

        Library Library=new Library();
        System.out.println("Library Kiosk running");
        boolean kioskStatus=true;
        int serialNumber=starting_serial;
        Scanner scanner=new Scanner(System.in);

        while (kioskStatus==true && scanner.hasNext()){
            StringTokenizer tokens=new StringTokenizer(scanner.nextLine(),",");
            int numArgs= tokens.countTokens(); //use this later to maybe test invalid input
            String command = tokens.nextToken(); //the command flag, first parameter

            switch(command){
                case "Q":
                    kioskStatus=false;
                    break;

                case "A":
                    if (numArgs==3){ //need all 3 arguments to add a book IS THIS A MAGIC NUMBER?
                        String number=String.valueOf(serialNumber); //the next available serial number
                        String name=tokens.nextToken(); //name of book
                        String datePublished=tokens.nextToken(); //date published of book
                        Date date=new Date(datePublished); //need to create Date object to insert into book
                        if (date.isValid()) {
                            Book newBook = new Book(number, name, date ); //new book added
                            Library.add(newBook); //adding book to the library
                            System.out.println(name + " added to the Library");
                            serialNumber++; //increment serial number for next book
                        }
                        else{
                            System.out.println("Invalid Date!");
                        }
                    }
                    else{
                        System.out.println("Invalid command!");
                    }
                    break;
                case "R":
                    if (numArgs==2){ //need 2 arguments to remove a book, (R,serialnumber) IS THIS A MAGIC NUMBER?
                        String numberStr=tokens.nextToken();
                        int bookNumber=Integer.parseInt(numberStr);
                        Book Book= Library.search(bookNumber);
                        if(Book==null){
                            System.out.println("Unable to remove, the library does not have this book.");
                        }
                        else{
                            Library.remove(Book);
                            System.out.println("Book# " +numberStr+ " removed.");
                        }
                    }
                    else{
                        System.out.println("Invalid command!");
                    }
                    break;
                case "O":
                    if (numArgs == 2) {
                        String numberStr=tokens.nextToken();
                        int bookNumber=Integer.parseInt(numberStr);
                        Book Book= Library.search(bookNumber);
                        if (Book==null){
                            System.out.println("Book#"+numberStr+ " is not available.");
                        }
                        else{
                            //Library.remove(Book); //only checkout? or remove as well
                            Library.checkOut(Book);
                            System.out.println("You’ve checked out Book#"+numberStr+" Enjoy!.");
                        }
                    }
                    else{
                        System.out.println("Invalid command!");
                    }
                    break;
                case "I":
                    if (numArgs==2){
                        String numberStr=tokens.nextToken();
                        int bookNumber=Integer.parseInt(numberStr);
                        Book Book= Library.search(bookNumber);
                        if (Book==null){
                            System.out.println("Unable to return Book#"+numberStr+".");
                        }
                        else{
                            //Library.remove(Book); //only checkout? or remove as well
                            Library.returns(Book);
                            System.out.println("Book#"+numberStr+" return has completed. Thanks!.");
                        }
                    }
                    else{
                        System.out.println("Invalid command!");
                    }
                    break;
                case "PA":
                    if (numArgs==1){
                        if(Library.getNumBooks()==0){
                            System.out.println("Library catalog is empty!");
                        }
                        else{
                            System.out.println("**List of books in the library.");
                            Library.print();
                            System.out.println("**End of list");
                        }
                    }
                    else{
                        System.out.println("Invalid command!");
                    }
                    break;
                case "PD":
                    if (numArgs==1){
                        if(Library.getNumBooks()==0){
                            System.out.println("Library catalog is empty!");
                        }
                        else{
                            System.out.println("**List of books by the dates published.");
                            Library.printByDate();
                            System.out.println("**End of list");
                        }
                    }
                    else{
                        System.out.println("Invalid command!");
                    }
                    break;
                case "PN":
                    if (numArgs==1){
                        if(Library.getNumBooks()==0){
                            System.out.println("Library catalog is empty!");
                        }
                        else{
                            System.out.println("**List of books by the book numbers.");
                            Library.printByNumber();
                            System.out.println("**End of list");
                        }
                    }
                    else{
                        System.out.println("Invalid command!");
                    }
                    break;
            }
        }
        System.out.println("Kiosk session ended.");
    }
}

