package main.java.leetcode.algorithms.easy.problems_301_400;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example 1:
 * Input: 16
 * Output: true
 *
 * Example 2:
 * Input: 5
 * Output: false
 *
 * Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfFour {

    /**
     * Naive looping, generally faster and more memory-efficient than the v2 solution
     */
    public boolean isPowerOfFour(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 4 == 0) {
            n /= 4;
        }

        return n == 1;
    }

    /**
     * Changing base:
     * In Base 10, all powers of 10 start with the digit 1 and then are followed only by 0 (e.g. 10, 100, 1000).
     * This is true for other bases and their respective powers.
     * Therefore if we convert our number to base 4 and the representation is of the form 100...0, then the number is a power of 4.
     */
    public boolean isPowerOfFourV2(int n) {
        return Integer.toString(n, 4).matches("^10*$");
    }

}
