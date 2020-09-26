package main.java.leetcode.challenge.easy.problems_101_200;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by
 * continuously following the next pointer. Internally, pos is used to denote the index of the node
 * that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * Follow up:
 * Can you solve it using O(1) (i.e. constant) memory?
 *
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 *
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 *
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 * Constraints:
 * * The number of the nodes in the list is in the range [0, 104].
 * * -105 <= Node.val <= 105
 * * pos is -1 or a valid index in the linked-list.
 */
public class HasCycle {

    /**
     * Using 2 pointers fast and slow traversal
     */
    public boolean hasCycleV2(ListNode head) {

        if(head == null || head.next == null) {
            return false;
        }

        ListNode first = head;
        ListNode second = head.next;

        while(first != second) {
            if(first.next == null) {
                return false;
            } else {
                first = first.next;
            }

            if(second.next == null || second.next.next == null) {
                return false;
            } else {
                second = second.next.next;
            }
        }

        return true;
    }

    /**
     * Marking visited Nodes to detect cycle
     */
    public boolean hasCycleV1(ListNode head) {

        if(head == null) {
            return false;
        }

        while(head.val <= 100000) {
            if(head.next == null || head.val > 100000) {
                return false;
            } else {
                head.val = 110000; //mark node as traversed;
                head = head.next;
            }
        }

        return true;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
