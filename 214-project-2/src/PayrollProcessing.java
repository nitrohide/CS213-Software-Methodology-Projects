/**
 * The PayrollProcessing class processes command lines from the console using Scanner and String Tokenizer class.
 * The user can interact with the Employee list from this class. 
 * @author Anuraj Dubey, Chenghao Lin
*/
import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.Exception;

public class PayrollProcessing {
    static final int DISPLAY_ARGS = 1;
    static final int NONMANAGEMENT_ARGS = 5;
    static final int MANAGEMENT_ARGS = 6;
    static final int REMOVE_ARGS = 4;
    static final String[] MANAGEMENT_CODES = {"1","2","3"};
    static final String[] DEPARTMENT_CODES = {"CS", "ECE", "IT"};
    static final int MINIMUM_SALARY = 0;
    static final int MINIMUM_HOURS = 0;
    static final int MAXIMUM_HOURS = 100;

    /**
     * Initiates and runs the interface as well as displays status messages as inputs are scanned. 
     */
    public void run(){
        Company Company = new Company();
        System.out.println("Payroll Processing starts.");
        boolean payrollStatus = true;
        String command;
        Scanner scanner = new Scanner(System.in);

        while (payrollStatus && scanner.hasNext()) {
            try {
                String nextLine = scanner.nextLine();
                if (nextLine.equals("")){                     //To prevent String Tokenizer class error
                    nextLine=" ";
                }

                StringTokenizer tokens = new StringTokenizer(nextLine, " ");

                int numArgs = tokens.countTokens();

                if(!nextLine.equals(" ")) {
                    command = tokens.nextToken();
                }else {
                    command = "";
                }

                String name;
                String department;
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
                            Employee temp = Company.search(name, department, date);

                            if (!isValidDept(department)) {
                                System.out.println("'" + department + "'" + " is not a valid department code.");
                            } else if (hourlyRate < MINIMUM_SALARY) {
                                System.out.println("Pay rate cannot be negative.");
                            } else if (!date.isValid()) {
                                System.out.println(date + " is not a valid date!");
                            } else if (temp != null) {
                                System.out.println("Employee is already in the list.");
                            } else {
                                Parttime newParttime = new Parttime(name, department, date, hourlyRate, MINIMUM_HOURS);
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
                            Employee temp = Company.search(name, department, date);

                            if (!isValidDept(department)) {
                                System.out.println("'" + department + "'" + " is not a valid department code.");
                            } else if (yearlySalary < MINIMUM_SALARY) {
                                System.out.println("Salary cannot be negative.");
                            } else if (!date.isValid()) {
                                System.out.println(date + " is not a valid date!");
                            } else if (temp != null) {
                                System.out.println("Employee is already in the list.");
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
                            Employee temp = Company.search(name, department, date);

                            if (!isValidDept(department)) {
                                System.out.println("'" + department + "'" + " is not a valid department code.");
                            } else if (yearlySalary < MINIMUM_SALARY) {
                                System.out.println("Salary cannot be negative.");
                            } else if (!date.isValid()) {
                                System.out.println(date + " is not a valid date!");
                            } else if (!isValidManager(role)) {
                                System.out.println("Invalid management code.");
                            } else if (temp != null) {
                                System.out.println("Employee is already in the list.");
                            } else {
                                Management Management = new Management(name, department, date, yearlySalary, Integer.parseInt(role));
                                Company.add(Management);
                                System.out.println("Employee added.");
                            }
                        } else {
                            System.out.println("Invalid Command!");
                        }
                        break;

                    case "R":
                        if (Company.getNumEmployee() == 0) {
                            System.out.println("Employee database is empty.");
                            break;
                        }
                        if (numArgs == REMOVE_ARGS) {
                            name = tokens.nextToken();
                            department = tokens.nextToken();
                            Date date = new Date(tokens.nextToken());

                            Employee removeEmployee = Company.search(name, department, date);
                            if (removeEmployee == null) {
                                System.out.println("Employee doesn't exist.");
                                break;
                            }
                            Company.remove(removeEmployee);
                            System.out.println("Employee removed.");
                        } else {
                            System.out.println("Invalid command!");
                        }
                        break;
                    case "C":
                        if (Company.getNumEmployee() == 0) {
                            System.out.println("Employee database is empty.");
                            break;
                        }
                        if (numArgs == DISPLAY_ARGS) {
                            Company.processPayments();
                            System.out.println("Calculation of employee payments is done");
                        } else {
                            System.out.println("Invalid command!");
                        }
                        break;
                    case "S":
                        if (Company.getNumEmployee() == 0) {
                            System.out.println("Employee database is empty.");
                            break;
                        }
                        if (numArgs == NONMANAGEMENT_ARGS) {
                            name = tokens.nextToken();
                            department = tokens.nextToken();
                            Date date = new Date(tokens.nextToken());
                            int hours = Integer.parseInt(tokens.nextToken());


                            if (hours < MINIMUM_HOURS) {
                                System.out.println("Working hours cannot be negative.");
                            } else if (hours > MAXIMUM_HOURS) {
                                System.out.println("Invalid Hours: over 100.");
                            } else {
                                Employee setEmployee = Company.search(name, department, date);
                                if (setEmployee == null) {
                                    System.out.println("Employee doesn't exist.");
                                } else if (!Company.setHours(setEmployee)) {
                                    System.out.println("Employee is not part-time");
                                } else {
                                    Parttime employee = (Parttime) setEmployee;
                                    employee.setHoursWorked(hours);
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
                            } else {
                                System.out.println("--Printing earning statements for all employees--");
                                Company.print();
                            }
                        } else {
                            System.out.println("Invalid command!");
                        }
                        break;

                    case "PH":
                        if (numArgs == DISPLAY_ARGS) {
                            if (Company.getNumEmployee() == 0) {
                                System.out.println("Employee database is empty.");
                            } else {
                                System.out.println("--Printing earning statements by date hired--");
                                Company.printByDate();
                            }
                        } else {
                            System.out.println("Invalid command!");
                        }
                        break;

                    case "PD":
                        if (numArgs == DISPLAY_ARGS) {
                            if (Company.getNumEmployee() == 0) {
                                System.out.println("Employee database is empty.");
                            } else {
                                System.out.println("--Printing earning statements by department--");
                                Company.printByDepartment();
                            }
                        } else {
                            System.out.println("Invalid command!");
                        }
                        break;

                    case "":
                        break;

                    default:
                        System.out.println("Command '" + command + "' not supported!");
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        System.out.println("Payroll Processing completed.");
    }

    /**
     * Method to check if an inputted department code is valid or not. 
     * @param department The department code inputted.
     * @return True if department is valid, and false if invalid. 
     */
    public boolean isValidDept(String department){
        int validCodes = DEPARTMENT_CODES.length;
        for (int i = 0;i < validCodes;i++){
            if (department.equals(DEPARTMENT_CODES[i])) {
                return true;
            }
        }
        return false;
    }

    /**
    * Method to check if a manager is valid or not based on a manager code. 
    * @param role The inputted manager code.
    * @return True if valid, and false if invalid. 
    */
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
