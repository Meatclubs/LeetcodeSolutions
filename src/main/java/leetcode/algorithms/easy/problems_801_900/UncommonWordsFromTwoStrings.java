package main.java.leetcode.algorithms.easy.problems_801_900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * We are given two sentences A and B.
 * (A sentence is a string of space separated words. Each word consists only of lowercase letters.)
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 * Return a list of all uncommon words. You may return the list in any order.
 *
 * Example 1:
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 *
 * Example 2:
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 *
 * Note:
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A and B both contain only spaces and lowercase letters.
 */
public class UncommonWordsFromTwoStrings {
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String,Integer> counts = new HashMap<>();

        for(String word : A.concat(" ").concat(B).split(" "))
            counts.put(word, counts.getOrDefault(word,0) + 1);

        List<String> results = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : counts.entrySet()) {
            if(entry.getValue() == 1) results.add(entry.getKey());
        }

        return results.toArray(new String[results.size()]);
    }
}
