package main.java.leetcode.algorithms.easy.problems_1001_1100;

import java.util.Arrays;

public class LargestSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {

        /**
         * sort array to shift lowest numbers <<<<
         */
        Arrays.sort(A);
        int index = 0;
        int sum = 0;

        /**
         * invert any negative numbers to positive from most negative to least negative
         */
        for(int i=0; i<K; i++) {
            if(A[i] < 0) {
                A[i] *= -1;
                K--;
            } else if(A[i] == 0) {
                /**
                 * if there is a 0, then we can invert 0 forever, so no more change
                 */
                for(int j : A) sum += j;
                return sum;
            } else {
                /**
                 * if we have positive numbers, then exit loop;
                 */
                break;
            }
        }

        /**
         * sort array again
         */
        Arrays.sort(A);

        /**
         * then flip the lowest value as many times as remaining
         */
        while(K > 0) {
            A[0] *= -1;
            K--;
        }

        for(int i : A) sum += i;
        return sum;
    }

    public int largestSumAfterKNegationsV2(int[] arr, int k) {
        Arrays.sort(arr);
        int sum = 0, len = arr.length, minIndex = 0;
        while (k > 0) {
            arr[minIndex] *= -1;
            k--;
            if (minIndex + 1 < len && arr[minIndex] > arr[minIndex + 1]) minIndex++;
        }
        for (int i : arr) sum += i;
        return sum;
    }
}
