package main.java.leetcode.algorithms.easy.problems_801_900;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 * Words in the list of banned words are given in lowercase, and free of punctuation.
 * Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 * Example:
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 *
 * Note:
 * 1 <= paragraph.length <= 1000.
 * 0 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 */
public class MostCommonWord {
    /**
     * Standard String processing pipeline
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String,Integer> map = new HashMap<>();

        //put banned words into a set
        HashSet<String> bannedSet = new HashSet<>();
        bannedSet.addAll(Arrays.asList(banned));

        //replace punctuations and non-word characters
        paragraph = paragraph.replaceAll("[^a-zA-Z0-9\\s]", " ").toLowerCase();

        //split into words
        String[] words = paragraph.split("\\s+");

        //count words
        for(String word : words) {
            map.put(word, map.getOrDefault(word,0) + 1);
        }

        int maxCount = 0;
        String commonWord = "";

        //check banned and get most common word
        for(String key : map.keySet()) {
            if(bannedSet.contains(key)) continue;

            if(map.get(key) > maxCount) {
                maxCount = map.get(key);
                commonWord = key;
            }
        }

        return commonWord;
    }

    /**
     * Processing in one pass character by character
     */
    public String mostCommonWordV2(String paragraph, String[] banned) {
        HashMap<String,Integer> map = new HashMap<>();

        //put banned words into a set
        HashSet<String> bannedSet = new HashSet<>();
        bannedSet.addAll(Arrays.asList(banned));

        //replace punctuations and non-word characters
        paragraph = paragraph.toLowerCase();

        int maxCount = 0;
        String commonWord = "";

        StringBuilder sb = new StringBuilder();
        char[] arr = paragraph.toCharArray();

        for(int i=0; i<arr.length; i++) {
            if(arr[i] >= 'a' && arr[i] <= 'z') {
                sb.append(arr[i]);

                if(i != arr.length-1) continue; //skip end of word processing if not the last character
            }

            //end of word processing
            String word = sb.toString();
            sb = new StringBuilder();
            if(!word.equalsIgnoreCase("") && !bannedSet.contains(word)) {
                map.put(word, map.getOrDefault(word,0) + 1);
                if(map.get(word) > maxCount) {
                    maxCount = map.get(word);
                    commonWord = word;
                }
            }
        }

        return commonWord;
    }
}
