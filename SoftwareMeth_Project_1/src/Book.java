
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

    @Override
    public boolean equals(Object obj){ 
        
    }
    @Override
    public String toString() { 

    }
}
