package main.java.leetcode.algorithms.easy.problems_901_1000;

import java.util.ArrayList;
import java.util.List;

/**
 * For a non-negative integer X, the array-form of X is an array of its digits in left to right order.
 * For example, if X = 1231, then the array form is [1,2,3,1].
 * Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
 *
 * Example 1:
 * Input: A = [1,2,0,0], K = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 *
 * Example 2:
 * Input: A = [2,7,4], K = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 *
 * Example 3:
 * Input: A = [2,1,5], K = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 *
 * Example 4:
 * Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * Output: [1,0,0,0,0,0,0,0,0,0,0]
 * Explanation: 9999999999 + 1 = 10000000000
 *
 * Note：
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * If A.length > 1, then A[0] != 0
 */
public class AddToArrayFormInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {

        /**
         * while K and A have integers, add the last integers of both to A[i].
         * Then if there's a carry, add +10 to K (effectively bringing the value of the carry into K to be added
         * to A[i-1] in the next loop.
         */
        for(int i = A.length-1; (K > 0 && i >= 0) ; i--) {
            int sum = A[i] + (K % 10);
            A[i] = (sum % 10);

            K += sum - (sum % 10);
            K /= 10;
        }

        List<Integer> list = new ArrayList<>();

        /**
         * Now K will have the value of the "carry" if any. Usually '1', but if K has more digits than A,
         * then K will have all the digits that appear before the digits of A, so we add the digits of K first
         * into the list from right to left.
         */
        while(K > 0) {
            list.add(0,K % 10);
            K /= 10;
        }

        /**
         * Once the carry values of K has been added to the beginning of the last, we add the values in A to the
         * end of the list 1 by 1 from left to right.
         */
        for(int i : A) {
            list.add(i);
        }

        return list;
    }
}
