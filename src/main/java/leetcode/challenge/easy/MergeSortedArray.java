package main.java.leetcode.challenge.easy;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 *
 * Constraints:
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 */
public class MergeSortedArray {

    public void merge(int[] A, int m, int[] B, int n) {

        int indexA = m-1;
        int indexB = n-1;
        int indexToInsertInto = m+n-1;

        while(indexB >= 0) {
            /**
             * if there are elements in A, compare with B and insert largest to the back, moving forward
             */
            if(indexA >= 0) {
                if(A[indexA] > B[indexB]) {
                    A[indexToInsertInto] = A[indexA];
                    indexA--;
                } else {
                    A[indexToInsertInto] = B[indexB];
                    indexB--;
                }

                indexToInsertInto--;

            } else {
                /**
                 * If there are no more elements in A to compare with, copy remaining elements from B over
                 */
                while(indexB >= 0) {
                    A[indexB] = B[indexB];
                    indexB--;
                }
            }
        }
    }

}
