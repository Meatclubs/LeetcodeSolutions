package main.java.leetcode.algorithms.easy.problems_1101_1200;

/**
 * You are given an array of strings words and a string chars.
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 * Return the sum of lengths of all good strings in words.
 *
 * Example 1:
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation:
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 *
 * Example 2:
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation:
 * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 *
 * Note:
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * All strings contain lowercase English letters only.
 */
public class WordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] charArr = new int[26];
        int sum = 0;

        for(char cc : chars.toCharArray()) {
            charArr[cc - 'a']++;
        }


        for(String word : words) {
            int[] charss = charArr.clone();
            boolean good = true;

            for(char cc : word.toCharArray()) {
                charss[cc - 'a']--;
                if(charss[cc - 'a'] < 0) {
                    good = false;
                    break;
                }
            }


            if(good) sum += word.length();
        }

        return sum;
    }
}
