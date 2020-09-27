package main.java.leetcode.algorithms.easy.problems_201_300;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {

        while(head != null && head.val == val) {
            if(head.next == null) {
                return null;
            } else {
                head = head.next;
            }
        }

        ListNode node = head;

        while(node != null) {
            while(node.next != null && node.next.val == val) {
                node.next = node.next.next;
            }
            node = node.next;
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
