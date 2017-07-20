/* List Cycle */
/*
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.
 *
 * Try solving it using constant additional space.
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
    public ListNode detectCycle(ListNode a) {
        ListNode fast = a;
        ListNode slow = a;

        do {
            // fast traverses the list two nodes at a time
            fast = fast.next;

            if (fast == null) {break; }

            fast = fast.next;

            // slow traverses the list one node at a time
            slow = slow.next;
        } while (fast != null && slow != fast);

        if (fast == null) {
            return null;
        }
        else {
            // loop exists
            slow = a;

            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }
    }
}

