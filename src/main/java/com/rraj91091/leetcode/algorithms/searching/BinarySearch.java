package com.rraj91091.leetcode.algorithms.searching;

/**
 * Used to search for a value in a sorted Array
 * Time Complexity: O(log n)
 */
public class BinarySearch {

    //returns index of element containing the specific value
    public static int search(int[] arr, int value, int firstIndex, int lastIndex) {
        int middleIndex = lastIndex - firstIndex / 2;

        if(arr[middleIndex] == value) {
            return middleIndex;
        }

        if(arr[middleIndex] > value) {
            //search left side
            return search(arr, value, firstIndex, middleIndex-1);
        }

        if(arr[middleIndex] < value) {
            //search right side
            return search(arr, value, middleIndex+1, lastIndex);
        }

        return -1; //if value not found
    }

}
