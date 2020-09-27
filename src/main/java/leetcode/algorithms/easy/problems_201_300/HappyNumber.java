package main.java.leetcode.algorithms.easy.problems_201_300;

import java.util.HashSet;

/**
 * Write an algorithm to determine if a number n is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until the number
 * equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 * Return True if n is a happy number, and False if not.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> numsAlreadySeen = new HashSet<>();

        int result = n;
        while(result != 1) {
            result = getSquares(result);
            if(numsAlreadySeen.contains(result)) {
                return false;
            } else {
                numsAlreadySeen.add(result);
            }
        }

        return true;
    }

    private int getSquares(int n) {
        int sum = 0;
        while(n > 0) {
            sum += Math.pow(n%10,2);
            n /= 10;
        }

        return sum;
    }
}
