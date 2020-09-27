package main.java.leetcode.algorithms.easy.problems_201_300;

import java.util.HashMap;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {
    /**
     * Using HashMap - not the fastest or most memory-efficient solution.
     * But works for all types of input strings, including strings containing unicode characterss.
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        Character chr = null;

        for(int i=0; i<s.length(); i++) {
            chr = s.charAt(i);
            if(map.containsKey(chr)) {
                map.put(chr, map.get(chr)+1);
            } else {
                map.put(chr,1);
            }
        }

        for(int i=0; i<t.length(); i++) {
            chr = t.charAt(i);
            if(map.containsKey(chr)) {
                if(map.get(chr) == 0) {
                    return false;
                }
                map.put(chr, map.get(chr)-1);
            } else {
                return false;
            }
        }

        return true;
    }
}
