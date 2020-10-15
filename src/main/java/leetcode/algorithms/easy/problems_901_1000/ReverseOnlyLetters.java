package main.java.leetcode.algorithms.easy.problems_901_1000;

/**
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place,
 * and all letters reverse their positions.
 *
 * Example 1:
 * Input: "ab-cd"
 * Output: "dc-ba"
 *
 * Example 2:
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 *
 * Example 3:
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 *
 * Note:
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S doesn't contain \ or "
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] sss = S.toCharArray();
        int first = 0;
        int last = sss.length-1;

        while(first < last) {
            if(!isChar(sss[first])) {
                first++;
                continue;
            }
            if(!isChar(sss[last])) {
                last--;
                continue;
            }

            char temp = sss[first];
            sss[first] = sss[last];
            sss[last] = temp;

            first++;
            last--;
        }

        return new String(sss);
    }

    private boolean isChar(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }
}
