package com.rraj91091.leetcode.leetcode;

public class RomanToInt {

    public static int romanToInt(String s) {
        int result = 0;

        for(int i=0; i < s.length(); i++) {
            if(s.charAt(i) == 'I') {
                result += 1;
                if(i+1 != s.length()) {
                    if(s.charAt(i+1) == 'X' || s.charAt(i+1) == 'V') {
                        result -= 2;
                    }
                }
            }
            if(s.charAt(i) == 'V') {
                result += 5;
            }
            if(s.charAt(i) == 'X') {
                result += 10;
                if(i+1 != s.length()) {
                    if(s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C') {
                        result -= 20;
                    }
                }
            }
            if(s.charAt(i) == 'L') {
                result += 50;
            }
            if(s.charAt(i) == 'C') {
                result += 100;
                if(i+1 != s.length()) {
                    if(s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M') {
                        result -= 200;
                    }
                }
            }
            if(s.charAt(i) == 'D') {
                result += 500;
            }
            if(s.charAt(i) == 'M') {
                result += 1000;
            }
        }

        return result;
    }

}
