package main.java.leetcode.algorithms.easy.problems_501_600;

/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2*k characters counting from
 * the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2*k
 * but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 *
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */
public class ReverseString2 {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();

        for(int i=0; i<arr.length; i += 2*k) {
            int endIndex = i+k <= arr.length-1 ? i+k : arr.length;
            arr = reverse(arr, i, endIndex);
        }

        return new String(arr);
    }

    private char[] reverse(char[] arr, int start, int end) {
        int mid = (end-start) / 2;

        for(int i=0; i<mid; i++) {
            char temp = arr[start+i];
            arr[start+i] = arr[end-1-i];
            arr[end-1-i] = temp;
        }

        return arr;
    }
}
