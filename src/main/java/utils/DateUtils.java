package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtils{

    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Date convertStringToDate(final String str) {
        try{
            return DATE_FORMAT.parse(str);
        } catch(Exception ex) {
            return null;
        }
    }

    public static String convertDateToString(final Date date) {
        try{
            return DATE_FORMAT.format(date);
        } catch(Exception ex) {
            return null;
        }
    }
    
    // Convert month's name to its number, that is, January to 1, February to 2, so on and so forth.
    public static int convertMonthNameToInt(final String monthName) {
    	Date date = null;
    	Calendar cal = null;
		try {
			date = new SimpleDateFormat("MMMM", Locale.ENGLISH).parse(monthName);
	    	cal = Calendar.getInstance();
	    	cal.setTime(date);
		} catch (ParseException e) {
			return -1;
		}
    	return cal.get(Calendar.MONTH);
    }
    
    public static int getMonth(final Date date) {
    	if(date == null) return -1;
    	Calendar calendar = new GregorianCalendar();
    	calendar.setTime(date);
    	return calendar.get(Calendar.MONTH) + 1;
    }
    
    public static int getYear(final Date date) {
    	if(date == null) return -1;
    	Calendar calendar = new GregorianCalendar();
    	calendar.setTime(date);
    	return calendar.get(Calendar.YEAR);
    }

	public static String getMonthYear(final Date date) {
		if(date == null) return "";
		// SimpleDateFormat is intended for give date's month a name.
		// MMM: if you want to abbreviate month's name.
		// MMMM: if you want the full month's name
		SimpleDateFormat monthName = new SimpleDateFormat("MMMM", Locale.ENGLISH);
		return monthName.format(date) + "/" + getYear(date);
	}
    
}
