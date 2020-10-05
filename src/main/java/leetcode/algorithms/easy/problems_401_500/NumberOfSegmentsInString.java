package main.java.leetcode.algorithms.easy.problems_401_500;

/**
 * You are given a string s, return the number of segments in the string.
 * A segment is defined to be a contiguous sequence of non-space characters.
 *
 * Example 1:
 * Input: s = "Hello, my name is John"
 * Output: 5
 * Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
 *
 * Example 2:
 * Input: s = "Hello"
 * Output: 1
 *
 * Example 3:
 * Input: s = "love live! mu'sic forever"
 * Output: 4
 *
 * Example 4:
 * Input: s = ""
 * Output: 0
 *
 * Constraints:
 * 0 <= s.length <= 300
 * s consists of lower-case and upper-case English letters, digits or one of the following characters "!@#$%^&*()_+-=',.:".
 * The only space character in s is ' '.
 */
public class NumberOfSegmentsInString {
    public int countSegments(String s) {
        s = s.trim();
        if(s.length() == 0) { return 0; }
        if(s.length() < 3) { return 1; }

        int segs = 1;

        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) != ' ' && s.charAt(i-1) == ' ') {
                segs++;
            }
        }

        return segs;
    }

    public int countSegmentsV2(String s) {
        s = s.trim();
        if (s.equals("")) {
            return 0;
        }
        return s.split("\\s+").length;
    }
}
