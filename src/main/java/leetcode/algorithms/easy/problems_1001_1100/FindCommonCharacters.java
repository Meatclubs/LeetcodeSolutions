package main.java.leetcode.algorithms.easy.problems_1001_1100;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all
 * strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not
 * 4 times, you need to include that character three times in the final answer.
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 *
 * Example 2:
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 *
 * Note:
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] is a lowercase letter
 */
public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        int[] counts = new int[26];

        for(char ccc : A[0].toCharArray()) {
            counts[ccc - 'a'] += 1;
        }

        for(int i=1; i<A.length; i++) {
            int[] count = new int[26];
            for(char ccc : A[i].toCharArray()) {
                count[ccc - 'a'] += 1;
            }

            for(int j=0; j<26; j++) {
                counts[j] = Math.min(counts[j], count[j]);
            }
        }

        List<String> result = new ArrayList<>();
        for(int j=0; j<26; j++) {
            for(int k=0; k<counts[j]; k++) {
                result.add(String.valueOf((char) ('a' + j)));
            }
        }

        return result;
    }
}
