package main.java.leetcode.algorithms.easy.problems_901_1000;

/**
 * Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].
 * After this process, we have some array B.
 * Return the smallest possible difference between the maximum value of B and the minimum value of B.
 *
 * Example 1:
 * Input: A = [1], K = 0
 * Output: 0
 * Explanation: B = [1]
 *
 * Example 2:
 * Input: A = [0,10], K = 2
 * Output: 6
 * Explanation: B = [2,8]
 *
 * Example 3:
 * Input: A = [1,3,6], K = 3
 * Output: 0
 * Explanation: B = [3,3,3] or B = [4,4,4]
 *
 * Note:
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 0 <= K <= 10000
 */
public class SmallestRange1 {
    public int smallestRangeI(int[] A, int K) {
        //find the middle value between largest and smallest
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for(int i : A) {
            if(i > largest) largest = i;
            if(i < smallest) smallest = i;
        }

        int mid = smallest + ((largest-smallest)/2);
        largest = Integer.MIN_VALUE;
        smallest = Integer.MAX_VALUE;

        for(int i=0; i<A.length; i++) {
            if(mid > A[i]) {
                if(mid - A[i] >= K) {
                    A[i] += K; //add the maximum allowable value
                } else {
                    A[i] += mid - A[i]; //add just enough to reach mid value
                }
            } else if(mid < A[i]) {
                if(A[i] - mid >= K) {
                    A[i] -= K; //minus the maximum allowable value
                } else {
                    A[i] -= A[i] - mid; //minus just enough to reach mid value
                }
            }

            if(A[i] > largest) largest = A[i];
            if(A[i] < smallest) smallest = A[i];
        }

        return Math.abs(largest - smallest);
    }

    /**
     * Pure mathematics
     */
    public int smallestRangeIV2(int[] A, int K) {
        int min = A[0];
        int max = A[0];

        for(int i : A) {
            min = Math.min(min,i);
            max = Math.max(max,i);
        }

        return Math.max(0,(max-K) - (min+K));
    }
}
