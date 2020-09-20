package main.java.leetcode.algorithms.sorting;

import java.util.Arrays;

/**
 * Worse case time complexity : O (n log n)
 * -Best case time complexity : O (n log n)
 * Space complexity: n
 */
public class MergeSort {

    public static int[] sort(int[] arr) {
        if(arr.length > 1) {
            int middlePos = arr.length / 2;

            int[] leftArr = Arrays.copyOfRange(arr, 0, middlePos);
            int[] rightArr = Arrays.copyOfRange(arr, middlePos, arr.length);

            int[] leftSorted = sort(leftArr);
            int[] rightSorted = sort(rightArr);

            return merge(leftSorted, rightSorted);
        }

        return arr;
    }

    private static int[] merge(int[] leftArr, int[] rightArr) {
        int[] merged = new int[leftArr.length + rightArr.length];

        int leftIterator = 0;
        int rightIterator = 0;

        for (int i = 0; i < merged.length; i++) {
            if (leftArr[leftIterator] <= rightArr[rightIterator]) {
                merged[i] = leftArr[leftIterator];
                leftIterator++;
            } else {
                merged[i] = rightArr[rightIterator];
                rightIterator++;
            }

            //if reached end of leftArr
            if (leftIterator == leftArr.length) {
                i++;
                while (rightIterator < rightArr.length) {
                    merged[i] = rightArr[rightIterator];
                    rightIterator++;
                }
                break;
            }

            //if reached end of rightArr
            if (rightIterator == rightArr.length) {
                i++;
                while (leftIterator < leftArr.length) {
                    merged[i] = leftArr[leftIterator];
                    leftIterator++;
                }
                break;
            }
        }

        return merged;
    }

    //---------------------------OPTIONAL------------------------------
    private static int[][] splitArray(int[] array) {
        int[] leftArr = new int[array.length+1 / 2];
        int[] rightArr = new int[array.length - leftArr.length];

        for(int i=0; i<array.length; i++) {
            if(i < leftArr.length) {
                leftArr[i] = array[i];
            } else {
                rightArr[i - leftArr.length] = array[i];
            }
        }

        return new int[][] {leftArr, rightArr};
    }

}
