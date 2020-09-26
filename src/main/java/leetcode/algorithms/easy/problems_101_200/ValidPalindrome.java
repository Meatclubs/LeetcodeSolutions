package main.java.leetcode.algorithms.easy.problems_101_200;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Example 2:
 * Input: "race a car"
 * Output: false
 *
 * Constraints:
 * s consists only of printable ASCII characters.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s.length() < 2) {
            return true;
        }

        s = s.toLowerCase();

        int startIndex = 0;
        int endIndex = s.length()-1;

        while(startIndex < endIndex) {
            while(!isValidChar(s.charAt(startIndex)) && startIndex < endIndex)  {
                startIndex++;
            }
            while(!isValidChar(s.charAt(endIndex)) && startIndex < endIndex)  {
                endIndex--;
            }

            if(s.charAt(startIndex) != s.charAt(endIndex)) {
                return false;
            }

            startIndex++;
            endIndex--;
        }

        return true;
    }

    private boolean isValidChar(char c) {
        return (c <= 'z' && c >= 'a') || (c <= '9' && c >= '0');
    }
}
