package main.java.com.rraj91091.leetcode.challenge.easy;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 *
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 *
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {

        for(int i=0; i< nums.length; i++) {
            if(nums[i] >= target) {
                return i;
            }
        }

        return nums.length;
    }

    public int searchInsertV2(int[] nums, int target) {

        //handling edge cases
        if(nums.length == 0) {
            return 0;
        } else if(target < nums[0]) {
            return 0;
        } else if(nums[nums.length-1] < target) {
            return nums.length;
        }

        int start = 0;
        int end = nums.length;
        int midIndex = end / 2;

        while(start < end) {
            if(nums[midIndex] == target) {
                return midIndex;
            } else if(nums[midIndex] < target) {
                if(target < nums[midIndex+1]) {
                    return midIndex+1;
                }
                start = midIndex;
            } else {
                if(nums[midIndex-1] < target) {
                    return midIndex;
                }
                end = midIndex;
            }
            midIndex = (start + end) / 2;
        }

        return midIndex;
    }
}
