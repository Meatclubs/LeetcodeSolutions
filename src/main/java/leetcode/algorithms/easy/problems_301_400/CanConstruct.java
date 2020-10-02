package main.java.leetcode.algorithms.easy.problems_301_400;

import java.util.HashMap;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function
 * that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Example 1:
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 *
 * Example 2:
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 *
 * Example 3:
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 * Constraints:
 * You may assume that both strings contain only lowercase letters.
 */
public class CanConstruct {

    /**
     * Solution with 1 HashMap to store magazine characters
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0; i<magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i),0) + 1);
        }

        for(int i=0; i<ransomNote.length(); i++) {
            map.put(ransomNote.charAt(i), map.getOrDefault(ransomNote.charAt(i),0) - 1);

            if(map.get(ransomNote.charAt(i)) < 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Since question says you can assume characters are only a-z, we can use a 26-long array for faster read/writes.
     * Also uses less memory.
     */
    public boolean canConstructV2(String ransomNote, String magazine) {
        int[] array = new int[26];

        for(int i=0; i<magazine.length(); i++) {
            array[magazine.charAt(i) - 'a'] = array[magazine.charAt(i) - 'a'] + 1;
        }

        for(int i=0; i<ransomNote.length(); i++) {
            array[ransomNote.charAt(i) - 'a'] = array[ransomNote.charAt(i) - 'a'] - 1;

            if(array[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
