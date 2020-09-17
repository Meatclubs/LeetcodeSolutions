package com.rraj91091.leetcode.leetcode;

public class ReverseInteger {

    public static int reverse(int x) {
        long result = 0;
        int length = String.valueOf(Math.abs(x)).length();

        while(x != 0) {
            result += (x%10) * Math.pow(10,length-1);
            x = x / 10;
            length--;
        }

        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) result;
    }
}
