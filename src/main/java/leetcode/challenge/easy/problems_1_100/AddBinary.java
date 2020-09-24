package main.java.leetcode.challenge.easy.problems_1_100;

/**
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 * Constraints:
 * Each string consists only of '0' or '1' characters.
 * 1 <= a.length, b.length <= 10^4
 * Each string is either "0" or doesn't contain any leading zero.
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        /**
         * Make a the shorter string
         */
        if(a.length() > b.length()) {
            return addBinary(b,a);
        }

        StringBuilder sb = new StringBuilder();
        boolean carryForward = false;

        for(int i=0; i<b.length(); i++) {
            char bValue = b.charAt(b.length()-1-i);
            char aValue;

            /**
             * Since a can be shorter than b, we 'append' it with '0's
             */
            if((a.length()-1-i) >= 0) {
                aValue = a.charAt(a.length() - 1 - i);
            } else {
                aValue = '0';
            }

            if(aValue == '0' && bValue == '0') {
                if(carryForward) {
                    sb.append("1");
                    carryForward = false;
                } else {
                    sb.append("0");
                }
            } else if (aValue != bValue) {
                if(carryForward) {
                    sb.append("0");
                    carryForward = true;
                } else {
                    sb.append("1");
                }
            } else if (aValue == '1' && bValue == '1') {
                if(carryForward) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
                carryForward = true;
            }
        }

        if(carryForward) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }

}
