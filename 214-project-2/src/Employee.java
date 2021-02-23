public class Employee {
    
    private Profile profile;
    private int hoursWorked;

    public Employee(String name, String department, Date dateHired){
        profile = new Profile(name,department,dateHired);
        

    }

    public Profile getProfile(){
        return profile; 
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked){
        this.hoursWorked = hoursWorked; 
    }


    
}
