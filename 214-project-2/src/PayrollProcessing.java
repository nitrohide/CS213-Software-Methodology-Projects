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
                    if (numArgs == DISPLAY_ARGS)  {
                        payrollStatus = false;
                        break;
                    }
                    else{
                        System.out.println( "Invalid command!");
                    }

                case "AP":
                    if (numArgs == NONMANAGEMENT_ARGS){
                        name = tokens.nextToken();
                        department = tokens.nextToken();
                        dateHired = tokens.nextToken();
                        salary = tokens.nextToken();
                        Date date = new Date(dateHired);
                        double hourlyRate = Double.parseDouble(salary);

                        if (!isValidDept(department)){
                            System.out.println("'" + department + "'" + " is not a valid department code.");
                        }
                        else if (hourlyRate < MINIMUM_SALARY){
                            System.out.println("Pay rate cannot be negative.");
                        }
                        else if (!date.isValid()){
                            System.out.println("Invalid Date!");
                        }
                        else {
                            Parttime newParttime = new Parttime(name, department, date, hourlyRate);
                            Company.add(newParttime);
                            System.out.println("Employee added.");
                        }
                    }
                    else{
                        System.out.println("Invalid Command!");
                    }
                    break;
                case "AF":


            }


        }

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
