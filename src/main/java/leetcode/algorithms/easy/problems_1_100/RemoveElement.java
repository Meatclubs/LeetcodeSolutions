package main.java.leetcode.algorithms.easy.problems_1_100;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Example 1:
 * Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 * It doesn't matter what you leave beyond the returned length.
 *
 * Example 2:
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 * Note that the order of those five elements can be arbitrary.
 * It doesn't matter what values are set beyond the returned length.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int frontIndex = 0;
        int backIndex = nums.length-1;

        /**
         * handle empty and single-element arrays
         */
        if(nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            if(nums[0] == val) {
                return 0;
            } else {
                return 1;
            }
        }

        /**
         * initialize backIndex to last non-val element
         */
        while((backIndex >= 0) && (nums[backIndex] == val)) {
            backIndex--;
        }

        while(frontIndex <= backIndex) {
            if(nums[frontIndex] == val) {
                nums[frontIndex] = nums[backIndex];
                nums[backIndex] = val;

                /**
                 * after swapping, shift backIndex forward to next non-val element
                 */
                while((backIndex >= 0) && (nums[backIndex] == val)) {
                    backIndex--;
                }
            }

            frontIndex++;
        }

        return frontIndex;
    }

}
