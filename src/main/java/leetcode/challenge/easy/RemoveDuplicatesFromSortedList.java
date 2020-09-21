package main.java.leetcode.challenge.easy;

public class RemoveDuplicatesFromSortedList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
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

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
