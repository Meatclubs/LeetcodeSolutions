package main.java.leetcode.algorithms.easy.problems_301_400;

/**
 * Given a string s and a string t, check if s is subsequence of t.
 * A subsequence of a string is a new string which is formed from the original string by deleting some
 * (can be none) of the characters without disturbing the relative positions of the remaining characters.
 * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to
 * see if T has its subsequence. In this scenario, how would you change your code?
 *
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 *
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 * Constraints:
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * Both strings consists only of lowercase characters.
 */
public class IsSubSequence {
    public boolean isSubsequence(String s, String t) {
        int tIndex = 0;
        for(int i=0; i<s.length(); i++) {
            if(tIndex == t.length()) {
                return false;
            }

            char c = s.charAt(i);

            while(t.charAt(tIndex) != c) {
                tIndex++;

                if(tIndex == t.length()) {
                    return false;
                }
            }

            tIndex++;
        }

        return true;
    }

    /**
     * TODO
     * follow up solution for large numbers of S can be to initialize T into a HashMap<Char,Char[]>()
     * to store the mappings of the first character and every succeeding character.
     * So the algorithm starts at the first letter of S and checks if there's a key-value pair matching to the
     * first and 2nd letters of S. If yes, it moves to check the same with the 2nd and 3rd letters of S and so on.
     *
     * If it reaches the end of S, then S is a subsequence of T. If it fails to find a matching key-value pair,
     * then it is not a subsequence.
     */
}
