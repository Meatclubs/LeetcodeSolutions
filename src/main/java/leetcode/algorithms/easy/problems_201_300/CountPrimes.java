package main.java.leetcode.algorithms.easy.problems_201_300;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example 1:
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * Example 2:
 * Input: n = 0
 * Output: 0
 *
 * Example 3:
 * Input: n = 1
 * Output: 0
 *
 * Constraints:
 * 0 <= n <= 5 * 106
 */
public class CountPrimes {
    public int countPrimes(int n) {
        //Sieve of eratosthenes

        if(n <= 2) {
            return 0;
        }

        boolean[] nonPrimes = new boolean[n];
        int count = 1;

        /**
         * we start with 3 and increment by 2 as we know that all even-numbers after 2 are not prime numbers,
         * so we only consider the odd-numbers.
         */
        for(int i=3; i<n; i += 2) {
            if(!nonPrimes[i]) {
                count++;
                for(int k=i; k<n; k += i) {
                    /**
                     * mark multiples of primes as non-primes so we can skip them later
                     */
                    nonPrimes[k] = true;
                }
            }
        }

        return count;
    }
}
