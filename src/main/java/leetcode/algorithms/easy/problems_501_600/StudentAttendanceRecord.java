package main.java.leetcode.algorithms.easy.problems_501_600;

/**
 * You are given a string representing an attendance record for a student.
 * The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent)
 * or more than two continuous 'L' (late).
 * You need to return whether the student could be rewarded according to his attendance record.
 *
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 *
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class StudentAttendanceRecord {
    public boolean checkRecord(String s) {
        int absent = 0;
        boolean late = false;
        boolean doubleLate = false;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'A') {
                absent++;
                if(absent > 1) { return false; }
                late = false;
                doubleLate = false;
            }

            if(s.charAt(i) == 'L') {
                if(late) {
                    if(doubleLate) { return false; }
                    doubleLate = true;
                }

                late = true;
            }

            if(s.charAt(i) == 'P') {
                late = false;
                doubleLate = false;
            }
        }

        return true;
    }
}
