package main.java.leetcode.algorithms.easy.problems_201_300;

/**
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {

        int first = 0;

        /**
         * initialize first pointer to the first zero element
         */
        while(nums[first] != 0) {
            first++;
            if(first == nums.length) { return; }
        }

        /**
         * initialize second pointer to the element after the first pointer.
         */
        int second = first;

        while(second < nums.length) {
            /**
             * move second pointer to the next non-zero element
             */
            while(nums[second] == 0) {
                second++;
                if(second == nums.length) { return; }
            }

            /**
             * swap values of the elements at both pointers
             */
            nums[first] = nums[second];
            nums[second] = 0;

            /**
             * move first pointer up to the next zero element
             */
            while(nums[first] != 0) {
                first++;
                if(first == nums.length) { return; }
            }
        }
    }
}
