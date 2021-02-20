import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.Exception;

public class PayrollProcessing {

    public void run(){
        Company company = new Company();
        System.out.println("Payroll Processing starts.");
        boolean payrollStatus = true;
        Scanner scanner = new Scanner(System.in);
        while (payrollStatus && scanner.hasNext()){
            String nextLine = scanner.nextLine();
            if (nextLine.equals("")){
                nextLine=" ";
            }
            StringTokenizer tokens = new
        }

    }
}
