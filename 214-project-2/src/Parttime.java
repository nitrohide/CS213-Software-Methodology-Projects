public class Parttime extends Employee{
    final int MAXIMUM_HOURS = 100;
    final int WEEKLY_MAX = 40;
    final double OVERTIME_RATE = 1.5;

    private int hoursWorked;
    private double hourlyRate;

    public Parttime(String name, String department, Date dateHired, double hourlyRate, int hoursWorked){
        super(name,department,dateHired);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public void calculatePayment() { }

    @Override
    public String toString() { }
    @Override
    public boolean equals(Object obj) { } //compare name, department and dateHired

}
