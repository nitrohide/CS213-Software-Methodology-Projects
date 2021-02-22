public class Parttime extends Employee{
    final int MAXIMUM_HOURS = 100;
    final int WEEKLY_MAX = 40;
    final double OVERTIME_RATE = 1.5;

    private int hoursWorked;
    private double hourlyRate;

    public Parttime(String name, String department, Date dateHired, double hourlyRate){
        super(name,department,dateHired);
        this.hourlyRate = hourlyRate;
    }

}
