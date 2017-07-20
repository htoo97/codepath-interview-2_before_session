/* Copy List */
/*
 * A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or NULL.
 *
 * Return a deep copy of the list.
 */

/**
 *  * Definition for singly-linked list with a random pointer.
 *   * class RandomListNode {
 *    *     int label;
 *     *     RandomListNode next, random;
 *      *     RandomListNode(int x) { this.label = x; }
 *       * };
 *        */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {

        HashMap<RandomListNode, RandomListNode> randMap = new HashMap<RandomListNode, RandomListNode>();

        RandomListNode iter = head;
        RandomListNode copy = new RandomListNode(head.label);
        randMap.put(head, copy);
        RandomListNode copyIter = copy;

        while (iter != null) {
            if (iter.next != null) {
                if (randMap.containsKey(iter.next)) {
                    copyIter.next = randMap.get(iter.next);
                }
                else {
                    copyIter.next = new RandomListNode(iter.next.label);
                    randMap.put(iter.next, copyIter.next);
                }
            }

            if (iter.random != null) {
                if (randMap.containsKey(iter.random)) {
                    copyIter.random = randMap.get(iter.random);
                }
                else {
                    copyIter.random = new RandomListNode(iter.random.label);
                    randMap.put(iter.random, copyIter.random);
                }
            }

            iter = iter.next;
            copyIter = copyIter.next;
        } 

        return copy;
    }
}

