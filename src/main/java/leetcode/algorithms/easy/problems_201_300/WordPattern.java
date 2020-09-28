package main.java.leetcode.algorithms.easy.problems_201_300;

import java.util.HashMap;

public class WordPattern {

    /**
     * Solution using 2 pointers to extract words from string without splitting.
     * Uses less memory that string-splitting solution.
     */
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();

        int startIndex = 0;
        int endIndex = 1;

        for(int i=0; i<pattern.length(); i++) {
            char patternChar = pattern.charAt(i);

            if(startIndex > s.length()) {
                return false; //not enough words to match pattern
            }

            while(endIndex < s.length() && s.charAt(endIndex) != ' ') {
                endIndex++;
            }

            String word = s.substring(startIndex,endIndex);

            if(map.containsKey(patternChar)) {
                if(!word.equalsIgnoreCase(map.get(patternChar))) {
                    return false;
                }
            } else {
                if(map.containsValue(word)) {
                    return false;
                }
                else {
                    map.put(patternChar,word);
                }
            }

            startIndex = endIndex+1;
            endIndex = startIndex;
        }

        if(endIndex < s.length()) {
            return false; //pattern is shorter than string s, string s is not fully traversed
        }

        return true;
    }

    /**
     * Solution using string split and storing words in array.
     */
    public boolean wordPatternV2(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        String[] words = s.split(" ");

        if(pattern.length() != words.length) {
            return false;
        }

        for(int i=0; i<pattern.length(); i++) {
            char patternChar = pattern.charAt(i);

            if(map.containsKey(patternChar)) {
                if(!words[i].equalsIgnoreCase(map.get(patternChar))) {
                    return false;
                }
            } else {
                if(map.containsValue(words[i])) {
                    return false;
                }
                else {
                    map.put(patternChar,words[i]);
                }
            }
        }

        return true;
    }



}
