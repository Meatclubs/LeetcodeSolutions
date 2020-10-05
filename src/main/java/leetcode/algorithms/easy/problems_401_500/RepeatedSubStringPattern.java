package main.java.leetcode.algorithms.easy.problems_401_500;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it
 * and appending multiple copies of the substring together. You may assume the given
 * string consists of lowercase English letters only and its length will not exceed 10000.
 *
 * Example 1:
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 *
 * Example 2:
 * Input: "aba"
 * Output: False
 *
 * Example 3:
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubStringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int[] freq = new int[125];
        char[] sss = s.toCharArray();

        /**
         * get frequency of occurrences for each character
         */
        for(int i = 0; i<s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        /**
         * get the greater common factor for all the occurrence values
         */
        int gcf = 0;
        for(int i = 'a'; i <= 'z'; i++) {
            if(gcf == 0) {
                gcf = freq[i];
                continue;
            } else {
                gcf = getGreatestCommonFactor(gcf, freq[i]);
            }

            /**
             * if greatest common factor == 1, then there are no repeated substring,
             * hence, we can return false.
             */
            if(gcf == 1) { return false; }
        }

        /**
         * We compare substrings of all lengths from 2 to the greatest common factor.
         *
         */
        for(int i=2; i<= gcf; i++) {
            if(gcf % i != 0) {
                continue;
            }

            int sslen = s.length() / i;
            boolean ok = true;
            for(int j=sslen; j<s.length(); j++) {
                if(sss[j] != sss[j-sslen]) {
                    ok = false;
                }
            }

            if(ok) { return true; }
        }

        return false;
    }

    private int getGreatestCommonFactor(int gcf, int num) {
        while (gcf != 0) {
            int remainder = num % gcf;
            num = gcf;
            gcf = remainder;
        }
        return num;
    }
}
