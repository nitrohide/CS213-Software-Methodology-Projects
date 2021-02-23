public class Fulltime extends Employee{
    private double yearlySalary;

    public Fulltime(String name, String department, Date dateHired, double yearlySalary){
        super(name,department,dateHired);
        this.yearlySalary = yearlySalary;
    }

    @Override
    public void calculatePayment() { }

    @Override
    public String toString() { }
    @Override
    public boolean equals(Object obj) { } //compare name, department and dateHired
}
