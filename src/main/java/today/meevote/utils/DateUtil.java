package today.meevote.utils;

import today.meevote.exception.rest.RestException;
import today.meevote.response.FailureInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";

    private static SimpleDateFormat getDateFormat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        dateFormat.setLenient(false);
        return dateFormat;
    }

    public static Date parseDate(String dateStr) {
        try {
            return getDateFormat().parse(dateStr);
        } catch (ParseException e) {
            throw new RestException(FailureInfo.INVALID_DATE_FORMAT);
        }
    }
    public static boolean validateDateOrder(String startDateStr, String endDateStr) {
        Date startDate = parseDate(startDateStr);
        Date endDate = parseDate(endDateStr);
        return startDate.before(endDate);
    }
}
