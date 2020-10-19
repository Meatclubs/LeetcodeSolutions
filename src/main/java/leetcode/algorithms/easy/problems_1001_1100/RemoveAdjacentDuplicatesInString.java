package main.java.leetcode.algorithms.easy.problems_1001_1100;

/**
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 * We repeatedly make duplicate removals on S until we no longer can.
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 *
 * Example 1:
 * Input: "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.
 * The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 *
 * Note:
 * 1 <= S.length <= 20000
 * S consists only of English lowercase letters.
 */
public class RemoveAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        char[] sss = new char[S.length()];
        int index = 0;
        for(char curr : S.toCharArray()) {
            if(index == 0) {
                sss[index] = curr;
                index++;
                continue;
            }

            if(sss[index-1] == curr) {
                index--;
                sss[index] = ' ';
            } else {
                sss[index] = curr;
                index++;
            }
        }

        String result = new String(sss);
        result = result.trim();

        return result;
    }
}
