package fr.amrane.amranetest.utils;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Created by aaitzeouay on 01/03/2017.
 */

public class DateUrils {
    private static final int ONE_SEC_MS = 1000;
    private static final int ONE_MIN_MS = 60 * ONE_SEC_MS;
    private static final int ONE_HOUR_MS = 60 * ONE_MIN_MS;

    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    //"yyyy-MM-dd'T'hh:mm:ssZ"
    //yyyy-MM-dd'T'HH:mm:ss.sss+0000
    //2015-01-11T00:00:13.530+0200
    //yyyy-MM-dd'T'HH:mm:ss.SSSZ
    public static final String SERVER_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    public static Date parseDate(String dateStr) {
        if (TextUtils.isEmpty(dateStr)) {
            return null;
        }
        SimpleDateFormat serverDateFormat = new SimpleDateFormat(SERVER_DATE_FORMAT);
        try {
            return serverDateFormat.parse(dateStr);
        } catch (Exception e) {
            Log.e("Update Parse Exeption", e.getMessage());
        }
        return null;
    }

    public static String formatDate(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat serverDateFormat = new SimpleDateFormat(SERVER_DATE_FORMAT);
        return serverDateFormat.format(date);
    }

    public static String formatNow() {
        return formatDate(new Date(System.currentTimeMillis()));
    }

    public static String formatDateForDisplay(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(getShortLocaleDatePattern());
        return dateFormat.format(date);
    }

