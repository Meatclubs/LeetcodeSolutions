package main.java.leetcode.challenge.easy.problems_1_100;

/**
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Clarification:
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 * Constraints:
 * haystack and needle consist only of lowercase English characters.
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {

        if(needle.length() == 0) {
            return 0;
        } else if(needle.length() > haystack.length()) {
            return -1;
        }

        /**
         * We minus the needle length since we don't need the remaining last part of the haystack
         * if the initial characters do not match.
         */
        for(int i=0; i<haystack.length()-needle.length()+1; i++) {

            if(haystack.charAt(i) == needle.charAt(0)) {
                boolean found = true;

                for(int j=1; j<needle.length(); j++) {
                    if(haystack.charAt(i+j) != needle.charAt(j)) {
                        found = false;
                        break;
                    }
                }

                if(found) {
                    return i;
                }
            }
        }

        return -1;
    }
}
