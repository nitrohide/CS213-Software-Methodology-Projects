
public class Book {
    private String number; //a 5-digit serial number unique to the book
    private String name;
    private boolean checkedOut;
    private Date datePublished;

    public Book(String number, String name, Date datePublished){
        this.number=number;
        this.name=name;
        this.datePublished=datePublished;
        this.checkedOut=false;
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
            checkedOut="is not available";
        }
        else{
            checkedOut="is available";
        }
        return "Book#"+number+"::"+name+"::"+datePublished.getMonth()+"/"+datePublished.getDay()+"/"+datePublished.getYear()+"::"+checkedOut;
    }
}
