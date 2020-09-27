package main.java.leetcode.algorithms.easy.problems_201_300;

import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 *
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 *
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 *
 * Note:
 * You may assume both s and t have the same length.
 */
public class IsomorphicStrings {
    /**
     * Original solution using hashmap to store mapping.
     * Memory usage is good, but speed can be improved.
     */
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();

        for(int i=0; i<t.length(); i++) {
            if(map.containsKey(t.charAt(i))) {
                if(map.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            } else if(map.containsValue(s.charAt(i))) {
                return false;
            } else {
                map.put(t.charAt(i), s.charAt(i));
            }
        }

        return true;
    }

    /**
     * Alternative solution using 2x char arrays.
     * It seems inserting and retrieving values from char arrays is faster than using hashmaps.
     */
    public boolean isIsomorphicV2(String s, String t) {
        char[] map = new char[256];
        char[] set = new char[256];

        for(int i=0;i<s.length();i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(map[ch1] !=  0){
                if(ch2 != map[ch1]) {
                    return false;
                }
            }else{
                if(set[ch2] != 0) {
                    return false; // already mapped
                }
                map[ch1] = ch2;
                set[ch2] = ch2; // This char is now mapped so can't be remapped
            }
        }

        return true;
    }
}
