package main.java.leetcode.algorithms.easy.problems_1_100;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 * Input: 121
 * Output: true
 *
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        String xx = String.valueOf(x);

        for(int i = 0; i<xx.length(); i++) {
            if(xx.charAt(i) != xx.charAt(xx.length()-1-i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Another method without converting x into a string
     */
    public boolean isPalindromeV2(int x) {
        if(x < 0 || ((x % 10 == 0) && x > 0)) {
            return false;
        }
        if(x < 10) {
            return true;
        }

        int original = x;
        int reverseNum = 0;
        while(original > 0) {
            int lastDigit = original % 10;
            reverseNum = (reverseNum * 10) + lastDigit;
            original = original / 10; //remove last digit;
        }

        return (x == reverseNum) ;
    }
}
