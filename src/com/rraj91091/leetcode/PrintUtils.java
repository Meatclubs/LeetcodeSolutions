package com.rraj91091.leetcode;

public class PrintUtils {

    public static String printArray(int[] arr) {
        String arrayAsString = "";
        for(int i=0; i<arr.length; i++) {
            if(i != 0) {
                arrayAsString = arrayAsString.concat(",");
            }
            arrayAsString = arrayAsString.concat(String.valueOf(arr[i]));
        }
        return arrayAsString;
    }

}
