package dev.luka.leetcode.problems;

public class LinkedListCycle_141 {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if ( fast == slow) {
                return true;
            }
        }
        return false;
    }

    private class ListNode {
        ListNode next;
        int val;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
