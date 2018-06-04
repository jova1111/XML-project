package com.otkudznam.booking.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static int MONTH_IN_SECONDS = 2678400;
    public static long MONTH_IN_MILLISECONDS = 2678400 * 1000;

    public static Date getDateFromNow(int period) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.SECOND, period);
        return calendar.getTime();
    }
}
