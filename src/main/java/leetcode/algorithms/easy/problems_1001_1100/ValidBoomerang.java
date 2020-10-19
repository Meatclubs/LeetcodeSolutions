package main.java.leetcode.algorithms.easy.problems_1001_1100;

public class ValidBoomerang {
    /**
     * Using DY/DX comparison
     */
    public boolean isBoomerang(int[][] points) {
        int Ax = points[0][0];
        int Ay = points[0][1];
        int Bx = points[1][0];
        int By = points[1][1];
        int Cx = points[2][0];
        int Cy = points[2][1];

        /**
         * if any two coordinates are the same, return false
         */
        if(Bx == Ax && By == Ay) return false;
        if(Cx == Ax && Cy == Ay) return false;
        if(Cx == Bx && Cy == By) return false;

        double dydx1;
        double dydx2;

        /**
         * if both coordinates line lie vertically, we set to max dydx value to prevent division by 0
         */
        if((Bx - Ax) == 0) {
            dydx1 = Double.MAX_VALUE;
        } else {
            dydx1 = (double) (By - Ay) / (double) (Bx - Ax);
        }

        /**
         * if both coordinates line lie vertically, we set to max dydx value to prevent division by 0
         */
        if((Cx - Ax) == 0) {
            dydx2 = Double.MAX_VALUE;
        } else {
            dydx2 = (double) (Cy - Ay) / (double) (Cx - Ax);
        }

        return dydx1 != dydx2;
    }

    /**
     * Using Area of Triangle
     */
    public boolean isBoomerangV2(int[][] points) {
        int Ax = points[0][0];
        int Ay = points[0][1];
        int Bx = points[1][0];
        int By = points[1][1];
        int Cx = points[2][0];
        int Cy = points[2][1];

        double area = (double)(Ax * (By - Cy) + Bx * (Cy - Ay) + Cx * (Ay - By)) / 2.0d;

        return (area != 0.0d);
    }
}
