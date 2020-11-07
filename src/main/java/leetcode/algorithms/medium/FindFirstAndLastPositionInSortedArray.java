package main.java.leetcode.algorithms.medium;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 * Constraints:
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */
public class FindFirstAndLastPositionInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int initial = getInitialPosition(nums, target);

        if(initial == -1) return new int[]{-1,-1};

        int start = initial;
        int end = initial;

        while(start >= 0 && nums[start] == target) start--;
        while(end < nums.length && nums[end] == target) end++;

        return new int[]{start+1,end-1};
    }

    private int getInitialPosition(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = start;

        while(start <= end) {
            mid = start + ((end-start)/2);
            if(nums[mid] == target) return mid;

            if(nums[mid] < target) start = mid+1;
            if(nums[mid] > target) end = mid-1;
        }

        return -1;
    }
}
