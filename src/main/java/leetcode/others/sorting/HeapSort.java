package main.java.leetcode.others.sorting;

/**
 * Worst Time Complexity: O(n log n)
 * -Best Time Complexity: O(n log n)
 * Space complexity: 1
 */
public class HeapSort {

    public static int[] sortAscending(int[] arr) {
        int heapSize = arr.length;

        for (int i=(heapSize/2)-1; i>=0; i--) {
            arr = buildMaxHeap(arr, heapSize, i);
        }

        for(int i=heapSize-1; i>0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            arr = buildMaxHeap(arr, i, 0);
        }

        return arr;
    }

    public static int[] buildMaxHeap(int[] arr, int lastIndex, int root) {
        int maxValue = root; //initialize root to contain the max value
        int leftChild = (root*2)+1;
        int rightChild = (root*2)+2;

        if((leftChild < lastIndex) && (arr[leftChild] > arr[maxValue])) {
            maxValue = leftChild;
        }

        if((rightChild < lastIndex) && (arr[rightChild] > arr[maxValue])) {
            maxValue = rightChild;
        }

        //swap child and root node if childNode's value is higher
        if(maxValue != root) {
            int temp = arr[root];
            arr[root] = arr[maxValue];
            arr[maxValue] = temp;

            return buildMaxHeap(arr, lastIndex, maxValue);
        }

        return arr;
    }

}
