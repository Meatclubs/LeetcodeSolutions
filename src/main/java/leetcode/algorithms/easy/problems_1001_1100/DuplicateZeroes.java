package main.java.leetcode.algorithms.easy.problems_1001_1100;

/**
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place, do not return anything from your function.
 *
 * Example 1:
 * Input: [1,0,2,3,0,4,5,0]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 *
 * Example 2:
 * Input: [1,2,3]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 * Note:
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 */
public class DuplicateZeroes {
    /**
     * One Pass O(N^2) solution
     */
    public void duplicateZeros(int[] arr) {
        int index = 0;

        while(index < arr.length-1) {
            if(arr[index] == 0) {
                for(int i=arr.length-1; i > index; i--) {
                    arr[i] = arr[i-1];
                }
                index += 2;
            } else {
                index++;
            }
        }
    }

    /**
     * Two-pass O(N) solution
     */
    public void duplicateZerosV2(int[] arr) {
        int len = arr.length-1;
        int zeroes = 0;

        for(int i=0; i<=len-zeroes; i++) {
            if(arr[i] == 0) {

                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included
                if (i == len-zeroes) {
                    // For this zero we just copy it without duplication.
                    arr[len] = 0;
                    len--;
                    break;
                }

                zeroes++;
            }
        }

        for(int i=len-zeroes; i>=0; i--) {
            arr[i+zeroes] = arr[i];

            if(arr[i] == 0) {
                zeroes--;
                arr[i+zeroes] = arr[i];
            }
        }
    }
}
