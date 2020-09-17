package com.rraj91091.leetcode.leetcode;

public class ValidParentheses {

    public boolean isValid(String s) {
        char[] chars = new char[1 + s.length()/2];
        int charArrIndex = -1;

        for(int i=0; i<s.length(); i++) {
            if(charArrIndex >= s.length()/2) {
                return false;
            }

            if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[' ) {
                charArrIndex++;
                chars[charArrIndex] = s.charAt(i);
            } else if(charArrIndex>=0 && s.charAt(i) == '}' && chars[charArrIndex] == '{') {
                chars[charArrIndex] = ' ';
                charArrIndex--;
            } else if(charArrIndex>=0 && s.charAt(i) == ')' &&  chars[charArrIndex] == '(') {
                chars[charArrIndex] = ' ';
                charArrIndex--;
            } else if(charArrIndex>=0 && s.charAt(i) == ']' &&  chars[charArrIndex] == '[') {
                chars[charArrIndex] = ' ';
                charArrIndex--;
            } else {
                return false;
            }
        }

        if(charArrIndex < 0) {
            return true;
        } else {
            return false;
        }
    }

}
