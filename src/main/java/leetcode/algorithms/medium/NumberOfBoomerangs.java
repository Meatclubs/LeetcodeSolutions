package main.java.leetcode.algorithms.medium;

import java.util.HashMap;

/**
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k)
 * such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 * Find the number of boomerangs. You may assume that n will be at most 500
 * and coordinates of points are all in the range [-10000, 10000] (inclusive).
 *
 * Example:
 *
 * Input:
 * [[0,0],[1,0],[2,0]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int booms = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<points.length; i++) {
            map.clear();
            for(int j=0; j<points.length; j++) {
                int distance = getDistance(points[i], points[j]);
                int boom = map.getOrDefault(distance, 0);

                booms += boom * 2;

                map.put(distance, ++boom);
            }
        }

        return booms;
    }

    private Integer getDistance(int[] start, int[] end) {
        return (start[0] - end[0]) * (start[0] - end[0])
                + (start[1] - end[1]) * (start[1] - end[1]);
    }
}
