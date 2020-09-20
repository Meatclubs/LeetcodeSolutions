package main.java.leetcode.algorithms.searching;

import main.java.leetcode.algorithms.sorting.HeapSort;
import main.java.leetcode.utils.PrintUtils;

public class FindingKthLargestLowestNumber {

    public static int findKthLargest(int[] arr, int k) {
        int heapSize = arr.length;

        for (int i=(heapSize/2)-1; i>=0; i--) {
            arr = HeapSort.buildMaxHeap(arr, heapSize, i);
        }

        for(int i=heapSize-1; i>heapSize-1-k; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            arr = HeapSort.buildMaxHeap(arr, i, 0);
        }

        PrintUtils.printArray(arr);
        return arr[arr.length-k];
    }

}
