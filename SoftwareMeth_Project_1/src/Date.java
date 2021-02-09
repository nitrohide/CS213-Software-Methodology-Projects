import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.Scanner;


public class Date {
    
    private int year;
    private int month;
    private int day;

    //all constant variables
    public static final int JANUARY = 1;
    public static final int FEBRUARY = 2;
    public static final int MARCH = 3;
    public static final int APRIL = 4;
    public static final int MAY = 5;
    public static final int JUNE = 6;
    public static final int JULY = 7;
    public static final int AUGUST = 8;
    public static final int SEPTEMBER = 9;
    public static final int OCTOBER = 10;
    public static final int NOVEMBER = 11;
    public static final int DECEMBER = 12;
    public static final int CURRENT_YEAR = 2021;
    public static final int YEAR_1900 = 1900;
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUARTERCENTENNIAL = 400;
    public static final int LEAP_DAY = 29;
    public static final int DAY_30 = 30;
    public static final int DAY_31 = 31;
 

    
    public Date(String date) {  //taking mm/dd/yyyy and create a Date object
        
        StringTokenizer str = new StringTokenizer(date,"/", false);  //create StringTokenizer object

        this.month = Integer.parseInt(str.nextToken()); 
        this.day = Integer.parseInt(str.nextToken()); 
        this.year = Integer.parseInt(str.nextToken()); 

    }

    public Date() {  //create an object with today’s date (see Calendar class)

        Calendar currDate = Calendar.getInstance(); 
        
        this.day = currDate.get(Calendar.DAY_OF_MONTH);  
        this.year = currDate.get(Calendar.YEAR);  
        this.month = currDate.get(Calendar.MONTH) + 1;   // IS THIS MAGIC NUMBER???

        
    }


    //getter methods
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    public int getYear(){
        return year; 
    }



    public boolean isValid() { 

        Calendar currDate = Calendar.getInstance();

        if (this.year <= 0 || this.day <= 0 || this.month < 0) //check if day, month, year is a negative value (or 0 for day & year)
            return false; 
        
        if ( this.year < YEAR_1900 || this.year > CURRENT_YEAR) 
            return false;
        if ( this.year == CURRENT_YEAR){ //if year value is of our current year 
            if (this.month > (currDate.get(Calendar.MONTH) + 1)){ //if month value exceeds current month, invalid date
                return false; 
            }
            if (this.month == (currDate.get(Calendar.MONTH) + 1)){ //if month value is current month 
                if (this.day > currDate.get(Calendar.DAY_OF_MONTH)) //if day value is greater than current day, invalid date
                    return false; 
                
            }
        }
        
        
        
        if (this.month == JANUARY && this.day > DAY_31) //check if day in January is invalid
            return false; 

        if ( this.month == FEBRUARY){
            if (this.day > LEAP_DAY) return false; //if day in February is more than 29, return false
            
            if (this.day == LEAP_DAY){
                if (!(this.year%QUADRENNIAL == 0)) //if year is not divisible by 4, return false
                    return false; 
                else if (this.year%CENTENNIAL == 0){ //if year is divisible by 4 and divisible by 100... 
                    if (!(this.year%QUARTERCENTENNIAL == 0)) //if year is divisible by 4 and 100, but not 400, return false
                        return false; 
                }                  
            }   
        }

        if (this.month == MARCH && this.day > DAY_31) //check if day in March is invalid
            return false; 

        if (this.month == APRIL && this.day > DAY_30) //check if day in April is invalid
            return false; 

        if (this.month == MAY && this.day > DAY_31) //check if day in May is invalid
            return false; 

        if (this.month == JUNE && this.day > DAY_30) //check if day in June is invalid
            return false; 

        if (this.month == JULY && this.day > DAY_31) //check if day in July is invalid
            return false; 

        if (this.month == AUGUST && this.day > DAY_31) //check if day in August is invalid
            return false; 

        if (this.month == SEPTEMBER && this.day > DAY_30) //check if day in September is invalid
            return false; 

        if (this.month == OCTOBER && this.day > DAY_31) //check if day in October is invalid
            return false; 

        if (this.month == NOVEMBER && this.day > DAY_30) //check if day in November is invalid
            return false; 
        
        if (this.month == DECEMBER && this.day > DAY_31) //check if day in December is invalid
            return false; 

        return true; //if all conditions are passed, date is valid
    }   

    

}
