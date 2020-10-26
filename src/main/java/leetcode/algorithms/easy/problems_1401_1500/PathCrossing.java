package main.java.leetcode.algorithms.easy.problems_1401_1500;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east,
 * or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
 * Return True if the path crosses itself at any point, that is, if at any time you are on a location you've
 * previously visited. Return False otherwise.
 *
 * Example 1:
 * Input: path = "NES"
 * Output: false
 * Explanation: Notice that the path doesn't cross any point more than once.
 *
 * Example 2:
 * Input: path = "NESWW"
 * Output: true
 * Explanation: Notice that the path visits the origin twice.
 *
 * Constraints:
 * 1 <= path.length <= 10^4
 * path will only consist of characters in {'N', 'S', 'E', 'W}
 */
public class PathCrossing {
    public boolean isPathCrossing(String path) {
        Set<String> coords = new HashSet<>();
        int x = 0, y = 0;

        StringBuilder sb = new StringBuilder();
        sb.append(x);
        sb.append(",");
        sb.append(y);
        coords.add(sb.toString());

        for(char dir : path.toCharArray()) {
            switch(dir) {
                case 'N' : y++;
                    break;
                case 'E' : x++;
                    break;
                case 'S' : y--;
                    break;
                case 'W' : x--;
                    break;
            }

            sb = new StringBuilder();
            sb.append(x);
            sb.append(",");
            sb.append(y);

            if(!coords.add(sb.toString())) return true;
        }

        return false;
    }
}
