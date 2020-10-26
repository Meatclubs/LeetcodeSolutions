package main.java.leetcode.algorithms.easy.problems_1401_1500;

/**
 * Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).
 * You have to find a permutation of the string where no letter is followed by another letter and no digit is followed
 * by another digit. That is, no two adjacent characters have the same type.
 * Return the reformatted string or return an empty string if it is impossible to reformat the string.
 *
 * Example 1:
 * Input: s = "a0b1c2"
 * Output: "0a1b2c"
 * Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
 *
 * Example 2:
 * Input: s = "leetcode"
 * Output: ""
 * Explanation: "leetcode" has only characters so we cannot separate them by digits.
 *
 * Example 3:
 * Input: s = "1229857369"
 * Output: ""
 * Explanation: "1229857369" has only digits so we cannot separate them by characters.
 *
 * Example 4:
 * Input: s = "covid2019"
 * Output: "c2o0v1i9d"
 *
 * Example 5:
 * Input: s = "ab123"
 * Output: "1a2b3"
 *
 * Constraints:
 * 1 <= s.length <= 500
 * s consists of only lowercase English letters and/or digits.
 */
public class ReformatTheString {
    public String reformat(String s) {
        int charIndex = 0;
        int numIndex = 0;
        int charCount = 0;
        int numCount = 0;

        char[] sss = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        while(charIndex < s.length() && numIndex < s.length()) {
            if(!('a' <= sss[charIndex] && sss[charIndex] <= 'z')) {
                charIndex++;
                continue;
            }
            if(!('0' <= sss[numIndex] && sss[numIndex] <= '9')) {
                numIndex++;
                continue;
            }

            sb.append(sss[charIndex]);
            sb.append(sss[numIndex]);

            charIndex++;
            numIndex++;

            charCount++;
            numCount++;
        }

        /**
         * append remaining characters
         */
        while(charIndex < s.length()) {
            if(!('a' <= sss[charIndex] && sss[charIndex] <= 'z')) {
                charIndex++;
                continue;
            }
            sb.append(sss[charIndex]);
            charIndex++;
            charCount++;
        }

        /**
         * insert remaining numbers to the front
         */
        while(numIndex < s.length()) {
            if(!('0' <= sss[numIndex] && sss[numIndex] <= '9')) {
                numIndex++;
                continue;
            }
            sb = sb.insert(0,sss[numIndex]);
            numIndex++;
            numCount++;
        }

        /**
         * if the number of numbers and characters have a difference of more than 1, then string is invalid
         */
        if(Math.abs(numCount - charCount) > 1) return "";

        return sb.toString();
    }
}
