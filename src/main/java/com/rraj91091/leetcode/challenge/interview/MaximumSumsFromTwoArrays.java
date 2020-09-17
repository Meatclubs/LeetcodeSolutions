package main.java.com.rraj91091.leetcode.challenge.interview;

import main.java.com.rraj91091.leetcode.utils.PrintUtils;

import java.util.Arrays;

/**
 * Given 2 unsorted integer arrays of N size each, find the N largest sum of 2 numbers X,Y
 * such that X is not the same element as Y, and X and Y are not from the same array.
 *
 * Return the result of the N integers in array format, sorted in descending order.
 *
 * e.g. Given 2 arrays
 * X = [6,3,7,8,1]
 * Y = [3,7,9,1,4]
 *
 * Result = [17,16,15,15,14]
 */
public class MaximumSumsFromTwoArrays {

    //TODO fix algorithm to handle edge-case where arrays have multiple integers with the same maximum value

    public static int[] solution(int[] X, int[] Y) {

        /**
         * First we sort the 2 arrays in descending order. Since problem is to find the largest sums,
         * we shall not focus on the sorting algorithm and instead use Collections' out of the box sorting function.
         */
        Arrays.sort(X);
        Arrays.sort(Y);

        PrintUtils.printArray(X);
        PrintUtils.printArray(Y);
        System.out.println("---------------------------");

        int[] result = new int[X.length];

        int XFirst = X.length-1;
        int XSecond = X.length-2;

        int YFirst = Y.length-1;
        int YSecond = Y.length-2;

        int resultIndex = 0;
        result[resultIndex] = X[XFirst] + Y[YFirst];

        while(XSecond >= 0 && YSecond >= 0) {
            resultIndex++;

            PrintUtils.printArray(result);

            //if we've filled the results array with N largest sums before we reach the end of the 2 sorted input arrays
            if(resultIndex == result.length) {
                return result;
            }

            if(X[XFirst] + Y[YSecond] >= Y[YFirst] + X[XSecond]) {
                result[resultIndex] = X[XFirst] + Y[YSecond];
                YSecond--;
            } else {
                result[resultIndex] = X[XSecond] + Y[YFirst];
                XSecond--;
            }
        }
        PrintUtils.printArray(result);

        return result;
    }
}
