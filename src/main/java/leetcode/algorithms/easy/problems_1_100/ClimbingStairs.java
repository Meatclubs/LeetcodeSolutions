package main.java.leetcode.algorithms.easy.problems_1_100;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * Constraints:
 *
 * 1 <= n <= 45
 */
public class ClimbingStairs {
    class Solution {
        public int climbStairs(int steps) {
            /**
             * We use map here to store the mapping of stepsRemaining --> ways to climb
             * for faster retrieval.
             */
            Map<Integer,Integer> map = new HashMap<>();

            return climb(steps,map);
        }

        public int climb(int stepsRemaining, Map<Integer,Integer> map) {
            if(stepsRemaining < 0) {
                return 0;
            }
            if(stepsRemaining == 0 || stepsRemaining == 1) {
                return 1;
            }
            if(stepsRemaining == 2) {
                return 2;
            }
            if(stepsRemaining == 3) {
                return 3;
            }

            if(map.containsKey(stepsRemaining)) {
                return map.get(stepsRemaining);
            }

            int steps = climb(stepsRemaining-1,map) + climb(stepsRemaining-2,map);
            map.put(stepsRemaining, steps);

            return steps;
        }
    }
}
