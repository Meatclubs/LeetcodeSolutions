package main.java.leetcode.algorithms.easy.problems_401_500;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 *
 * Example:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 *
 * Note:
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        int[] rows = {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};

        List<String> list = new ArrayList<>();

        for(int i=0; i<words.length; i++) {
            int row = rows[Character.toLowerCase(words[i].charAt(0)) - 'a'];
            boolean ok = true;

            for(int j=0; j<words[i].length(); j++) {

                //check if each letter in the word is on the same row as the first character of the word
                if(rows[Character.toLowerCase(words[i].charAt(j)) - 'a'] != row) {
                    ok = false;
                    break;
                }
            }

            if(ok) {
                list.add(words[i]);
            }
        }

        String[] result = new String[list.size()];
        return list.toArray(result);
    }
}
