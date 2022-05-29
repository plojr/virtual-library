package utils;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateConverter{

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
}
