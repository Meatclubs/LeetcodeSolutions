package main.java.leetcode.algorithms.easy.problems_301_400;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 *
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class IntersectionOfTwoArrays {

    /**
     * Two HashSet Solution
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> setOne = new HashSet<>();
        HashSet<Integer> setTwo = new HashSet<>();
        List<Integer> resultList = new ArrayList<>();

        for(Integer i : nums1) {
            setOne.add(i);
        }

        for(Integer i : nums2) {
            setTwo.add(i);
        }

        for(Integer e : setOne) {
            if(setTwo.contains(e)) {
                resultList.add(e);
            }
        }

        int[] result = new int[resultList.size()];

        for(int i=0; i<result.length; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

}
