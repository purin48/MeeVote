package today.meevote.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static final long MILLISECONDS_PER_DAY = 24 * 60 * 60 * 1000;

    public static Date parseDate(String dateStr) {
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    public static boolean validateDateOrder(String startDateStr, String endDateStr) {
        Date startDate = parseDate(startDateStr);
        Date endDate = parseDate(endDateStr);
        if (startDate == null || endDate == null) {
            return false;
        }
        return startDate.before(endDate);
    }
    
    public static int calculateDuration(String startDateStr, String endDateStr) {
        Date startDate = parseDate(startDateStr);
        Date endDate = parseDate(endDateStr);

        long diffMillies = endDate.getTime() - startDate.getTime();
        return (int) (diffMillies / MILLISECONDS_PER_DAY);
    }
}
