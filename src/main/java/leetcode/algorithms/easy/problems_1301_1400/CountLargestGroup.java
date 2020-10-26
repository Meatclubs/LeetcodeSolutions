package main.java.leetcode.algorithms.easy.problems_1301_1400;

/**
 * Given an integer n. Each number from 1 to n is grouped according to the sum of its digits.
 * Return how many groups have the largest size.
 *
 * Example 1:
 * Input: n = 13
 * Output: 4
 * Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
 * [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9]. There are 4 groups with largest size.
 *
 * Example 2:
 * Input: n = 2
 * Output: 2
 * Explanation: There are 2 groups [1], [2] of size 1.
 *
 * Example 3:
 * Input: n = 15
 * Output: 6
 *
 * Example 4:
 * Input: n = 24
 * Output: 5
 *
 * Constraints:
 * 1 <= n <= 10^4
 */
public class CountLargestGroup {
    public int countLargestGroup(int n) {
        //max value of n is 10000, means max sum is 36 (from 9999)
        int[] groups = new int[37];

        for(int i=1; i<=n; i++) {
            groups[getSum(i)]++;
        }

        int max = 0;
        int num = 0;
        for(int i=0; i<groups.length; i++) {
            if(groups[i] == max) {
                num++;
            }

            if(groups[i] > max) {
                num = 1;
                max = groups[i];
            }
        }

        return num;
    }

    private int getSum(int n) {
        int sum = 0;

        while(n > 0) {
            sum += (n%10);
            n /= 10;
        }

        return sum;
    }
}
