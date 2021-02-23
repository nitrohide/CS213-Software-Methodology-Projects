public class Fulltime extends Employee{
    private double yearlySalary;
    public static final int PAYPERIODS = 26;

    public Fulltime(String name, String department, Date dateHired, double yearlySalary){
        super(name,department,dateHired);
        this.yearlySalary = yearlySalary;
    }

    @Override
    public void calculatePayment() {
        double payment = this.yearlySalary / PAYPERIODS;
        super.setPayment(payment);
    }

    @Override
    public String toString() { }
    @Override
    public boolean equals(Object obj) { 

        if (obj instanceof Employee){
            Fulltime otherFulltime = (Fulltime) obj;
            if (!(otherFulltime.yearlySalary == this.yearlySalary)){
                return false; 
            }
        }
        return true; 
    } 

    public double getSalary(){
        return yearlySalary;
    }
}
