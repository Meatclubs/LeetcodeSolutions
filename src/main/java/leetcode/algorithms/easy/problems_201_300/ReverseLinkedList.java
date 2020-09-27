package main.java.leetcode.algorithms.easy.problems_201_300;

/**
 * Reverse a singly linked list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
    public ListNode reverseListIteratively(ListNode head) {

        if(head == null) {
            return head;
        }

        ListNode newHead = null;
        ListNode temp = null;

        while(head != null) {
            temp = head.next; //assign temp pointer to next node to not lose lead
            head.next = newHead; //break current node from next node and point next to new head
            newHead = head; //assign current node as the new head
            head = temp; //move head to next node pointed to by temp pointer
        }

        return newHead;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
