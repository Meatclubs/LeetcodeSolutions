package main.java.com.rraj91091.leetcode;

import main.java.com.rraj91091.leetcode.challenge.interview.MaximumSumsFromTwoArrays;
import main.java.com.rraj91091.leetcode.utils.PrintUtils;

public class Application {

    public static void main(String[] args) {

        int[] X = {4,3,3,2,1};
        int[] Y = {2,5,5,3,2};

        int[] result = MaximumSumsFromTwoArrays.solution(X,Y);

        PrintUtils.printArray(result);
    }

}
