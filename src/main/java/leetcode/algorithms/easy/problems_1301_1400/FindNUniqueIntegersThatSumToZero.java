package main.java.leetcode.algorithms.easy.problems_1301_1400;

/**
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 *
 * Example 1:
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 *
 * Example 2:
 * Input: n = 3
 * Output: [-1,0,1]
 *
 * Example 3:
 * Input: n = 1
 * Output: [0]
 *
 * Constraints:
 * 1 <= n <= 1000
 */
public class FindNUniqueIntegersThatSumToZero {
    public int[] sumZero(int n) {
        int[] res = new int[n];

        int value = 1;
        int i = 0;

        if(n % 2 != 0) {
            res[0] = 0;
            i++;
        }

        while(i<res.length) {
            res[i] = value;
            res[i+1] = value * -1;

            value++;
            i += 2;
        }

        return res;
    }
}
