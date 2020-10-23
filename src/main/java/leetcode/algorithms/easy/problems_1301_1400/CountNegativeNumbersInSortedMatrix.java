package main.java.leetcode.algorithms.easy.problems_1301_1400;

/**
 * Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise.
 * Return the number of negative numbers in grid.
 *
 * Example 1:
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 *
 * Example 2:
 * Input: grid = [[3,2],[1,0]]
 * Output: 0
 *
 * Example 3:
 * Input: grid = [[1,-1],[-1,-1]]
 * Output: 3
 *
 * Example 4:
 * Input: grid = [[-1]]
 * Output: 1
 *
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 */
public class CountNegativeNumbersInSortedMatrix {

    /**
     * Linear Search
     */
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int i=grid.length-1; i>=0; i--) {
            if(grid[i][grid[i].length-1] >= 0) break;

            for(int j=grid[i].length-1; j>=0; j--) {
                if(grid[i][j] < 0) {
                    count++;
                } else {
                    break;
                }
            }
        }


        return count;
    }

    /**
     * Binary Search
     */
    public int countNegativesV2(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; ++i) {
            // add up negative numbers of each row
            res += negativeEachRow(grid[i]);
        }
        return res;
    }

    private int negativeEachRow(int[] row) {
        int res = 0;
        int l = 0, r = row.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (row[mid] >= 0) {
                l = mid + 1;
            } else if (row[mid] < 0) {
                res += r - mid + 1;
                r = mid - 1;
            }
        }

        return res;
    }
}
