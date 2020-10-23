package main.java.leetcode.algorithms.easy.problems_1301_1400;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
 * A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
 *
 * Example 1:
 * Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * Output: [15]
 * Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
 *
 * Example 2:
 * Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * Output: [12]
 * Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
 *
 * Example 3:
 * Input: matrix = [[7,8],[1,2]]
 * Output: [7]
 *
 * Constraints:
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 10^5.
 * All elements in the matrix are distinct.
 */
public class LuckyNumbersInMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] minInRow = new int[matrix.length];
        int[] maxInCol = new int[matrix[0].length];
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<matrix.length; i++) {
            minInRow[i] = Integer.MAX_VALUE;
            for(int j=0; j<matrix[i].length; j++) {
                minInRow[i] = Math.min(minInRow[i], matrix[i][j]);
            }
        }

        for(int j=0; j<matrix[0].length; j++) {
            maxInCol[j] = Integer.MIN_VALUE;
            for(int i=0; i<matrix.length; i++) {
                maxInCol[j] = Math.max(maxInCol[j], matrix[i][j]);
            }
        }

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j] == minInRow[i] && matrix[i][j] == maxInCol[j])
                    result.add(matrix[i][j]);
            }
        }

        return result;
    }
}
