package main.java.leetcode.algorithms.medium;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * Follow up:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 *
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 * Constraints:
 * 1 <= nums.length <= 2 * 10^4
 * It's guaranteed that nums[i] fits in a 32 bit-signed integer.
 * k >= 0
 */
public class RotateArray {
    /**
     * Cyclic Replacement method
     */
    public void rotate(int[] nums, int k) {
        int rotations = k % nums.length;

        if(rotations == 0) {
            return; //do nothing
        }

        /**
         * counter to keep track of no. of elements moved.
         * To be used to check if we need to increment starting element to go another replacement cycle
         */
        int movedElements = 0;

        for(int i=0; i<k; i++) {
            int startPoint = i;
            int j = i;

            int eToMove = nums[j];
            while(true) {
                int temp = nums[(j+k) % nums.length];
                nums[(j+k) % nums.length] = eToMove;
                eToMove = temp;
                j  = (j+k) % nums.length;

                movedElements++;

                if(j == startPoint) {
                    /**
                     * we have reached the end of a replacement cycle
                     */
                    break;
                }
            }

            /**
             * all elements have been moved
             */
            if(movedElements == nums.length) {
                break;
            }
        }
    }
}
