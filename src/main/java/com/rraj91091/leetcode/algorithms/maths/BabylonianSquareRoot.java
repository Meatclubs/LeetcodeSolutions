package com.rraj91091.leetcode.algorithms.maths;

public class BabylonianSquareRoot {

    static float squareRoot(float n)
    {
        /**
         * We are using n itself as initial approximation.
         * This can definitely be improved.
         */
        float x = n;
        float y = 1;

        // e decides the accuracy level
        double e = 0.000001;
        while (x - y > e) {
            x = (x + y) / 2;
            y = n / x;
        }

        return x;
    }
}
