package main.java.leetcode.others.sorting;

/**
 * Worse case time complexity : O (n^2)
 * -Best case time complexity : O (n log n)
 * Space complexity: O(log n)
 */
public class QuickSort {

    public static int[] sort(int[] arr, int startIndex, int pivotIndex) {

        if(startIndex < pivotIndex) {
            int j = startIndex;

            //move all elements smaller than pivot value to the left
            for(int i=startIndex; i<pivotIndex; i++) {
                if(arr[i] < arr[pivotIndex]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    j++;
                }
            }

            //move pivot value to the correct position
            int temp2 = arr[pivotIndex];
            arr[pivotIndex] = arr[j];
            arr[j] = temp2;

            //sort left side of pivot
            arr = sort(arr, startIndex, j - 1);

            //sort right side of pivot
            arr = sort(arr, j + 1, pivotIndex);
        }

        return arr;
    }

}
