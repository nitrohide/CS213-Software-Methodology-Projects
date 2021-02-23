public class Employee {
    private Profile profile;

    public Employee(String name, String department, Date dateHired){
        profile = new Profile(name,department,dateHired);

    }
    @Override
    public String toString() { }
    @Override
    public boolean equals(Object obj) { } //compare name, department and dateHired
}
