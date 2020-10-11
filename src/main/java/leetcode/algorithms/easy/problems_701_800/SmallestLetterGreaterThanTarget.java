package main.java.leetcode.algorithms.easy.problems_701_800;

/**
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target,
 * find the smallest element in the list that is larger than the given target.
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 *
 * Examples:
 * Input:
 * letters = ["c", "f", "j"]
 * target = "a"
 * Output: "c"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "c"
 * Output: "f"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "g"
 * Output: "j"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "j"
 * Output: "c"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 *
 * Note:
 * letters has a length in range [2, 10000].
 * letters consists of lowercase letters, and contains at least 2 unique letters.
 * target is a lowercase letter.
 */
public class SmallestLetterGreaterThanTarget {

    /**
     * Binary Search
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        int mid = start + ((end-start)/2);

        //wrap around cases
        if(letters[start] > target) return letters[0];
        if(letters[end] <= target) return letters[0];

        while(start <= end) {
            mid = start + ((end-start)/2);

            if(letters[mid] > target) {
                if(mid == 0 || letters[mid-1] <= target) return letters[mid];
                end = mid-1;
            }
            if(letters[mid] <= target) {
                start = mid+1;
            }
        }

        return letters[mid];
    }

    /**
     * Linear Search
     */
    public char nextGreatestLetterV2(char[] letters, char target) {
        for (char c: letters)
            if (c > target) return c;
        return letters[0];
    }
}
