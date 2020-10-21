package main.java.leetcode.algorithms.easy.problems_1101_1200;

/**
 * Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.
 *
 * Example 1:
 * Input: date = "2019-01-09"
 * Output: 9
 * Explanation: Given date is the 9th day of the year in 2019.
 *
 * Example 2:
 * Input: date = "2019-02-10"
 * Output: 41
 *
 * Example 3:
 * Input: date = "2003-03-01"
 * Output: 60
 *
 * Example 4:
 * Input: date = "2004-03-01"
 * Output: 61
 *
 * Constraints:
 * date.length == 10
 * date[4] == date[7] == '-', and all other date[i]'s are digits
 * date represents a calendar date between Jan 1st, 1900 and Dec 31, 2019.
 */
public class DayOfYear {
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8));

        int previousMonthsDays = getDaysOfPreviousMonths(month);
        int totalDays = day + previousMonthsDays;

        if((year % 4 == 0) && (month > 2)) {
            if(!(year % 100 == 0 && year % 400 != 0))
                totalDays++;
        }

        return totalDays;
    }

    private int getDaysOfPreviousMonths(int month) {
        int[] daysOfMonths = new int[]{31,28,31,30,31,30,31,31,30,31,30};

        int totalDays = 0;
        for(int i=0; i<month-1; i++) {
            totalDays += daysOfMonths[i];
        }

        return totalDays;
    }
}
