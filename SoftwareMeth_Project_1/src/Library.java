public class Library {
   
    private Book[] books; // array-based implementation of the bag data structure private int numBooks; // the number of books currently in the bag
    
    public Library() { //default constructor to create an empty bag
        books = new Book[4]; 
    }

    
    public static final int BAG_GROW_VALUE = 4;
    public static final int NOT_FOUND = -1;

    private int find(Book book) { // helper method to find a book in the bag 
        
        for (int i = 0; i < books.length; i++){
            if (book == books[i]){
                return i; 
            } 
        }
        return NOT_FOUND; //book not found 
    }
    
    private void grow() {  // helper method to grow the capacity by 4
        
        Book[] temp = new Book[books.length]; //temp to hold all books before copying into new bag
        for (int i = 0; i < books.length; i++){
            temp[i] = books[i];
        }
        Book[] books = new Book[temp.length + BAG_GROW_VALUE]; //new bag incremented by grow value of 4
        for (int j = 0; j < books.length; j++){
            books[j] = temp[j]; 
        }

    }
    

    public void add(Book book) { //adds book to end of array. If full, calls grow()
        
        for (int i = 0; i < books.length; i++ ){
            if (books[i] == null){
                books[i] = book; 
                break;
            } 
            if (i == (books.length-1)){ //if counter has reached end without finding open spot, grow and then add the book
                grow();
                books[i+1] = book; 
            }
            
        }
        
    }

    public boolean remove(Book book) { //also shifts and readjusts all interior elements after removal 

        
        int index_to_remove = find(book); 
        
        for (int j = index_to_remove; j < books.length; j++ ){//traverse through rest of bag and shift to left
            if (books[j+1] == null){ //make last element in list null to accomodate for removed book
                books[j] = null; 
                return true; //also display “Book# xyz removed.” 
            }
            books[j] = books[j+1]; //set each element to value of next to preserve order of books 
        }
        
        return false; //also display "Unable to remove, the library does not have this book." 
    }

    public boolean checkOut(Book book) {

        int index_to_find = find(book);

        if (index_to_find == NOT_FOUND) //if book is not owned return false
            return false; 
       
        if (!books[index_to_find].getCheckedout()){ //if not checked out, set checkedOut to true
            books[index_to_find].setCheckedOut(true); 
            return true; // return true if succesfully checked out
        }
        else if (books[index_to_find].getCheckedout()){ //if already checked out, return false 
            return false; // return false if already checked out 
        }
        
         return false; //return false if checkout failed for any other reason
    }

    public boolean returns(Book book) {

        int index_to_find = find(book);

        if (index_to_find == NOT_FOUND) //if book is not owned, return false
        return false; 
       
        if (books[index_to_find].getCheckedout()){ //if it is indeed checked out, check in and return true 
            books[index_to_find].setCheckedOut(false); 
            return true; // return true if succesfully returned
        }
        else if (!books[index_to_find].getCheckedout()){ //if book is not checked out, return false
            return false; // return false if not checked out 
        }
        
        return false; //return false if book return failed for any other reason
        

    }
    


    
    public void print() {  //print the list of books in the bag

        for(int i = 0; i < books.length; i++){
            System.out.println(books[i].getName());
        }

    }

    public void printByDate() { //print the list of books by datePublished (ascending) 



    } 
    
    
    public void printByNumber() { //print the list of books by number (ascending) }

        int[] snList = new int[books.length]; 

        //Adding all converted integer serial numbers to a new array
        for (int i = 0; i < books.length; i++){
            int SN = Integer.parseInt(books[i].getNumber()); 
            snList[i] = SN; 
        }


        //Using a simple selection sort algorithm to sort serial numbers in ascending order
        for (int i = 0; i < books.length-1; i++) 
        { 
            
            int min_idx = i; 
            for (int j = i + 1; j < books.length; j++) {
                if (snList[j] < snList[min_idx]) 
                    min_idx = j; 
            }
           
            int temp = snList[min_idx]; 
            snList[min_idx] = snList[i]; 
            snList[i] = temp; 
        } 
    } 
    
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
