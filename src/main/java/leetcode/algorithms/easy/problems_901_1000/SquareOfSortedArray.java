package main.java.leetcode.algorithms.easy.problems_901_1000;

/**
 * We have an array A of integers, and an array queries of queries.
 * For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].
 * Then, the answer to the i-th query is the sum of the even values of A.
 * (Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)
 * Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.
 *
 * Example 1:
 * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * Output: [8,6,2,4]
 * Explanation:
 * At the beginning, the array is [1,2,3,4].
 * After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
 * After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
 * After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
 * After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
 *
 * Note:
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * 1 <= queries.length <= 10000
 * -10000 <= queries[i][0] <= 10000
 * 0 <= queries[i][1] < A.length
 */
public class SquareOfSortedArray {
    public int[] sortedSquares(int[] A) {
        int length = A.length;
        int[] results = new int[length];
        int first = 0;
        int second = 0;
        int index = 0;

        for(int i=0; i<length; i++) {
            if(A[i] >= 0) {
                first = i-1;
                second = i;
                break;
            }
        }

        while(index < length) {
            int before = first < 0 ? Integer.MAX_VALUE : (int) Math.pow(A[first],2);
            int after = second > results.length-1 ? Integer.MAX_VALUE : (int) Math.pow(A[second],2);

            if(before < after) {
                results[index] = before;
                index++;
                first--;
            } else {
                results[index] = after;
                index++;
                second++;
            }
        }

        return results;
    }
}
