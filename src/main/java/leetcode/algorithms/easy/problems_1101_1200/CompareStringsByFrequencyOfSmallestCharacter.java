package main.java.leetcode.algorithms.easy.problems_1101_1200;

import java.util.Arrays;

/**
 * Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s.
 * For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.
 * Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of
 * words such that f(queries[i]) < f(W), where W is a word in words.
 *
 * Example 1:
 * Input: queries = ["cbd"], words = ["zaaaz"]
 * Output: [1]
 * Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
 *
 * Example 2:
 * Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * Output: [1,2]
 * Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
 *
 * Constraints:
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j], words[i][j] are English lowercase letters.
 */
public class CompareStringsByFrequencyOfSmallestCharacter {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] queryFreq = new int[queries.length];
        int[] wordsFreq = new int[words.length];

        for(int i=0; i<queries.length; i++)
            queryFreq[i] = getFrequency(queries[i]);

        for(int i=0; i<words.length; i++)
            wordsFreq[i] = getFrequency(words[i]);

        Arrays.sort(wordsFreq);

        for(int i=0; i<queryFreq.length; i++) {
            int count = 0;
            for(int j=0; j<wordsFreq.length; j++) {
                if(wordsFreq[j] > queryFreq[i]) {
                    count = wordsFreq.length - j;
                    break;
                }
            }

            queryFreq[i] = count;
        }


        return queryFreq;
    }

    private int getFrequency(String word) {
        int[] chars = new int[26];

        for(char cc : word.toCharArray()) {
            chars[cc - 'a']++;
        }

        for(int i=0; i<chars.length; i++) {
            if(chars[i] > 0) return chars[i];
        }

        return 0;
    }
}
