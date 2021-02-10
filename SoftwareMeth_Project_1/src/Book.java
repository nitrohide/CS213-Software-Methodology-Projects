/**
 * This class defines type Book, which encapsulates the data fields and methods of a book.
 * Each book has private variables number, name, checkedOut, and datePublished
 * Books are uniquely identified by their number
 * @author Anuraj Dubey, Chenghao Lin
 */
public class Book {
    private String number; //a 5-digit serial number unique to the book
    private String name;
    private boolean checkedOut;
    private Date datePublished;

    /**
     * Constructor for Book object which will always have a serial number, name, and publishing date, Books are not checked out by default.
     * @param number The unique Serial Number of the book
     * @param name   The title of the book
     * @param datePublished The publishing date of the book in MM/DD/YYYY format
     */
    public Book(String number, String name, Date datePublished) {
        this.number =  number;
        this.name = name;
        this.datePublished = datePublished;
        this.checkedOut = false;
    }


    //Getter methods
    public String getSerial() {
        return number;
    }
    public String getName() {
        return name;
    }
    public boolean getCheckedout() {
        return checkedOut;
    }
    public Date getDatePublished() {
        return datePublished;
    }

    //setter methods
    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    ////equals() method returns true if the serial numbers for the 2 book objects are the same.
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Book){
            Book otherBook=(Book) obj;
            boolean areEqual=otherBook.number.equals(this.number);
            return areEqual;
        } else {
            return false;
        }
    }

    //toString() method returns a textual representation of a book in the following format.
    @Override
    public String toString() {
        String dateStr=datePublished.toString();
        String checkedOut;
        if (this.checkedOut==true){
            checkedOut="is checked out.";
        }
        else{
            checkedOut="is available.";
        }
        return "Book#"+number+"::"+name+"::"+datePublished.getMonth()+"/"+datePublished.getDay()+"/"+datePublished.getYear()+"::"+checkedOut;
    }
}
