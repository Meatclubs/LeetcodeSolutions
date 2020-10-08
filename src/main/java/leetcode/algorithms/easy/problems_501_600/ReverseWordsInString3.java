package main.java.leetcode.algorithms.easy.problems_501_600;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while
 * still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsInString3 {
    public String reverseWords(String s) {
        s = s.trim();
        if(s.isEmpty()) { return ""; }

        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<words.length; i++) {
            words[i] = reverse(words[i]);
            sb.append(words[i]).append(" ");
        }

        return sb.toString().trim();
    }


    private String reverse(String word) {
        char[] chars = word.toCharArray();

        for(int i=0; i<word.length()/2; i++) {
            char temp = chars[i];
            chars[i] = chars[word.length()-1-i];
            chars[word.length()-1-i] = temp;
        }

        return new String(chars);
    }
}
