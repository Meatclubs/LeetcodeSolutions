package main.java.leetcode.algorithms.easy.problems_901_1000;

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 * Note:
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int first = 0;
        int last = A.length-1;

        while(first < last) {
            if(A[first] % 2 == 0) {
                first++;
                continue;
            }
            if(A[last] % 2 == 1) {
                last--;
                continue;
            }

            int temp = A[first];
            A[first] = A[last];
            A[last] = temp;

            first++;
            last--;
        }

        return A;
    }
}
