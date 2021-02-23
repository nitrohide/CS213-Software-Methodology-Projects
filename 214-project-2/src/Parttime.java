public class Parttime extends Employee{
    final int MAXIMUM_HOURS = 100;
    final int PAY_PERIOD_MAX = 80;
    final double OVERTIME_RATE = 1.5;

    private int hoursWorked;
    private double hourlyRate;

    public Parttime(String name, String department, Date dateHired, double hourlyRate, int hoursWorked){
        super(name,department,dateHired);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public void calculatePayment() {
        double payment;
        if (this.hoursWorked <= PAY_PERIOD_MAX) {  //if hoursworked did not exceed normal hours
            payment = this.hourlyRate * this.hoursWorked;
        }
        else {
            int overtimeHours = MAXIMUM_HOURS - this.hoursWorked;
            payment = (this.hourlyRate * PAY_PERIOD_MAX) + (overtimeHours * OVERTIME_RATE * this.hourlyRate);
        }
        super.setPayment(payment);
    }

    @Override
    public String toString() { }
    @Override
    public boolean equals(Object obj) { 

        if (obj instanceof Employee){
            Parttime otherParttime = (Parttime) obj;
            if (!(otherParttime.hoursWorked == this.hoursWorked)){
                return false; 
            }
            if (!(otherParttime.hourlyRate == this.hourlyRate)) {
                return false; 
            }
            
        }
        return true; 
    } 

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

}
