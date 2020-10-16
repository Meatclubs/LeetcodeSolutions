package main.java.leetcode.algorithms.easy.problems_901_1000;

/**
 * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
 * If S[i] == "I", then A[i] < A[i+1]
 * If S[i] == "D", then A[i] > A[i+1]
 *
 * Example 1:
 * Input: "IDID"
 * Output: [0,4,1,3,2]
 *
 * Example 2:
 * Input: "III"
 * Output: [0,1,2,3]
 *
 * Example 3:
 * Input: "DDI"
 * Output: [3,2,0,1]
 *
 * Note:
 * 1 <= S.length <= 10000
 * S only contains characters "I" or "D".
 */
public class DIStringMatch {
    public int[] diStringMatch(String S) {
        int plus = 0;
        int minus = 0;
        int index = 1;
        int[] res = new int[S.length()+1];

        for(char c : S.toCharArray()) {
            if(c == 'D') {
                minus++;
                res[index] -= minus;
            }
            if(c == 'I') {
                plus++;
                res[index] += plus;
            }
            index++;
        }

        //normalize
        for(int i=0; i<res.length; i++) {
            res[i] += minus;
        }

        return res;
    }
}
