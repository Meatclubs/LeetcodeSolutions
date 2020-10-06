package main.java.leetcode.algorithms.easy.problems_501_600;

/**
 * Given an integer, return its base 7 string representation.
 *
 * Example 1:
 * Input: 100
 * Output: "202"
 *
 * Example 2:
 * Input: -7
 * Output: "-10"
 * Note: The input will be in range of [-1e7, 1e7].
 */
public class ConvertToBase7 {

    public String convertToBase7(int num) {
        int abNum = Math.abs(num);
        int result = 0;
        int power = 1;

        while(abNum > 0) {
            result += (abNum % 7) * power;
            abNum /= 7;
            power *= 10;
        }

        return num < 0 ? String.valueOf(result * -1) : String.valueOf(result);
    }

    /**
     * Optimized version.
     * We can divide negative num because we are adding the remainders at each iteration.
     * So remainder of a negative number will always be a negative number.
     */
    public String convertToBase7V2(int num) {
        int power = 1;
        int result = 0;

        while(Math.abs(num) > 0) {
            result += (num % 7) * power;
            num /= 7;
            power *= 10;
        }

        return String.valueOf(result);
    }
}
