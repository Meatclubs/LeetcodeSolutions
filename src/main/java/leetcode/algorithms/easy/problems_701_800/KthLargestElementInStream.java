package main.java.leetcode.algorithms.easy.problems_701_800;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 * Implement KthLargest class:
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
 * int add(int val) Returns the element representing the kth largest element in the stream.
 *
 * Example 1:
 * Input
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * Output
 * [null, 4, 5, 5, 8, 8]
 *
 * Explanation
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 *
 * Constraints:
 * 1 <= k <= 104
 * 0 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * -104 <= val <= 104
 * At most 104 calls will be made to add.
 */
public class KthLargestElementInStream {
    class KthLargest {

        PriorityQueue<Integer> pq;
        int kth;

        public KthLargest(int k, int[] nums) {
            pq = new PriorityQueue<>((a,b) -> a-b);
            kth = k;

            for(int num : nums) {
                pq.add(num);
                if(pq.size() > k) { pq.poll(); }
            }
        }

        public int add(int val) {
            pq.add(val);

            if(pq.size() > kth) {
                pq.poll();
            }

            return pq.peek();
        }
    }
}
