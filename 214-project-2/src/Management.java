public class Management extends Fulltime{
    int role;
    double compensation;
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

        double payment = getSalary()/26;
        if (this.role == MANAGER){
            payment = MANAGER_COMPENSATION + payment;
            this.role_name = "Manager";
            this.compensation = MANAGER_COMPENSATION/PAYPERIODS;
        }
        else if (this.role == DEPARTMENT_HEAD){
            payment = DEPARTMENT_HEAD_COMPENSATION + payment;
            this.role_name = "Department Head";
            this.compensation = DEPARTMENT_HEAD_COMPENSATION/PAYPERIODS;
        }
        else if (this.role == DIRECTOR){
            payment = DIRECTOR_COMPENSATION + payment;
            this.role_name = "Director";
            this.compensation = DIRECTOR_COMPENSATION/PAYPERIODS;
        }
        super.setPayment(payment);
    }

    @Override
    public void calculatePayment() {
        super.calculatePayment();
    }

    @Override
    public String toString() {
        String formattedCompensation = String.format("%,.2f", this.compensation);
        return super.toString() + "::" + this.role_name + " Compensation $"
                + formattedCompensation;
    }
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