    public static int getDaysBetweenDates(Date date1, Date date2) {
        return (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24L));
    }

    public static long delata(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            throw new IllegalArgumentException("Both params should not be null");
        }

        long l1 = d1.getTime();
        long l2 = d2.getTime();
        return l1 > l2 ? l1 - l2 : l2 - l1;
    }

    public static Date getStartOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        final int[] fields = {Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND};
        for (int field : fields) {
            calendar.clear(field);
        }

        return calendar.getTime();
    }

    public static Date getStartOfCurrentDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        final int[] fields = {Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND};
        for (int field : fields) {
            calendar.clear(field);
        }
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
        return calendar.getTime();
    }

    public static Date getStartOfPreviousDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);

        final int[] fields = {Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND};
        for (int field : fields) {
            calendar.clear(field);
        }

        return calendar.getTime();
    }

    public static Date getStartOfNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, +1);

        final int[] fields = {Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND};
        for (int field : fields) {
            calendar.clear(field);
        }

        return calendar.getTime();
    }

    public static Date addDaysAndClearUnusedFields(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);

        final int[] fields = {Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND};
        for (int field : fields) {
            calendar.clear(field);
        }

        return calendar.getTime();
    }

    public static Date setHour(Date date, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        final int[] fields = {Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND};
        for (int field : fields) {
            calendar.clear(field);
        }

        calendar.set(Calendar.HOUR_OF_DAY, hour);
        return calendar.getTime();
    }

    public static Date getEndOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        final int[] fields = {Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND};
        for (int field : fields) {
            calendar.clear(field);
        }
        calendar.set(Calendar.HOUR_OF_DAY, 24);

        return calendar.getTime();
    }

    public static long getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public static boolean isToday(Date d) {
        Calendar c = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c2.setTime(d);
        return c.get(Calendar.MONTH) == c2.get(Calendar.MONTH) && c.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && c.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH);
    }

    public static int getCurrentHour() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.HOUR_OF_DAY);
    }

    public static String getOficialDateFormat(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(getLocaleTimeAndDatePattern());
        return dateFormat.format(date).replace("AM", "am").replace("PM", "pm");
    }

    public static String getOficialDateFormatWithLocale(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(getLocaleTimeAndDatePattern(), Locale.getDefault());
        return dateFormat.format(date).replace("AM", "am").replace("PM", "pm");
    }

    public static final String getDateFormatOficial() {
        return getLocaleTimeAndDatePattern();
    }

    /**
     * @param aDuration in ms
     * @return duration formater  like 12h 30 min 2 s
     */
    public static String getDurationFormatedFromMs(int aDuration) {
        int hours = 0, minutes = 0, seconds = 0;

        hours = aDuration / ONE_HOUR_MS;
        minutes = (aDuration - hours * ONE_HOUR_MS) / ONE_MIN_MS;
        seconds = (aDuration - (hours * ONE_HOUR_MS + minutes * ONE_MIN_MS)) / ONE_SEC_MS;

        return getFormatTimePartsAppearNonZero(hours, minutes, seconds);
    }

    private static String getFormatTimePartsAppearNonZero(int hours, int min, int sec) {
        StringBuilder formatDurationBuilder = new StringBuilder();
        if (hours > 0) {
            formatDurationBuilder.append(String.format("%dh ", hours));
        }
        if (min > 0) {
            formatDurationBuilder.append(String.format("%dmin ", min));
        }
        if (sec > 0) {
            formatDurationBuilder.append(String.format("%ds ", sec));
        }

        return formatDurationBuilder.toString();
    }

    public static int getHoursBetween(Date d1, Date d2) {
        if (d1.getTime() < d2.getTime()) {
            Date aux = new Date(d1.getTime());
            d1 = d2;
            d2 = aux;
        }
        long secondsBetween = (d1.getTime() - d2.getTime()) / 1000;
        int hoursBetween = (int) (secondsBetween / 3600);
        return hoursBetween;
    }

    /*public static String getDurationStringFromMillis(Context context, long durationMillis) {
        String unitString = context.getString(R.string.unit_sec);
        if (durationMillis < 1) {
            return "00 " + unitString;
        }
        StringBuilder sb = new StringBuilder();
        long seconds = (durationMillis / 1000) % 60;
        sb.append(String.format(Locale.getDefault(), "%02d", seconds));
        long minutes = (durationMillis / (1000 * 60)) % 60;
        if (minutes > 0) {
            unitString = context.getString(R.string.unit_min);
            sb.insert(0, String.format(Locale.getDefault(), "%02d", minutes) + ":");
        }
        long hours = (durationMillis / (1000 * 60 * 60)) % 24;
        if (hours > 0) {
            unitString = context.getString(R.string.unit_hr);
            sb.insert(0, String.format(Locale.getDefault(), "%02d", hours) + ":");
        }
        sb.append(" ").append(unitString);
        return sb.toString();
    }*/

    public static String getDurationString(Context context, long durationMillis) {
        if (durationMillis < 1) {
            return "00:00";
        }
        StringBuilder sb = new StringBuilder();
        long seconds = (durationMillis / 1000) % 60;
        sb.append(String.format(Locale.getDefault(), "%02d", seconds));
        long minutes = (durationMillis / (1000 * 60)) % 60;
        if (minutes > 0) {
            sb.insert(0, String.format(Locale.getDefault(), "%02d", minutes) + ":");
        }
        long hours = (durationMillis / (1000 * 60 * 60)) % 24;
        if (hours > 0) {
            sb.insert(0, String.format(Locale.getDefault(), "%02d", hours) + ":");
        }

        if (sb.length() == 2)
            return "00:" + sb.toString();
        return sb.toString();
    }

    public static String getDurationHhMmString(Context context, long durationMillis) {
        if (durationMillis < 1) {
            return "0h00";
        }
        StringBuilder sb = new StringBuilder();
        long minutes = (durationMillis / (1000 * 60)) % 60;
        if (minutes > 0) {
            sb.insert(0, String.format(Locale.getDefault(), "%02d", minutes) + "");
        }
        long hours = (durationMillis / (1000 * 60 * 60)) % 24;
        if (hours > 0) {
            sb.insert(0, String.format(Locale.getDefault(), "%02d", hours) + "h");
        }

        if (sb.length() == 2)
            return "0h" + sb.toString();
        return sb.toString();
    }

    /*public static String getDurationHMinString(Context context, long durationMillis) {
        if (durationMillis < 1) {
            return "0" + context.getString(R.string.mycoach_minutes);
        }
        StringBuilder sb = new StringBuilder();
        long minutes = (durationMillis / (1000 * 60)) % 60;
        if (minutes > 0) {
            sb.insert(0, String.format(Locale.getDefault(), "%02d", minutes) + context.getString(R.string.mycoach_minutes));
        }
        long hours = (durationMillis / (1000 * 60 * 60)) % 24;
        if (hours > 0) {
            sb.insert(0, String.format(Locale.getDefault(), "%02d", hours) + context.getString(R.string.mycoach_hours));
        }

        if (sb.length() == 2) {
            return sb.toString();
        }
        return sb.toString();
    }*/

    public static int getMonthsBetween(Calendar from, Calendar to) {
        int years = to.get(Calendar.YEAR) - from.get(Calendar.YEAR);
        int months = to.get(Calendar.MONTH) - from.get(Calendar.MONTH);
        if (years < 1) {
            return months;
        } else {
            return (years * 12) + months;
        }
    }

    public static Date nextDay(Date date) {
        return new Date(date.getTime() + (1000 * 60 * 60 * 24));
    }

    public static Date getEndOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        if (date == null)
            date = new Date();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, cal.getMaximum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getMaximum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMaximum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMaximum(Calendar.MILLISECOND));
        return cal.getTime();
    }

    /**
     * Convert timestamp in to Date
     *
     * @param timestamp - TimeStamp received
     * @return - date results
     */
    public static Date convertTime(long timestamp) {
        Date date = new Date(timestamp);
        return date;
    }

    public static Date convertTimee(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        return calendar.getTime();
    }

    public static int getAge(int year, int month, int day) {
        Calendar calendarBirthday = Calendar.getInstance();
        calendarBirthday.set(Calendar.YEAR, year);
        calendarBirthday.set(Calendar.MONTH, month);
        calendarBirthday.set(Calendar.DAY_OF_MONTH, day);
        Calendar calendarNow = Calendar.getInstance();
        int years = calendarNow.get(Calendar.YEAR) - calendarBirthday.get(Calendar.YEAR);
        if (calendarBirthday.get(Calendar.MONTH) > calendarNow.get(Calendar.MONTH)) {
            years--;
        } else if (calendarBirthday.get(Calendar.MONTH) == calendarNow.get(Calendar.MONTH) &&
                calendarBirthday.get(Calendar.DAY_OF_MONTH) > calendarNow.get(Calendar.DAY_OF_MONTH)) {
            years--;
        }
        return years;
    }


    public static int[] getBirthdayDate(Date date) {
        int[] dates = new int[3];
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        dates[2] = calendar.get(Calendar.DAY_OF_MONTH);
        dates[1] = calendar.get(Calendar.MONTH);
        dates[0] = calendar.get(Calendar.YEAR);
        return dates;
    }

    public static Date addMinutes(Date date, int minutes) {
        date.setTime(date.getTime() + minutes * ONE_MIN_MS);
        return date;
    }

    public static long getDifferenceInYears(Date to, Date from) {
        long diff = to.getTime() - from.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) / 365;
    }

    public static long getDifferenceInMonths(Date to, Date from) {
        long diff = to.getTime() - from.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) / 30;
    }


    // https://docs.oracle.com/javase/tutorial/i18n/format/dateFormat.html
    //ex: 6/30/09  OR  30/06/09
    public static String getShortLocaleDatePattern() {
        return ((SimpleDateFormat) java.text.DateFormat.getDateInstance(DateFormat.SHORT)).toPattern();
    }

    //ex: 7:03 AM  OR  07:03
    public static String getShortLocaleTimePattern() {
        //return ((SimpleDateFormat) DateFormat.getTimeInstance(DateFormat.SHORT)).toPattern();
        return getShortLocaleTimePatternAmPm();
    }

    /**
     *
     * @return pettern with AM or PM
     */
    public static String getShortLocaleTimePatternAmPm() {
        /*if (!android.text.format.DateFormat.is24HourFormat(BWCApp.getAppContext())) {
            return new SimpleDateFormat("h:mm a", Locale.getDefault()).toPattern();
        } else {
            return new SimpleDateFormat("HH:mm", Locale.getDefault()).toPattern();
        }*/
        return "";
    }

    private static String getLocaleTimeAndDatePattern() {
        return getShortLocaleTimePattern() + " - " + getShortLocaleDatePattern();
    }

    //ex: dd/MM  OR MM/DD
    public static String getDayAndMonthLocaleDatePattern() {
        return getShortLocaleDatePattern().replaceAll("\\W?[Yy]+\\W?", "");
    }

    public static String getMonthAndYearLocaleDatePattern() {
        return getShortLocaleDatePattern().replaceAll("W?[Dd]+\\W?", "");
    }

    public static CharSequence formatAMPMasSubscript(String dateFormatted) {
        //return dateFormatted.replace("AM", "\u2090\u2098").replace("PM", "\u209A\u2098");
        return Html.fromHtml(dateFormatted.replace("AM", "<small><small><small><small>AM</small></small></small></small>")
                .replace("PM", "<small><small><small><small>PM</small></small></small></small>"));
    }
}
