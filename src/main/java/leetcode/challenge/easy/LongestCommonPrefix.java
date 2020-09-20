package main.java.leetcode.challenge.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 *
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] input) {
        String shortestString = "";
        int shortestStringLength = Integer.MAX_VALUE;

        /**
         * get shortest string in the array
         */
        for(int i=0; i<input.length; i++) {
            if(input[i].length() < shortestStringLength) {
                shortestString = input[i];
                shortestStringLength = input[i].length();
            }
        }

        /**
         * for edge case: empty array
         */
        if(shortestString.equals("")) {
            return shortestString;
        }

        int rightMostIndex = getCommonPrefix(input, shortestString, 0, shortestStringLength);

        return shortestString.substring(0,rightMostIndex);
    }

    private int getCommonPrefix(String[] input, String prefix, int startIndex, int endIndex) {
        String prefixSubString = prefix.substring(startIndex,endIndex);
        System.out.println("Entering getCommonPrefix with  : " + prefixSubString + "," + startIndex + "," + endIndex);

        if(prefixSubString.length() > 1) {
            int midIndex = (endIndex + startIndex)/2;

            int leftEndIndex = getCommonPrefix(input, prefix, startIndex, midIndex);
            int rightEndIndex = getCommonPrefix(input, prefix, midIndex, endIndex);

            /**
             * If left side prefix index == 0, then we know that no common prefix has been found on the left half.
             * Therefore there's no common prefix for the given prefix substring. So return 0.
             * Otherwise return the highest index of all common prefixes found on left and right halves.
             */
            if(leftEndIndex == 0) {
                System.out.println("Returning 0 for substring: " + prefixSubString);
                return 0;
            } else {
                System.out.println("Returning Maximum of : " + leftEndIndex + "," + rightEndIndex);
                return Math.max(rightEndIndex, leftEndIndex);
            }
        }

        for(int i=0; i<input.length; i++) {
            String inputSubString = input[i].substring(startIndex,endIndex);

            if(!inputSubString.equals(prefixSubString)) {
                /**
                 * We return 0 to indicate that the given prefix substring is not common
                 */
                System.out.println("XReturning index for : " + prefixSubString + " : " + startIndex);
                return 0;
            }
        }

        /**
         * If prefix substring is common, we return the last index for the prefix substring
         */
        System.out.println("Returning index for : " + prefixSubString + " : " + endIndex);
        return endIndex;
    }
}
