package main.java.leetcode.algorithms.easy.problems_301_400;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 * Input: "hello"
 * Output: "holle"
 *
 * Example 2:
 * Input: "leetcode"
 * Output: "leotcede"
 *
 * Note:
 * The vowels does not include the letter "y".
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
        if(s.length() < 2) {
            return s;
        }

        int firstPointer = 0;
        int lastPointer = s.length()-1;

        char[] arr = s.toCharArray();

        while(firstPointer < lastPointer) {
            if(!isVowel(arr[firstPointer])) {
                firstPointer++;
            }

            if(!isVowel(arr[lastPointer])) {
                lastPointer--;
            }

            if(isVowel(arr[lastPointer]) && isVowel(arr[firstPointer])) {
                char temp = arr[lastPointer];
                arr[lastPointer] = arr[firstPointer];
                arr[firstPointer] = temp;

                firstPointer++;
                lastPointer--;
            }
        }

        return String.valueOf(arr);
    }

    public boolean isVowel(char c) {
        if(c == 'a' || c == 'A'
                || c == 'e' || c == 'E'
                || c == 'i' || c == 'I'
                || c == 'o' || c == 'O'
                || c == 'u' || c == 'U') {
            return true;
        } else {
            return false;
        }
    }
}
