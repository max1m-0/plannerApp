package utils;

import java.text.DateFormatSymbols;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class MonthUtil {
    public static int getDecemberDaysCount(){
        Month month = java.time.Month.DECEMBER;
        return month.maxLength();
    }
    public static Map<Integer, String> getMonthList() {
        Map<Integer, String> monthMap = new HashMap<>();
        String[] months = new DateFormatSymbols().getMonths();
        for (int i = 0; i < months.length - 1; i++) {
            if (months[i].endsWith("ая"))
                monthMap.put(i,months[i].substring(0, months[i].length() - 1) + "й");
            else if (months[i].endsWith("я"))
                monthMap.put(i,months[i].substring(0, months[i].length() - 1) + "ь");
            else
                monthMap.put(i,months[i].substring(0, months[i].length() - 1));
        }
        return monthMap;
    }
}

