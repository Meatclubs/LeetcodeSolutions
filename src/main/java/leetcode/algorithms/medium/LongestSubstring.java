package main.java.leetcode.algorithms.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Example 4:
 * Input: s = ""
 * Output: 0
 *
 * Constraints:
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        //take care of edge cases first
        if(s.length() == 0) {
            return 0;
        } else if(s.length() == 1) {
            return 1;
        }

        Map<Character,Integer> map = new HashMap<>();

        int startIndex = 0;
        int endIndex = 0;
        int length = 0;

        while(endIndex != s.length()) {

            if(map.containsKey(s.charAt(endIndex))) {
                if(map.get(s.charAt(endIndex)) >= startIndex) {
                    startIndex = map.get(s.charAt(endIndex)) + 1;
                }
            }

            if(endIndex - startIndex + 1 > length) {
                length = endIndex - startIndex + 1;
            }

            map.put(s.charAt(endIndex),endIndex);

            endIndex++;
        }

        return length;
    }
}
