/* Reverse Link List II */
/*
 * Reverse a linked list from position m to n. 
 * Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return 1->4->3->2->5->NULL.
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        if (A == null || A.next == null) {
            return A;
        }

        // dummy head
        ListNode dummy = new ListNode(0);
        dummy.next = A;

        ListNode iter = A;
        ListNode prev = dummy;
        ListNode start;
        ListNode after;

        for (int i=1; i<B; i++) {
            prev = prev.next;
        }
        start = prev.next;
        after = start.next;

        for (int i=0; i<(C-B); i++) {
            start.next = after.next;
            after.next = prev.next;
            prev.next = after;
            after = start.next;
        }

        return dummy.next;
    }
}

