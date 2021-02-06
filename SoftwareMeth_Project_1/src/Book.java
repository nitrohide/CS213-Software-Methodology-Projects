import java.util.Date;

public class Book {
    private String number; //a 5-digit serial number unique to the book
    private String name;
    private boolean checkedOut;
    private Date datePublished;
    

    //Getter methods
    public String getNumber() {
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


    //Setter methods
    public void setNumber(String newNumber) {
        this.number = newNumber; 
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }



    @Override
    public boolean equals(Object obj){ 
        
    }
    @Override
    public String toString() { 

    }
}
