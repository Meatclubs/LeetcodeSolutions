package main.java.leetcode.algorithms.easy.problems_401_500;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 */
public class HammingDistance {
    /**
     * Solution using XOR of 2 numbers.
     * XOR-ing the 2 numbers gives a number that has the same number of '1' bits as the number of positions
     * where the 2 corresponding bits of the initial two numbers are different.
     *
     * After that, we just need to count the number of '1' bits in the resultant XOR number and return that value.
     */
    public int hammingDistance(int x, int y) {
        int diff = x ^ y;
        int distance = 0;

        while(diff > 0) {
            if(diff % 2 == 1) {
                distance++;
            }
            diff = diff/2;
        }

        return distance;
    }
}
