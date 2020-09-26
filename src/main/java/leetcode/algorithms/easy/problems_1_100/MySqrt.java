package main.java.leetcode.algorithms.easy.problems_1_100;

/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 * Input: 4
 * Output: 2
 *
 * Example 2:
 * Input: 8
 * Output: 2
 *
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 */
public class MySqrt {
    public int mySqrt(int x) {

        if(x == 1) {
            return 1;
        }

        long start = 2;
        long result = x/2;
        long end = x;

        while((end - start) > 1) {
            ///if same as X, return result
            if(result*result == x) {
                return (int) result;
            }

            if(result*result < x) {
                if((result+1)*(result+1) > x) {
                    return (int) result;
                } else {
                    start = result;
                    result = (end + start) / 2;
                }
            }

            if(result*result > x) {
                end = result;
                result = (end + start) / 2;
            }

        }

        return (int) result;
    }
}
