public class Fulltime extends Employee{
    private double yearlySalary;
    public static final int PAYPERIODS = 26;
    double compensation;

    public Fulltime(String name, String department, Date dateHired, double yearlySalary){
        super(name,department,dateHired);
        this.yearlySalary = yearlySalary;
        this.compensation = 0;
    }
    public void setCompensation(double compensation){
        this.compensation = compensation;
    }
    public double getCompensation(){
        return this.compensation;
    }

    @Override
    public void calculatePayment() {
        double payment = (this.yearlySalary / PAYPERIODS) + compensation ;
        super.setPayment(payment);
    }

    @Override
    public String toString() {
        String formattedSalary = String.format("%,.2f", this.yearlySalary);
        return super.toString() + "FULL TIME::Annual Salary $" + formattedSalary;
    }
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
