package main.java.leetcode.algorithms.easy.problems_1001_1100;

/**
 * Three stones are on a number line at positions a, b, and c.
 * Each turn, you pick up a stone at an endpoint (ie., either the lowest or highest position stone),
 * and move it to an unoccupied position between those endpoints.  Formally, let's say the stones are currently at
 * positions x, y, z with x < y < z.  You pick up the stone at either position x or position z,
 * and move that stone to an integer position k, with x < k < z and k != y.
 * The game ends when you cannot make any more moves, ie. the stones are in consecutive positions.
 * When the game ends, what is the minimum and maximum number of moves that you could have made?
 * Return the answer as an length 2 array: answer = [minimum_moves, maximum_moves]
 *
 * Example 1:
 * Input: a = 1, b = 2, c = 5
 * Output: [1,2]
 * Explanation: Move the stone from 5 to 3, or move the stone from 5 to 4 to 3.
 *
 * Example 2:
 * Input: a = 4, b = 3, c = 2
 * Output: [0,0]
 * Explanation: We cannot make any moves.
 *
 * Example 3:
 * Input: a = 3, b = 5, c = 1
 * Output: [1,2]
 * Explanation: Move the stone from 1 to 4; or move the stone from 1 to 2 to 4.
 *
 * Note:
 * 1 <= a <= 100
 * 1 <= b <= 100
 * 1 <= c <= 100
 * a != b, b != c, c != a
 */
public class MovingStonesUntilConsecutive {
    public int[] numMovesStones(int a, int b, int c) {
        /**
         * determine highest, mid and lowest numbers to get the 2 ranges between the 3 stones
         */
        int high = Math.max(Math.max(a,b),c);
        int low = Math.min(Math.min(a,b),c);
        int mid = a;

        if(a != high && a != low) mid = a;
        if(b != high && b != low) mid = b;
        if(c != high && c != low) mid = c;

        /**
         * we minus 1 here because the stone's place is excluded, so between 10 and 5, there's only 4 places
         */
        int largerRange = Math.max(high-mid,mid-low) - 1;
        int smallerRange = Math.min(high-mid,mid-low) - 1;

        /**
         * max moves is determined by moving the 2 end stones towards the mid stone 1 at a time
         * so the max moves is the number of spaces between the stones
         */
        int maxMoves = largerRange + smallerRange;

        /**
         * maximum minimum moves is 2 because we can move both end stones all the way
         * to just beside the middle stone and finish the game in 2 moves
         */
        int minMoves = 2;

        /**
         * if there are no spaces between the 3 stones, then the minimum moves is 0
         */
        if(smallerRange == 0 && largerRange == 0) minMoves = 0;

        /**
         * if there is only space between 2 stones, then we only need 1 move to bring the end stone further
         * away from the mid stone to just beside the mid stone and end the game
         */
        if(smallerRange == 0 && largerRange > 0) minMoves = 1;

        /**
         * if there is exactly 1 space between 1 end stone and the mid stone, then we can bring the other end stone
         * to between these 2 stones and finish the game in 1 move
         */
        if(smallerRange == 1) minMoves = 1;

        return new int[]{minMoves,maxMoves};
    }
}
