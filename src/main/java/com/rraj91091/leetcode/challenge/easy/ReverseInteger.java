package main.java.com.rraj91091.leetcode.challenge.easy;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 * Input: 123
 * Output: 321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 */
public class ReverseInteger {

    public static int reverse(int x) {
        long result = 0;
        /**
         * we do math.abs() here to remove the minus '-' sign from being included in the digit's length
         */
        int length = String.valueOf(Math.abs(x)).length();

        while(x != 0) {
            /**
             * use length of digit to determine power
             */
            result += (x%10) * Math.pow(10,length-1);
            x = x / 10;
            length--;
        }

        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) result;
    }
}
