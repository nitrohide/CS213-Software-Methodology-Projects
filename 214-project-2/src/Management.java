public class Management extends Fulltime{
    int role;
    String role_name;
    final static int MANAGER = 1;
    final static double MANAGER_COMPENSATION = 5000;
    final static int DEPARTMENT_HEAD = 2;
    final static double DEPARTMENT_HEAD_COMPENSATION = 9500;
    final static int DIRECTOR= 3;
    final static double DIRECTOR_COMPENSATION = 12000;

    public Management(String name, String department, Date dateHired, double yearlySalary, int role){
        super(name,department,dateHired, yearlySalary);
        this.role = role;
    }

    @Override
    public void calculatePayment() {
        int compensation;
        double payment = getSalary()/26;
        if (this.role == MANAGER){
            payment = MANAGER_COMPENSATION + payment;
            role_name = "Manager";
        }
        else if (this.role == DEPARTMENT_HEAD){
            payment = DEPARTMENT_HEAD_COMPENSATION + payment;
            role_name = "Department Head";
        }
        else if (this.role == DIRECTOR){
            payment = DIRECTOR_COMPENSATION + payment;
            role_name = "Director";
        }
        super.setPayment(payment);
    }

    @Override
    public String toString() { }
    @Override
    public boolean equals(Object obj) {  
    
        if (obj instanceof Management){
            Management otherManagement = (Management) obj;
            if (!(otherManagement.role == this.role)){
                return false; 
            }
            if (!(otherManagement.role_name == this.role_name)) {
                return false; 
            }
            
        }
        return true; 
    }
}
