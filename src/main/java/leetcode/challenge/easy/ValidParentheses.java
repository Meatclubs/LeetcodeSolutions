package main.java.leetcode.challenge.easy;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Example 4:
 * Input: s = "([)]"
 * Output: false
 *
 * Example 5:
 * Input: s = "{[]}"
 * Output: true
 *
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        /**
         * This solution uses an array of chars to simulate stack behaviour
         */
        char[] chars = new char[1 + s.length()/2];
        int charArrIndex = -1;

        for(int i=0; i<s.length(); i++) {
            if(charArrIndex >= s.length()/2) {
                return false;
            }

            if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[' ) {
                charArrIndex++;
                chars[charArrIndex] = s.charAt(i);
            } else if(charArrIndex>=0 && s.charAt(i) == '}' && chars[charArrIndex] == '{') {
                chars[charArrIndex] = ' ';
                charArrIndex--;
            } else if(charArrIndex>=0 && s.charAt(i) == ')' &&  chars[charArrIndex] == '(') {
                chars[charArrIndex] = ' ';
                charArrIndex--;
            } else if(charArrIndex>=0 && s.charAt(i) == ']' &&  chars[charArrIndex] == '[') {
                chars[charArrIndex] = ' ';
                charArrIndex--;
            } else {
                return false;
            }
        }

        /**
         * if charArrIndex < 0, then that means there's no characters in the array.
         * i.e. All opening brackets were removed due to having a corresponding closing bracket after them.
         */
        if(charArrIndex < 0) {
            return true;
        } else {
            return false;
        }
    }

}
