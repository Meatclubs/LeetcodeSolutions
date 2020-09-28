package main.java.leetcode.algorithms.easy.problems_201_300;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 * Input: [3,0,1]
 * Output: 2
 *
 * Example 2:
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 *
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 */
public class MissingNumber {

    /**
     * One of the most well-known stories in mathematics is of a young Gauss,
     * forced to find the sum of the first 100 natural numbers by a lazy teacher.
     * Rather than add the numbers by hand, he deduced a closed-form expression for the sum, or so the story goes
     *
     * We can compute the sum of nums in linear time, and by Gauss' formula, we can compute the sum of the
     * first nn natural numbers in constant time. Therefore, the number that is missing is simply the result of
     * Gauss' formula minus the sum of nums, as nums consists of the first nn natural numbers minus some number.
     */
    public int missingNumber(int[] nums) {
        int correctSum = nums.length * (nums.length+1) / 2;

        for(int i=0; i<nums.length; i++) {
            correctSum -= nums[i];
        }

        return correctSum;
    }
}
