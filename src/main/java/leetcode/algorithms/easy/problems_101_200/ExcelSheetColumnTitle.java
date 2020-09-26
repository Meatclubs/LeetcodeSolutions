package main.java.leetcode.algorithms.easy.problems_101_200;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 *
 * Example 1:
 * Input: 1
 * Output: "A"
 *
 * Example 2:
 * Input: 28
 * Output: "AB"
 *
 * Example 3:
 * Input: 701
 * Output: "ZY"
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        //+64 to get uppercase alphabet character;
        StringBuilder sb = new StringBuilder();

        while(n>0) {
            int remainder = n%26;

            if(remainder == 0) {
                n--;
                remainder = 26;
            }

            char chr = (char) (remainder + 64);
            n = n/26;
            sb.append(chr);
        }

        return sb.reverse().toString();
    }
}
