package main.java.leetcode.algorithms.easy.problems_101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.
 * Notice that the row index starts from 0.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Follow up:
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * Example 1:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 *
 * Example 2:
 * Input: rowIndex = 0
 * Output: [1]
 *
 * Example 3:
 * Input: rowIndex = 1
 * Output: [1,1]
 *
 * Constraints:
 * 0 <= rowIndex <= 40
 */
public class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {

        int[] rowPrev = new int[rowIndex+1];
        int[] rowCurr;

        for(int i=0; i<=rowIndex; i++) {
            rowCurr = new int[rowIndex+1];
            for(int j=0; j<=i; j++) {
                if(j==0 || j==i) {
                    rowCurr[j] = 1;
                } else {
                    if(i > 0) {
                        rowCurr[j] = rowPrev[j] + rowPrev[j-1];
                    }
                }
            }

            rowPrev = rowCurr;
        }

        List<Integer> result = new ArrayList<>();
        for(int i=0; i<=rowIndex; i++) {
            result.add(rowPrev[i]);
        }

        return result;
    }
}
