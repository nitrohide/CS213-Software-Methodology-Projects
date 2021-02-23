public class Employee {

    private Profile profile;
    private int hoursWorked;
    private double payment;

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

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getPayment(){
        return payment;
    }

    public void calculatePayment() { }  //to be inherited by Fulltime/Parttime/Management


    @Override
    public String toString() {
        String payment = String.format("%,.2f", this.getPayment());
        return profile.toString() + "::Payment $" + payment + "::";
    }
    
    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Employee){
            Employee otherEmployee = (Employee) obj;
            if (!otherEmployee.profile.equals(this.profile)){
                return false; 
            }
            if (!(otherEmployee.hoursWorked == this.hoursWorked)) {
                return false; 
            }
            if (!(otherEmployee.payment == this.payment)){
                return false; 
            }
            
        }
        return true; 
    } 
}
