package main.java.leetcode.algorithms.easy.problems_1201_1300;

/**
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 * Given a balanced string s split it in the maximum amount of balanced strings.
 * Return the maximum amount of splitted balanced strings.
 *
 * Example 1:
 * Input: s = "RLRRLLRLRL"
 * Output: 4
 * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 *
 * Example 2:
 * Input: s = "RLLLLRRRLR"
 * Output: 3
 * Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
 *
 * Example 3:
 * Input: s = "LLLLRRRR"
 * Output: 1
 * Explanation: s can be split into "LLLLRRRR".
 *
 * Example 4:
 * Input: s = "RLRRRLLRLL"
 * Output: 2
 * Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s[i] = 'L' or 'R'
 */
public class SplitAStringInBalancedString {
    public int balancedStringSplit(String s) {
        int R = 0;
        int L = 0;

        int count = 0;
        for(char cc : s.toCharArray()) {
            if(cc == 'R') R++;
            if(cc == 'L') L++;

            if(R == L && R != 0) {
                count++;
                R = 0;
                L = 0;
            }
        }

        return count;
    }
}
