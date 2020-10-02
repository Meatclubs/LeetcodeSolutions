package main.java.leetcode.algorithms.easy.problems_201_300;

/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Example:
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {

        //check if first is bad
        if(isBadVersion(1)) {
            return 1;
        }

        int start = 1;
        int end = n;
        int mid = start + (end - start)/2;

        while(end - start > 1) {
            if(isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
            mid = start + (end - start)/2;
        }

        return mid + 1;
    }

    /**
     * dummy method (only found on Leetcode for this problem)
     */
    private boolean isBadVersion(int val) {
        return true;
    }
}