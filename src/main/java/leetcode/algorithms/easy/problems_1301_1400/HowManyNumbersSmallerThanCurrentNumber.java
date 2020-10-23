package main.java.leetcode.algorithms.easy.problems_1301_1400;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
 * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 * Return the answer in an array.
 *
 * Example 1:
 * Input: nums = [8,1,2,2,3]
 * Output: [4,0,1,1,3]
 * Explanation:
 * For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
 * For nums[1]=1 does not exist any smaller number than it.
 * For nums[2]=2 there exist one smaller number than it (1).
 * For nums[3]=2 there exist one smaller number than it (1).
 * For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 *
 * Example 2:
 * Input: nums = [6,5,4,8]
 * Output: [2,1,0,3]
 *
 * Example 3:
 * Input: nums = [7,7,7,7]
 * Output: [0,0,0,0]
 *
 * Constraints:
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 */
public class HowManyNumbersSmallerThanCurrentNumber {

    /**
     * Using HashMap to store ranks
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        HashMap<Integer,Integer> map = new HashMap<>();

        int rank = 0;
        for(int num : sorted) {
            if(map.get(num) == null) {
                map.put(num, rank);
            }
            rank++;
        }

        for(int i=0; i<nums.length; i++) {
            nums[i] = map.get(nums[i]);
        }

        return nums;
    }

    /**
     * Using Frequency Array
     */
    public int[] smallerNumbersThanCurrentV2(int[] nums) {
        int[]helper = new int [101];

        //add frequency of occurence for each number
        for(int i=0;i<nums.length;i++){
            helper[nums[i]]++;
        }

        //add total frequency of numbers equal to and below each number
        for(int i=1;i<101;i++){
            helper[i]+=helper[i-1];
        }

        //get number of smaller numbers by looking at total freq of the number before it
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){continue;}
            nums[i] = helper[nums[i]-1];
        }

        return nums;
    }
}
