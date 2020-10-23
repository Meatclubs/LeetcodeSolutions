package main.java.leetcode.algorithms.easy.problems_1301_1400;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class FindDistanceValueBetween2Arrays {
    /**
     * slightly optimized brute force O(N * M)
     */
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;

        for(int i=0; i<arr1.length; i++) {
            int prevDistance = Integer.MAX_VALUE;
            boolean ok = true;

            for(int j=0; j<arr2.length; j++) {
                int distance = Math.abs(arr1[i] - arr2[j]);
                if(distance <= d) ok = false;

                if(distance > prevDistance) {
                    break;
                } else {
                    prevDistance = distance;
                }
            }

            if(ok) count++;
        }

        return count;
    }

    /**
     * Using Treeset O(nlogm)
     */
    public int findTheDistanceValueV2(int[] arr1, int[] arr2, int d) {
        int count = 0;
        TreeSet<Integer> tree = new TreeSet<>();
        for (int number: arr2) {
            tree.add(number);
        }
        for (int i=0; i<arr1.length; i++) {
            int leftValue = arr1[i] - d;
            int rightValue = arr1[i] + d;
            Set<Integer> set = tree.subSet(leftValue, rightValue+1);
            if (set.isEmpty())
                count += 1;
        }
        return count;
    }

    /**
     * using count array
     * Not efficient for large value ranges
     */
    public static final int gap = 1100;
    public int findTheDistanceValueV3(int[] arr1, int[] arr2, int d) {
        int[] dp = new int[2201];
        int count = 0;

        for (int num : arr2) {
            int lower = num - d;
            int upper = num + d;

            while(lower <= upper) {
                dp[lower + gap]++;
                lower++;
            }
        }

        for(int num : arr1) {
            if(dp[num + gap] == 0) count++;
        }

        return count;
    }
}
