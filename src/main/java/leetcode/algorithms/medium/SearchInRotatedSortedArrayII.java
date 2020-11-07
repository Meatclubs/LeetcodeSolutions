package main.java.leetcode.algorithms.medium;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 *
 * Example 2:
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 *
 * Follow up:
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;

        if(nums[0] > target) {
            //search from back
            for(int i=nums.length-1; i>=0; i--) {
                if(nums[i] == target) return true;
            }
        } else {
            //search from front
            for(int i=0; i<nums.length; i++) {
                if(nums[i] == target) return true;
            }
        }

        return false;
    }
}
