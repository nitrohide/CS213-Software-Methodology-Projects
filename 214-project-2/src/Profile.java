public class Profile {
    private String name; //employee’s name in the form “lastname,firstname”
    private String department; //department code: CS, ECE, IT
    private Date dateHired;


    public Profile(String name, String department, Date dateHired){
        this.name = name;
        this.department = department;
        this.dateHired = dateHired;
    }

    public String getDepartment(){
        return department; 
    }
    public Date getDateHired(){
        return dateHired; 
    }

    @Override
    public String toString() { }
    @Override
    public boolean equals(Object obj) {  //compare name, department and dateHired
        
        if (obj instanceof Profile){
            Profile otherProfile = (Profile) obj; 
            if (!otherProfile.name.equals(this.name)){
                return false;
            }
            if (!otherProfile.department.equals(this.department)){
                return false;
            }
            if (!otherProfile.dateHired.equals(this.dateHired)){
                return false;
            }
        }
        return true; 
    }
}
