package main.java.leetcode.algorithms.easy.problems_1101_1200;

/**
 * Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either
 * (a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.
 * Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].
 *
 * Example 1:
 * Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * Output: 1
 *
 * Constraints:
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 */
public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] counts = new int[100];

        for(int k=0; k<dominoes.length; k++) {
            int a = dominoes[k][0];
            int b = dominoes[k][1];
            int num = getNum(a,b);

            counts[num]++;

            if(a != b) {
                int num2 = getNum(b,a);
                counts[num2]++;
            }
        }

        int count = 0;
        for(int i=0; i<counts.length; i++) {
            count += getPairs(counts[i]);

            counts[i] = 0;
            counts[getOpposite(i)] = 0;
        }

        return count;
    }

    private int getNum(int a, int b) {
        return (a*10) + b;
    }

    private int getOpposite(int a) {
        return ((a%10)*10) + (a/10);
    }

    private int getPairs(int a) {
        return (a * (a-1)) / 2;
    }
}
