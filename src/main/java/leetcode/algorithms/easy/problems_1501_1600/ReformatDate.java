package main.java.leetcode.algorithms.easy.problems_1501_1600;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a date string in the form Day Month Year, where:
 * Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
 * Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
 * Year is in the range [1900, 2100].
 * Convert the date string to the format YYYY-MM-DD, where:
 * YYYY denotes the 4 digit year.
 * MM denotes the 2 digit month.
 * DD denotes the 2 digit day.
 *
 * Example 1:
 * Input: date = "20th Oct 2052"
 * Output: "2052-10-20"
 *
 * Example 2:
 * Input: date = "6th Jun 1933"
 * Output: "1933-06-06"
 *
 * Example 3:
 * Input: date = "26th May 1960"
 * Output: "1960-05-26"
 *
 * Constraints:
 * The given dates are guaranteed to be valid, so no error handling is necessary.
 */
public class ReformatDate {
    public static Map<String,String> months;

    static {
        months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");
    }

    public String reformatDate(String date) {
        String[] elements = date.split(" ");
        StringBuilder sb = new StringBuilder();

        sb.append(elements[2]); //append year
        sb.append("-");

        sb.append(months.get(elements[1]));
        sb.append("-");

        StringBuffer day = new StringBuffer(elements[0]);
        day.deleteCharAt(day.length()-1);
        day.deleteCharAt(day.length()-1);
        if(day.length() == 1) day.insert(0,"0"); //append date leading 0
        sb.append(day);

        return sb.toString();
    }
}
