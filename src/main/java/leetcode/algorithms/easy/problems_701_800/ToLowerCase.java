package main.java.leetcode.algorithms.easy.problems_701_800;

/**
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 *
 * Example 1:
 * Input: "Hello"
 * Output: "hello"
 *
 * Example 2:
 * Input: "here"
 * Output: "here"
 *
 * Example 3:
 * Input: "LOVELY"
 * Output: "lovely"
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        //increase by 32 indices

        char[] sss = str.toCharArray();

        for(int i=0; i<sss.length; i++) {
            if(sss[i] >= 'A' && sss[i] <= 'Z') {
                sss[i] += 32;
            }
        }

        return String.valueOf(sss);
    }
}
