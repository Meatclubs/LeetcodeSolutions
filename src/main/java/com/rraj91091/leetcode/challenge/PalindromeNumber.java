package com.rraj91091.leetcode.leetcode;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        String xx = String.valueOf(x);

        for(int i = 0; i<xx.length(); i++) {
            if(xx.charAt(i) != xx.charAt(xx.length()-1-i)) {
                return false;
            }
        }

        return true;
    }
}
