package main.java.leetcode.algorithms.easy.problems_901_1000;

/**
 * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long
 * pressed, and the character will be typed 1 or more times.
 * You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name,
 * with some characters (possibly none) being long pressed.
 *
 * Example 1:
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 *
 * Example 2:
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
 *
 * Example 3:
 * Input: name = "leelee", typed = "lleeelee"
 * Output: true
 *
 * Example 4:
 * Input: name = "laiden", typed = "laiden"
 * Output: true
 * Explanation: It's not necessary to long press any character.
 *
 * Constraints:
 * 1 <= name.length <= 1000
 * 1 <= typed.length <= 1000
 * The characters of name and typed are lowercase letters.
 */
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int index = 0;
        char prev = '#';

        for(int i=0; i<typed.length(); i++) {
            if(index < name.length() && typed.charAt(i) == name.charAt(index)) {
                index++;
                prev = typed.charAt(i);
            } else {
                if(typed.charAt(i) == prev) continue;
                else return false;
            }
        }

        if(index != name.length()) return false;

        return true;
    }
}
