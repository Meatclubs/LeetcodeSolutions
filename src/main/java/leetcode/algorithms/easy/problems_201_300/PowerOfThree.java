package main.java.leetcode.algorithms.easy.problems_201_300;

/**
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Example 1:
 * Input: 27
 * Output: true
 *
 * Example 2:
 * Input: 0
 * Output: false
 *
 * Example 3:
 * Input: 9
 * Output: true
 *
 * Example 4:
 * Input: 45
 * Output: false
 *
 * Follow up:
 * Could you do it without using any loop / recursion?
 */
public class PowerOfThree {
    /**
     * Naive looping
     */
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    /**
     * Changing base:
     * In Base 10, all powers of 10 start with the digit 1 and then are followed only by 0 (e.g. 10, 100, 1000).
     * This is true for other bases and their respective powers.
     * Therefore if we convert our number to base 3 and the representation is of the form 100...0, then the number is a power of 3.
     */
    public boolean isPowerOfThreeV2(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }

    /**
     * Integer Limitations
     * An important piece of information can be deduced from the function signature
     * In particular, n is of type int. In Java, this means it is a 4 byte, signed integer [ref].
     * The maximum value of this data type is 2147483647.
     *
     * Knowing the limitation of n, we can now deduce that the maximum value of n that is also a power of three is 1162261467. We calculate this as:
     *
     * 3^{log_3{MaxInt}} = 3^{19.56} = 3^{19} = 1162261467
     *
     * Therefore, the possible values of n where we should return true are 3^0,3^1, ... 3^{19}.
     * Since 3 is a prime number, the only divisors of 3^{19} are 3^0,3^1, ... 3^{19}.
     * Therefore all we need to do is divide 3^{19} by n.
     * A remainder of 0 means n is a divisor of 3^{19} and therefore a power of three.
     */
    public boolean isPowerOfThreeV3(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
