package main.java.com.rraj91091.leetcode.challenge.interview;

/**
 * Given 2 sorted arrays A and B of length N and M, merge the two arrays and return a single sorted array.
 *
 * Assume that A has exactly enough additional space at the end of the array to hold all elements in B.
 *
 * Constraints:
 * 1. Space complexity: O(1)
 * 2. Time complexity: O(N+M)
 *
 * e.g. Given
 * A = [1,2,3,4,5,6,X,X,X]
 * B = [1,2,3]
 * Result = [1,1,2,2,3,3,4,5,6]

 */
public class MergeTwoArraysInSortedOrder {

    public static int[] sort(int[] A, int[] B) {

        if(A.length < B.length) {
            return sort(B,A);
        }

        int indexA = A.length-B.length-1;
        int indexB = B.length-1;
        int indexToInsertInto = A.length-1;

        while(indexA >= 0 && indexB >= 0) {

            if(A[indexA] > B[indexB]) {
                A[indexToInsertInto] = A[indexA];
                indexA--;
            } else {
                A[indexToInsertInto] = B[indexB];
                indexB--;
            }

            indexToInsertInto--;

            if(indexB < 0) {
                return A;
            }

            if(indexA < 0) {
                while(indexB >= 0) {
                    A[indexB] = B[indexB];
                    indexB--;
                }
            }
        }

        return A;
    }

}
