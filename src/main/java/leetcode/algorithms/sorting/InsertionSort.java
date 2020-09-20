package main.java.leetcode.algorithms.sorting;

/**
 * Worse case time complexity : O (n^2)
 * -Best case time complexity : O (n log n)
 * Space complexity: 1
 */
public class InsertionSort {

    public static int[] sort(int[] arr) {
        for(int i=1; i<arr.length; i++) {
            int targetPos=i;

            while(targetPos>0 && arr[i] < arr[targetPos-1]) {
                targetPos--;
            }

            arr = shift(arr, i, targetPos);
        }

        return arr;
    }

    private static int[] shift(int[] arr, int indexToShift, int targetPos) {
        int valueToShift = arr[indexToShift];

        for(int i = indexToShift; i>targetPos; i--) {
            arr[i] = arr[i-1];
        }
        arr[targetPos] = valueToShift;

        return arr;
    }

}
