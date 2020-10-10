package main.java.leetcode.algorithms.easy.problems_601_700;

/**
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the
 * maximum average value. And you need to output the maximum average value.
 *
 * Example 1:
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 *
 * Note:
 * 1 <= k <= n <= 30,000.
 * Elements of the given array will be in the range [-10,000, 10,000].
 */
public class MaximumAverageSubarray {
    /**
     * Using sum array
     */
    public double findMaxAverage(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];

        //initialize sum of first array
        for(int i=0; i<k; i++) {
            res[0] += nums[i];
        }

        for(int i=1; i<=nums.length-k; i++) {
            res[i] = res[i-1] + nums[i+k-1] - nums[i-1];
        }

        int max = res[0];
        for(int i=0; i<res.length; i++) {
            max = Math.max(max, res[i]);
        }

        return (double) max / k;
    }

    /**
     * Without using sum array
     */
    public double findMaxAverageV2(int[] nums, int k) {
        int sum = 0;

        //initialize sum of first array
        for(int i=0; i<k; i++) {
            sum += nums[i];
        }

        int res = sum;

        for(int i=1; i<=nums.length-k; i++) {
            sum += nums[i+k-1] - nums[i-1];
            res = Math.max(sum,res);
        }

        return (double) res / k;
    }
}
