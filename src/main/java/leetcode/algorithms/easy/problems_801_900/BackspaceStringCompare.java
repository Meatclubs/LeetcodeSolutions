package main.java.leetcode.algorithms.easy.problems_801_900;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * Example 1:
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 *
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 *
 * Example 3:
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 *
 * Example 4:
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 *
 * Note:
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 *
 * Follow up:
 * Can you solve it in O(N) time and O(1) space?
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        S = type(S);
        T = type(T);

        return S.equals(T);
    }

    private String type(String str) {
        StringBuilder sb = new StringBuilder();
        char[] sss = str.toCharArray();
        int backspace = 0;

        for(int i=sss.length-1; i>=0; i--) {
            if('a' <= sss[i] && sss[i] <= 'z') {
                if(backspace == 0) {
                    sb.append(sss[i]);
                } else {
                    backspace--;
                }
            } else {
                backspace++;
            }
        }
        return sb.reverse().toString();
    }

    /**
     * O(1) additional space
     */
    public boolean backspaceCompareV2(String S, String T) {
        int sss = S.length()-1;
        int ttt = T.length()-1;
        int sbs = 0;
        int tbs = 0;

        while(sss >=0 || ttt >= 0) {
            while(sss >= 0) {
                if(S.charAt(sss) == '#') {
                    sbs++;
                    sss--;
                } else if(sbs > 0) {
                    sbs--;
                    sss--;
                } else {
                    break;
                }
            }

            while(ttt >= 0) {
                if(T.charAt(ttt) == '#') {
                    tbs++;
                    ttt--;
                } else if(tbs > 0) {
                    tbs--;
                    ttt--;
                } else {
                    break;
                }
            }

            //if 1 string is traversed and the other is not yet finished
            if((sss < 0) != (ttt < 0)) return false;

            if(sss >= 0 && ttt >= 0 && S.charAt(sss) != T.charAt(ttt)) return false;

            ttt--;
            sss--;
        }

        return true;
    }

}
