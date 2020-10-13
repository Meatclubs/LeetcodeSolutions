package main.java.leetcode.algorithms.easy.problems_701_800;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of strings words representing an English Dictionary, find the longest word in words that can be built
 * one character at a time by other words in words. If there is more than one possible answer,
 * return the longest word with the smallest lexicographical order.
 *
 * If there is no answer, return the empty string.
 * Example 1:
 * Input:
 * words = ["w","wo","wor","worl", "world"]
 * Output: "world"
 * Explanation:
 * The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 *
 * Example 2:
 * Input:
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * Output: "apple"
 * Explanation:
 * Both "apply" and "apple" can be built from other words in the dictionary.
 * However, "apple" is lexicographically smaller than "apply".
 *
 * Note:
 * All the strings in the input will only contain lowercase letters.
 * The length of words will be in the range [1, 1000].
 * The length of words[i] will be in the range [1, 30].
 */
public class LongestWordInDictionary {

    //TODO learn how to solve the problem using Trie data structure
    public String longestWord(String[] words) {
        String longestWord = "";

        //add all input words to set
        Set<String> set = new HashSet<>();
        for(String word : words) set.add(word);

        //check if word has all substrings in the set
        for(String word : words) {
            boolean isOk = true;

            for(int i=1; i<word.length(); i++) {
                if(!set.contains(word.substring(0,i))) {
                    isOk = false;
                    break;
                }
            }

            if(isOk) {
                if(word.length() > longestWord.length()) {
                    longestWord = word;
                } else if (word.length() == longestWord.length()) {
                    if(word.compareTo(longestWord) < 0) {
                        longestWord = word;
                    }
                }
            }
        }

        return longestWord;
    }
}
