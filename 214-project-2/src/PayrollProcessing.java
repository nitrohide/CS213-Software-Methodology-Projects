import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.Exception;

public class PayrollProcessing {
    static final int DISPLAY_ARGS = 1;
    static final int NONMANAGEMENT_ARGS = 5;
    static final int MANAGEMENT_ARGS = 6;
    static final int REMOVE_ARGS = 4;
    static final int[] MANAGEMENT_CODES = {1,2,3};
    static final String[] DEPARTMENT_CODES = {"CS", "ECE", "IT"};
    static final int MINIMUM_SALARY = 0;
    static final int MINIMUM_HOURS = 0;
    static final int MAXIMUM_HOURS = 100;

    public void run(){
        Company Company = new Company();
        System.out.println("Payroll Processing starts.");
        boolean payrollStatus = true;
        Scanner scanner = new Scanner(System.in);

        while (payrollStatus && scanner.hasNext()){
            String nextLine = scanner.nextLine();
            if (nextLine.equals("")){
                nextLine=" ";
            }
            StringTokenizer tokens = new StringTokenizer(nextLine, " ");

            int numArgs = tokens.countTokens();
            String command = tokens.nextToken();

            String name;
            String department;
            String dateHired;
            String salary;
            String role;



            switch (command) {
                case "Q":
                    if (numArgs == DISPLAY_ARGS) {
                        payrollStatus = false;
                        break;
                    } else {
                        System.out.println("Invalid command!");
                    }

                case "AP":    //add a part-time employee
                    if (numArgs == NONMANAGEMENT_ARGS) {
                        name = tokens.nextToken();
                        department = tokens.nextToken();
                        Date date = new Date(tokens.nextToken());
                        double hourlyRate = Double.parseDouble(tokens.nextToken());

                        if (!isValidDept(department)) {
                            System.out.println("'" + department + "'" + " is not a valid department code.");
                        } else if (hourlyRate < MINIMUM_SALARY) {
                            System.out.println("Pay rate cannot be negative.");
                        } else if (!date.isValid()) {
                            System.out.println("Invalid Date!");
                        } else {
                            Parttime newParttime = new Parttime(name, department, date, hourlyRate);
                            Company.add(newParttime);
                            System.out.println("Employee added.");
                        }
                    } else {
                        System.out.println("Invalid Command!");
                    }
                    break;

                case "AF":  //add a full-time employee
                    if (numArgs == NONMANAGEMENT_ARGS) {
                        name = tokens.nextToken();
                        department = tokens.nextToken();
                        Date date = new Date(tokens.nextToken());
                        double yearlySalary = Double.parseDouble(tokens.nextToken());

                        if (!isValidDept(department)) {
                            System.out.println("'" + department + "'" + " is not a valid department code.");
                        } else if (yearlySalary < MINIMUM_SALARY) {
                            System.out.println("Salary cannot be negative.");
                        } else if (!date.isValid()) {
                            System.out.println("Invalid Date!");
                        } else {
                            Fulltime newFulltime = new Fulltime(name, department, date, yearlySalary);
                            Company.add(newFulltime);
                            System.out.println("Employee added.");
                        }
                    } else {
                        System.out.println("Invalid Command!");
                    }
                    break;

                case "AM":   //add a management employee
                    if (numArgs == MANAGEMENT_ARGS) {
                        name = tokens.nextToken();
                        department = tokens.nextToken();
                        Date date = new Date(tokens.nextToken());
                        double yearlySalary = Double.parseDouble(tokens.nextToken());
                        role = tokens.nextToken();

                        if (!isValidDept(department)) {
                            System.out.println("'" + department + "'" + " is not a valid department code.");
                        } else if (yearlySalary < MINIMUM_SALARY) {
                            System.out.println("Salary cannot be negative.");
                        } else if (!date.isValid()) {
                            System.out.println("Invalid Date!");
                        } else if (!isValidManager(role)) {
                            System.out.println("Invalid management code.");
                        } else {
                            Fulltime newFulltime = new Fulltime(name, department, date, yearlySalary);
                            Company.add(newFulltime);
                            System.out.println("Employee added.");
                        }
                    } else {
                        System.out.println("Invalid Command!");
                    }

                case "R":
                    if (numArgs == REMOVE_ARGS) {
                        name = tokens.nextToken();
                        department = tokens.nextToken();
                        Date date = new Date(tokens.nextToken());

                        Employee removeEmployee = new Employee(name, department, date);
                        boolean isRemoved = Company.remove(removeEmployee);

                        if (!isRemoved) {
                            System.out.println("Employee doesn't exist.");
                        } else {
                            System.out.println("Employee removed.");
                        }
                    } else {
                        System.out.println("Invalid command!");
                    }
                    break;
                case "C":
                    if (numArgs == DISPLAY_ARGS) {
                        System.out.println("Calculation of employee payments is done");
                        Company.processPayments();
                    } else {
                        System.out.println("Invalid command!");
                    }
                    break;
                case "S":
                    if (numArgs == NONMANAGEMENT_ARGS) {
                        name = tokens.nextToken();
                        department = tokens.nextToken();
                        Date date = new Date(tokens.nextToken());
                        int Hours = Integer.parseInt(tokens.nextToken());

                        if (Hours < MINIMUM_HOURS) {
                            System.out.println("Working hours cannot be negative.");
                        }
                        if (Hours > MAXIMUM_HOURS) {
                            System.out.println("Invalid Hours: over 100.");
                        } else {
                            Employee setEmployee = Company.search(name, department, date);
                            if (setEmployee == null) {
                                System.out.println("Employee doesn't exist.");
                            } else if (!Company.setHours(setEmployee)) {
                                System.out.println("Employee is not part-time");
                            } else {
                                Company.setHours(setEmployee); //DOES THIS SET HOURS?
                                System.out.println("Working hours set.");
                            }
                        }
                    } else {
                        System.out.println("Invalid command!");
                    }
                    break;

                case "PA":
                    if (numArgs == DISPLAY_ARGS) {
                        if (Company.getNumEmployee() == 0) {
                            System.out.println("Employee database is empty.");
                        }
                        else{
                            System.out.println("--Printing earning statements for all employees--");
                            Company.print();
                        }
                    }
                    else{
                        System.out.println("Invalid command!");
                    }
                    break;

                case "PH":
                    if (numArgs == DISPLAY_ARGS) {
                        if (Company.getNumEmployee() == 0) {
                            System.out.println("Employee database is empty.");
                        }
                        else{
                            System.out.println("--Printing earning statements for all employees--");
                            Company.printByDate();
                        }
                    }
                    else{
                        System.out.println("Invalid command!");
                    }
                    break;

                case "PD":
                    if (numArgs == DISPLAY_ARGS) {
                        if (Company.getNumEmployee() == 0) {
                            System.out.println("Employee database is empty.");
                        }
                        else{
                            System.out.println("--Printing earning statements for all employees--");
                            Company.printByDepartment();
                        }
                    }
                    else{
                        System.out.println("Invalid command!");
                    }
                    break;

                case "":
                    break;

                default:
                    System.out.println("Command " + command + " not supported!");
            }
        }
        System.out.println("Payroll Processing completed.");
    }

    public boolean isValidDept(String department){
        int validCodes = DEPARTMENT_CODES.length;
        for (int i = 0;i < validCodes;i++){
            if (department.equals(DEPARTMENT_CODES[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidManager(String role){
        int validCodes = MANAGEMENT_CODES.length;
        for (int i = 0;i < validCodes;i++){
            if (role.equals(MANAGEMENT_CODES[i])) {
                return true;
            }
        }
        return false;
    }
}
