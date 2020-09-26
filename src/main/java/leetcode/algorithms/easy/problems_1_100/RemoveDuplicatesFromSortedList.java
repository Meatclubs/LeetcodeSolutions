package main.java.leetcode.algorithms.easy.problems_1_100;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 * Input: 1->1->2
 * Output: 1->2
 *
 * Example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode iterator = head;

        while(iterator != null && iterator.next != null) {
            while(iterator.val == iterator.next.val) {
                if(iterator.next.next != null) {
                    iterator.next = iterator.next.next;
                } else {
                    iterator.next = null;
                    break;
                }
            }

            iterator = iterator.next;
        }

        return head;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
