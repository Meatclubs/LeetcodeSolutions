package com.rraj91091.leetcode.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        //take care of edge cases first
        if(s.length() == 0) {
            return 0;
        } else if(s.length() == 1) {
            return 1;
        }

        Map<Character,Integer> map = new HashMap<>();

        int startIndex = 0;
        int endIndex = 0;
        int length = 0;

        while(endIndex != s.length()) {

            if(map.containsKey(s.charAt(endIndex))) {
                if(map.get(s.charAt(endIndex)) >= startIndex) {
                    startIndex = map.get(s.charAt(endIndex)) + 1;
                }
            }

            if(endIndex - startIndex + 1 > length) {
                length = endIndex - startIndex + 1;
            }

            map.put(s.charAt(endIndex),endIndex);

            endIndex++;
        }

        return length;
    }
}
