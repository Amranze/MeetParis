package fr.amrane.amranetest.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by aaitzeouay on 22/02/2017.
 */

public class DateFormatter {
    private static String DATE_PATTERN = "dd/MM/yyyy";

    public static String convertDateToString(Date date){
        return new SimpleDateFormat(DATE_PATTERN, Locale.FRANCE).format(date);
    }
}
