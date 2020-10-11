package main.java.leetcode;

import javax.swing.*;

public class Application {

    public static void main(String[] args) {
        int x = 56;

        //x--;
        x |= x >> 1;
        System.out.println(x);
        //x++;

        System.out.println(x);

    }

}
