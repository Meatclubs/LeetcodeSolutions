package main.java.leetcode.algorithms.easy.problems_1201_1300;

/**
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
 * Check if these points make a straight line in the XY plane.
 *
 * Example 1:
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 *
 * Example 2:
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 *
 * Constraints:
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 */
public class CheckStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        double Ax = (double) coordinates[0][0];
        double Ay = (double) coordinates[0][1];
        double Bx = (double) coordinates[1][0];
        double By = (double) coordinates[1][1];

        double dydx = 0;

        if(Bx - Ax == 0) {
            dydx = Double.MAX_VALUE;
        } else {
            dydx = (By - Ay) / (Bx - Ax);
        }

        for(int i=1; i<coordinates.length-1; i++) {
            double Cx = (double) coordinates[i][0];
            double Cy = (double) coordinates[i][1];
            double Dx = (double) coordinates[i+1][0];
            double Dy = (double) coordinates[i+1][1];
            double dydx2 = 0;

            if(Dx - Cx == 0) {
                dydx2 = Double.MAX_VALUE;
            } else {
                dydx2 = (Dy - Cy) / (Dx - Cx);
            }

            if(dydx != dydx2) return false;
        }

        return true;
    }
}
