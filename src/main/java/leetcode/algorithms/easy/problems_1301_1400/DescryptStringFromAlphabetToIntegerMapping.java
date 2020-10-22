package main.java.leetcode.algorithms.easy.problems_1301_1400;

/**
 * Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:
 * Characters ('a' to 'i') are represented by ('1' to '9') respectively.
 * Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
 * Return the string formed after mapping.
 * It's guaranteed that a unique mapping will always exist.
 *
 * Example 1:
 * Input: s = "10#11#12"
 * Output: "jkab"
 * Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 *
 * Example 2:
 * Input: s = "1326#"
 * Output: "acz"
 *
 * Example 3:
 * Input: s = "25#"
 * Output: "y"
 *
 * Example 4:
 * Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * Output: "abcdefghijklmnopqrstuvwxyz"
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s[i] only contains digits letters ('0'-'9') and '#' letter.
 * s will be valid string such that mapping is always possible.
 */
public class DescryptStringFromAlphabetToIntegerMapping {
    public String freqAlphabets(String s) {
        //+96 for lower case character
        char[] sss = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i=sss.length-1; i>=0; i--) {
            if(sss[i] == '#') {
                int firstDigit = Integer.valueOf(String.valueOf(sss[i-2])) * 10;
                int secondDigit = Integer.valueOf(String.valueOf(sss[i-1]));
                char c = (char) (firstDigit + secondDigit + 96);
                sb.append(c);
                i -= 2;
            } else {
                char c = (char) (Integer.parseInt(String.valueOf(sss[i])) + 96);
                sb.append(c);
            }
        }

        return sb.reverse().toString();
    }
}
