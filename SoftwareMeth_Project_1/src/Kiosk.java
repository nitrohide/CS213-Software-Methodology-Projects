import java.util.Scanner;
import java.util.StringTokenizer;

 /**
 a
 */

public class Kiosk {
    final int STARTING_SERIAL = 10001;
    final int ADD_ARGS = 3;
    final int MOD_ARGS = 2;
    final int DISPLAY_ARGS = 1;
    public void run() {

        Library Library=new Library();
        System.out.println("Library Kiosk running");
        boolean kioskStatus=true;
        int serialNumber=STARTING_SERIAL;
        Scanner scanner=new Scanner(System.in);

        while (kioskStatus==true && scanner.hasNext()){
            String nextLine=scanner.nextLine();
            if (nextLine.equals("")){
                nextLine=" ";
            }
            StringTokenizer tokens=new StringTokenizer(nextLine,",");


            int numArgs= tokens.countTokens(); //use this later to maybe test invalid input
            String command = tokens.nextToken(); //the command flag, first parameter

            switch(command){
                case "Q":
                    kioskStatus=false;
                    break;

                case "A":
                    if (numArgs==ADD_ARGS){ //need all 3 arguments to add a book IS THIS A MAGIC NUMBER?
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
                    if (numArgs==MOD_ARGS){ //need 2 arguments to remove a book, (R,serialnumber) IS THIS A MAGIC NUMBER?
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
                    if (numArgs == MOD_ARGS) {
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
                    if (numArgs==MOD_ARGS){
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
                    if (numArgs==DISPLAY_ARGS){
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
                    if (numArgs==DISPLAY_ARGS){
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
                    if (numArgs==DISPLAY_ARGS){
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
                case " ":
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        }
        System.out.println("Kiosk session ended.");
    }
}

