package main.java.leetcode.algorithms.easy.problems_1_100;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 *
 * Example:
 * Input: "Hello World"
 * Output: 5
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {

        s = s.strip(); //remove leading and trailing whitespaces

        if(s.equals("")) {
            return 0;
        }

        int length = 0;

        for(int i = s.length() - 1; i>=0; i--) {
            if(s.charAt(i) == ' ') {
                break;
            } else {
                length++;
            }
        }

        return length;
    }
}
