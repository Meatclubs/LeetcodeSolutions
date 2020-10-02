package main.java.leetcode.algorithms.easy.problems_301_400;

/**
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode"
 * return 2.
 *
 * Note: You may assume the string contains only lowercase English letters.
 */
public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        int[] array = new int[26];
        int length = s.length();

        for(int i=0; i<length; i++) {
            array[s.charAt(i) - 'a'] += 1;
        }

        for(int i=0; i<length; i++) {
            if(array[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
