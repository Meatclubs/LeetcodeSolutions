package main.java.leetcode.algorithms.easy.problems_201_300;

/**
 * Given an integer n, write a function to determine if it is a power of two.
 *
 * Example 1:
 * Input: n = 1
 * Output: true
 * Explanation: 20 = 1
 *
 * Example 2:
 * Input: n = 16
 * Output: true
 * Explanation: 24 = 16
 *
 * Example 3:
 * Input: n = 3
 * Output: false
 *
 * Example 4:
 * Input: n = 4
 * Output: true
 *
 * Example 5:
 * Input: n = 5
 * Output: false
 *
 * Constraints:
 * -231 <= n <= 231 - 1
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {

        if(n < 1) {
            return false;
        }

        while(n > 1) {
            if(n % 2 == 1) {
                return false;
            }
            n/=2;
        }
        return true;
    }
}
