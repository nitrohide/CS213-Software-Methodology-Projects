public class Fulltime extends Employee{
    private double yearlySalary;

    public Fulltime(String name, String department, Date dateHired, double yearlySalary){
        super(name,department,dateHired);
        this.yearlySalary = yearlySalary;
    }
}
