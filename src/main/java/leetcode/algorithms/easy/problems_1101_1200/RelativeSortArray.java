package main.java.leetcode.algorithms.easy.problems_1101_1200;

/**
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
 * Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 * Example 1:
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 *
 * Constraints:
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * Each arr2[i] is distinct.
 * Each arr2[i] is in arr1.
 */

import java.util.*;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if(arr1.length < 2 ) return arr1;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i : arr1) {
            map.put(i, map.getOrDefault(i,0) + 1);
        }

        int index = 0;
        for(int k : arr2) {
            for(int i=0; i<map.get(k); i++) {
                arr1[index] = k;
                index++;
            }
            map.remove(k);
        }

        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            for(int i=0; i<entry.getValue(); i++) {
                list.add(entry.getKey());
            }
        }
        Collections.sort(list);

        for(int i : list) {
            arr1[index] = i;
            index++;
        }

        return arr1;
    }
}
