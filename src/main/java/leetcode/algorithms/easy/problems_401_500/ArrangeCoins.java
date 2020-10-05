package main.java.leetcode.algorithms.easy.problems_401_500;

/**
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 *
 * Example 1:
 * n = 5
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * Because the 3rd row is incomplete, we return 2.
 *
 * Example 2:
 * n = 8
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * Because the 4th row is incomplete, we return 3.
 */
public class ArrangeCoins {
    public int arrangeCoins(int n) {
        long limit = 2 * (long) n;

        long sqrt = (long) Math.pow(limit, 0.5);
        long result = (long) Math.pow(limit-sqrt, 0.5);

        return (int) result;
    }
}
