public class Company {
    private Employee[] emplist;
    private int numEmployee;

    public Company(){//constructor to create empty container for employee list
        emplist = new Employee[BAG_INITIAL_VALUE]; 
    }
    
    public static final int BAG_INITIAL_VALUE = 4;
    public static final int BAG_GROW_VALUE = 4;
    public static final int NOT_FOUND = -1;

    private int find(Employee employee) {
        
        for (int i = 0; i < emplist.length; i++){
            if (employee == emplist[i]){
                return i;
            }
        }
        return NOT_FOUND; //employee not found
    }

    private void grow() {
        
        Employee[] temp = new Employee[emplist.length + BAG_GROW_VALUE]; //temp to hold all books before copying into new bag

        for (int i = 0; i < numEmployee; i++){
            temp[i] = emplist[i];
        }
        emplist = temp;

    }
    
    public boolean add(Employee employee) {  //check the profile before adding
        
        if (emplist[emplist.length-1]!= null){
            grow();
        }
        for (int i = 0; i < emplist.length; i++ ){
            if (emplist[i] == null){
                emplist[i] = employee;
                numEmployee++;
                return true;
                
            }
        }
        return false; 
    }

    public boolean remove(Employee employee) {  
        
        int index_to_remove = find(employee);

        for ( int j = index_to_remove; j < emplist.length ; j++ ){//traverse through rest of list and shift to left
            if ( j == (emplist.length - 1) ){ //check if traversal reaches last index of list
                emplist[j] = null; //if last index of list, set to null in order to accomodate for removed employee
                numEmployee--;
                return true;
            }
            if ( emplist[j+1] == null){ //make last element in list null to accomodate for removed employee
                emplist[j] = null;
                numEmployee--;
                return true; 
            }
            emplist[j] = emplist[j + 1]; //set each element to value of next to preserve order of employees
        }
        return false; 

    }

    public boolean setHours(Employee employee) {  //set working hours for a part time
        
        for(int i = 0; i < emplist.length; i++){
             
            if (emplist[i].getProfile().equals(employee.getProfile()) ){
                if (emplist[i] instanceof Parttime && employee instanceof Parttime){
                emplist[i].setHoursWorked(employee.getHoursWorked());
                return true; 
                }
            }

        }
        return false; 
         
    }

    public void processPayments() { //process payments for all employees
        
        for(int i = 0; i < emplist.length; i++){    
            emplist[i].calculatePayment(); 
        }

    }
    
    public void print() {  //print earning statements for all employees 
        
        for(int i = 0; i < emplist.length; i++){
            if (emplist[i]!= null) {
                System.out.println(emplist[i].toString()); 
            }
        }
    }
    
    public void printByDepartment() { //print earning statements by department

        for( int i = 0; i < emplist.length; i++){
            if (emplist[i].getProfile().getDepartment() == "CS"){
                System.out.println(emplist[i].toString()); 
            }
        }

        for( int i = 0; i < emplist.length; i++){
            if (emplist[i].getProfile().getDepartment() == "ECE"){
                System.out.println(emplist[i].toString()); 
            }
        }

        for( int i = 0; i < emplist.length; i++){
            if (emplist[i].getProfile().getDepartment() == "IT"){
                System.out.println(emplist[i].toString()); 
            }
        }

    } 
    
    public void printByDate() {  //print earning statements by date hired 
        
        //Using a simple selection sort algorithm to sort employees by date in ascending order
        for (int i = 0; i < emplist.length-1; i++) {   //keep track of sorted part of bag
            int min_idx = i;
            for (int j = i + 1; j < emplist.length; j++) {
                if ( emplist[j] == null
                        || emplist[min_idx] == null) //if space in bag is empty, ignore and continue
                    continue;
                if (emplist[j].getProfile().getDateHired().getYear()
                        < emplist[min_idx].getProfile().getDateHired().getYear()){ //if year of index j is less than that of min_idx
                    min_idx = j;
                }
                if (emplist[j].getProfile().getDateHired().getYear()
                        == emplist[min_idx].getProfile().getDateHired().getYear()){ //if year of index j is equal to that of min_idx, check month
                    if ( emplist[j].getProfile().getDateHired().getMonth()
                            < emplist[min_idx].getProfile().getDateHired().getMonth()){ //continue to compare month values
                        min_idx = j;
                    }
                    if ( emplist[j].getProfile().getDateHired().getMonth()
                            == emplist[min_idx].getProfile().getDateHired().getMonth()){ //if months are equal, compare day
                        if ( emplist[j].getProfile().getDateHired().getDay()
                                < emplist[min_idx].getProfile().getDateHired().getDay()){ //compare day values
                            min_idx = j;
                        }
                    }
                }
            }
            //swapping the minimum element into the sorted region to complete iteration
            Employee temp = emplist[min_idx];
            emplist[min_idx] = emplist[i];
            emplist[i] = temp;
        }
        print(); //print the sorted bag

    }
    public Employee search(String name, String department, Date dateHired){
        Employee tempEmployee = new Employee(name,department,dateHired);
        int location = find(tempEmployee);
        if (location != NOT_FOUND){
            return emplist[location];
        }
        else{
            return null;
        }
    }

    public int getNumEmployee(){
        return numEmployee;
    }
    
}
