package main.java.leetcode.challenge.easy.problems_101_200;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        /**
         * Boyer-Moore Voting Algorithm
         * Essentially, what Boyer-Moore does is look for a suffix sufsuf of nums where suf[0]suf[0] is the majority
         * element in that suffix. To do this, we maintain a count, which is incremented whenever we see an instance of
         * our current candidate for majority element and decremented whenever we see anything else. Whenever count
         * equals 0, we effectively forget about everything in nums up to the current index and consider the current
         * number as the candidate for majority element. It is not immediately obvious why we can get away with forgetting
         * prefixes of nums - consider the following examples (pipes are inserted to separate runs of nonzero count).
         */

        if(nums.length < 0) {
            return 0;
        }

        int candidate = nums[0];
        int count = 0;

        for(int i=0; i<nums.length; i++) {
            /**
             * if count == 0, previous candidate was not the common element,
             * therefore take current element as next candidate.
             */
            if(count == 0) {
                candidate = nums[i];
                count++;
                continue;
            }

            /**
             * if element == candidate, increment count, else decrement count
             */
            if(nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
