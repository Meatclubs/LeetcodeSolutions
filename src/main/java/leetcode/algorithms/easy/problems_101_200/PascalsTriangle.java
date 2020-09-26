package main.java.leetcode.algorithms.easy.problems_101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<numRows; i++) {
            List<Integer> rowList = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                if(j==0 || j==i) {
                    rowList.add(1);
                } else {
                    rowList.add(result.get(i-1).get(j) + result.get(i-1).get(j-1));
                }
            }
            result.add(rowList);
        }

        return result;
    }
}
