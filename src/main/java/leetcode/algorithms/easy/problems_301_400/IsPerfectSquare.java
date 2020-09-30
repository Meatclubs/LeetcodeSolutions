package main.java.leetcode.algorithms.easy.problems_301_400;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Follow up: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 * Input: num = 16
 * Output: true
 *
 * Example 2:
 * Input: num = 14
 * Output: false
 *
 * Constraints:
 * 1 <= num <= 2^31 - 1
 */
public class IsPerfectSquare {

    /**
     * Binary search solution
     */
    public boolean isPerfectSquare(int num) {
        if(num == 1) {
            return true;
        }

        int min = 1;
        int max = num;

        while(min <= max) {
            long mid = (max+min) / 2;

            if(mid*mid == num) {
                return true;
            } else if(mid*mid < num) {
                min = (int) mid+1;
            } else if(mid*mid > num) {
                max = (int) mid-1;
            }
        }

        return false;
    }
}
