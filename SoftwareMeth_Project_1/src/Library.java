public class Library {
    private Book[] books; // array-based implementation of the bag data structure private int numBooks; // the number of books currently in the bag
    private int numBooks;

    public Library() { //default constructor to create an empty bag
        numBooks=0;
        books=new Book[4];

    }
    private int find(Book book) {// helper method to find a book in the bag private void grow() { } // helper method to grow the capacity by 4

    }
    public void add(Book book) {

    }
    public boolean remove(Book book) {

    }
    public boolean checkOut(Book book) {

    }
    public boolean returns(Book book) {

    }
    public void print() {  //print the list of books in the bag

    }
    public void printByDate() {

    } //print the list of books by datePublished (ascending) public void printByNumber() { } //print the list of books by number (ascending) }
    public Book search(int number){
        for(int i=0;i<numBooks;i++){
            if(books[i].getSerial()==number){
                return books[i];
            }
        }
        return null;
    }

    public int getNumBooks(){
        return numBooks;
    }
}
