package main.java.leetcode.algorithms.easy.problems_1101_1200;

/**
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * A defanged IP address replaces every period "." with "[.]".
 *
 * Example 1:
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 *
 * Example 2:
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 *
 * Constraints:
 * The given address is a valid IPv4 address.
 */
public class DefangIPAddress {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();

        for(char ccc : address.toCharArray()) {
            if(ccc == '.') {
                sb.append("[");
                sb.append(".");
                sb.append("]");
            } else {
                sb.append(ccc);
            }
        }

        return sb.toString();
    }
}
