package main.java.leetcode.challenge.easy.problems_101_200;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Example 1:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 * Example 2:
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 *
 * Example 3:
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 *
 * Constraints:
 * 2 <= nums.length <= 3 * 104
 * -1000 <= nums[i] <= 1000
 * nums is sorted in increasing order.
 * -1000 <= target <= 1000
 */
public class TwoSum2 {

    /**
     * Two-Pointer method with Binary search to reduce the total range to be traversed.
     */
    public int[] twoSum(int[] numbers, int target) {

        if(numbers.length < 2) {
            return new int[]{0,0};
        }

        int firstIndex = 0;
        int secondIndex = getEndIndex(numbers,target,0,numbers.length-1);

        while(firstIndex < secondIndex) {
            if(numbers[firstIndex] + numbers[secondIndex] == target) {
                return new int[]{firstIndex+1,secondIndex+1};
            }
            if(numbers[firstIndex] + numbers[secondIndex] > target) {
                secondIndex--;
            }
            if(numbers[firstIndex] + numbers[secondIndex] < target) {
                firstIndex++;
            }
        }

        return new int[]{firstIndex+1,secondIndex+1};
    }

    /**
     * use binary search to get the index at which the value is greater or equals to target,
     * and every element to the left is lesser than target. This is to reduce the number of
     * elements needed to be traversed later on.
     */
    private int getEndIndex(int[] numbers, int target, int start, int end) {
        int mid = (end + start) / 2;

        while(end - start > 1) {
            mid = (end + start) / 2;
            if(numbers[mid] >= target) {
                end = mid;
            }
            if(numbers[mid] < target) {
                start = mid;
            }
        }

        return end;
    }
}
