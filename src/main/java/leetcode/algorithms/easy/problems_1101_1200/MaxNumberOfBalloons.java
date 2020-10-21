package main.java.leetcode.algorithms.easy.problems_1101_1200;

/**
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 *
 * Example 1:
 * Input: text = "nlaebolko"
 * Output: 1
 *
 * Example 2:
 * Input: text = "loonbalxballpoon"
 * Output: 2
 *
 * Example 3:
 * Input: text = "leetcode"
 * Output: 0
 *
 * Constraints:
 * 1 <= text.length <= 10^4
 * text consists of lower case English letters only.
 */
public class MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] chars = new int[26];

        for(char cc : text.toCharArray()) {
            chars[cc - 'a']++;
        }

        int balloons = Integer.MAX_VALUE;
        balloons = Math.min(balloons, chars['b' - 'a']);
        balloons = Math.min(balloons, chars['a' - 'a']);
        balloons = Math.min(balloons, chars['l' - 'a'] / 2);
        balloons = Math.min(balloons, chars['o' - 'a'] / 2);
        balloons = Math.min(balloons, chars['n' - 'a']);

        return balloons;
    }
}
