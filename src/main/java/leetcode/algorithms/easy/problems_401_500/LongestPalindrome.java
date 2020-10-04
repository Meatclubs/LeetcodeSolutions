package main.java.leetcode.algorithms.easy.problems_401_500;

/**
 * Given a string s which consists of lowercase or uppercase letters,
 * return the length of the longest palindrome that can be built with those letters.
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 *
 * Example 1:
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 * Example 2:
 * Input: s = "a"
 * Output: 1
 * 
 * Example 3:
 * Input: s = "bb"
 * Output: 2
 *
 * Constraints:
 * 1 <= s.length <= 2000
 * s consits of lower-case and/or upper-case English letters only.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {

        int length = 0;
        boolean hasCentreChar = false;
        char[] arr = new char[128];

        for(int i=0; i<s.length(); i++) {
            arr[s.charAt(i)] += 1;
        }

        for(int i=0; i<arr.length; i++) {
            if(arr[i] % 2 == 1) {
                hasCentreChar = true;
                length += arr[i]-1;
            } else {
                length += arr[i];
            }
        }

        if(hasCentreChar) {
            length++;
        }

        return length;
    }
}
