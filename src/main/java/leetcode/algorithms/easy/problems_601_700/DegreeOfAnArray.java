package main.java.leetcode.algorithms.easy.problems_601_700;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *
 * Example 1:
 * Input: nums = [1,2,2,3,1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 *
 * Example 2:
 * Input: nums = [1,2,2,3,1,4,2]
 * Output: 6
 * Explanation:
 * The degree is 3 because the element 2 is repeated 3 times.
 * So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 *
 * Constraints:
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */
public class DegreeOfAnArray {
    public class Result{
        public int freq,start;
        public Result(int freq,int start){
            this.freq = freq;
            this.start = start;
        }
    }
    public int findShortestSubArray(int[] nums) {
        if(nums.length==0)
            return 0;
        Map<Integer,Result> map = new HashMap();
        int len = 1, maxFreq = 1;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                Result r = map.get(nums[i]);
                r.freq++;
                int newLen = ( i - r.start ) + 1;
                if(r.freq == maxFreq){
                    len = Math.min(len,newLen);
                }
                else if(r.freq>maxFreq){
                    len = newLen;
                    maxFreq = r.freq;
                }
                map.put(nums[i],r);
            }
            else{
                Result r = new Result(1,i);
                map.put(nums[i],r);
            }
        }
        return len;
    }
}
