package main.java.leetcode.algorithms.easy.problems_1_100;

/**
 * Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 * Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 * Example 3:
 * Input: digits = [0]
 * Output: [1]
 *
 * Constraints:
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {

        int i = digits.length-1;

        if(digits[i] == 9) {
            return incrementOne(digits, i);
        } else {
            digits[i]++;
            return digits;
        }
    }

    private int[] incrementOne(int[] digits, int i) {
        if(digits[i] == 9) {
            if(i != 0) {
                //non-9 leading number
                digits[i] = 0;
                return incrementOne(digits, --i);
            } else {
                //leading digit 9
                /**
                 * when digits have a leading 9, create a new array with an extra space for the new leading '1'
                 */
                digits[i] = 0;
                int[] newDigits = new int[digits.length+1];
                newDigits[0] = 1;

                for(int j=0; j<digits.length; j++) {
                    newDigits[j+1] = digits[j];
                }
                return newDigits;
            }

        } else {
            digits[i]++;
            return digits;
        }
    }
}
