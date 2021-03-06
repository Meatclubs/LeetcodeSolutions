package main.java.leetcode.algorithms.easy.problems_301_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 *
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 *
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return intersect(nums2, nums1); //make nums1 the smaller array
        }

        List<Integer> resultsList = new ArrayList<>();
        HashMap<Integer,Integer> mapOne = new HashMap<>();

        for(Integer num : nums1) {
            mapOne.put(num, mapOne.getOrDefault(num,0) + 1);
        }

        for(Integer num : nums2) {
            if(mapOne.containsKey(num) && mapOne.get(num) > 0) {
                resultsList.add(num);
                mapOne.put(num, mapOne.get(num)-1);
            }
        }

        int[] results = new int[resultsList.size()];

        for(int i = 0; i<resultsList.size(); i++) {
            results[i] = resultsList.get(i);
        }

        return results;
    }
}
