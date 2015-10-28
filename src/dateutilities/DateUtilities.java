package dateutilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Dan
 */
public class DateUtilities {
    
    private static LocalDateTime today;
    
    public DateUtilities(){
        if(today==null){
            today=LocalDateTime.now();
        }
    }
    
    /**
     * 
     * @return A String object of the date in the pattern of yyyy-MM-dd in accordance to the ISO_DATE
     */
    public String getCurrentDateToString(){
        return "Today is "+today.format(DateTimeFormatter.ISO_DATE);
    }
    
    public String parseDateToString(Date d){
        SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
        String returnDate=sdf.format(d);
        return returnDate;
    }
    
    /**
     * 
     * @param dtf is a DateTimeFormatter that you would want to use to format your date and time
     * @return A String object of the date and time formatted by the dtf argument 
     */
    public String getCurrentDateTimeToString(DateTimeFormatter dtf){
        return "Today is "+today.format(dtf);
    }
    
    /**
     * 
     * @param date Any formatted date object
     * @return a String object of the formatted date
     */
    public Date createDateTime(String date){
        SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
        Date d=null;
        try{
            d=sdf.parse(date);
        }catch(ParseException p){
            p.getErrorOffset();
        }
        return d;
    }
    
    public static void main(String[] args) {
        DateUtilities du = new DateUtilities();
        System.out.println(du.getCurrentDateToString());
        
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(du.getCurrentDateTimeToString(dtf));
        
        Date birthday=du.createDateTime("10/13/1994");
        
        System.out.println("My birthday is "+du.parseDateToString(birthday));
    }
}
