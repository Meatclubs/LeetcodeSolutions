package main.java.leetcode;

import main.java.leetcode.challenge.interview.MergeTwoArraysInSortedOrder;
import main.java.leetcode.utils.PrintUtils;

public class Application {

    public static void main(String[] args) {

        int[] A = {4,5,6,7,8,9,0,0,0};
        int[] B = {1,2,3};

        int[] result = MergeTwoArraysInSortedOrder.sort(B,A);

        PrintUtils.printArray(result);
    }

}
