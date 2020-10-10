package main.java.leetcode.algorithms.easy.problems_501_600;

import java.util.HashMap;

/**
 * We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
 * Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
 * A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without
 * changing the order of the remaining elements.
 *
 * Example 1:
 * Input: nums = [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: 2
 *
 * Example 3:
 * Input: nums = [1,1,1,1]
 * Output: 0
 *
 * Constraints:
 * 1 <= nums.length <= 2 * 104
 * -109 <= nums[i] <= 109
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int longest = 0;

        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        for(Integer i : map.keySet()) {
            if (map.containsKey(i + 1)) {
                longest = Math.max(longest, map.get(i) + map.get(i + 1));
            }
        }

        return longest;
    }
}
