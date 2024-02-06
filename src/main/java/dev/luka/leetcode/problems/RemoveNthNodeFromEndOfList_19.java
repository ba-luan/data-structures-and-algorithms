package dev.luka.leetcode.problems;

public class RemoveNthNodeFromEndOfList_19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        // Because we need to remove the nth node from the end, we should let the slow pointer keeps track
        // of the node from its left side which is node (n+1)th from the end
        // Move fast pointer to (n+1) steps forward
        for (int i = 0; i <= n; i++) {
            // Invalid input, n is larger than list length
            if (fast == null) return head;
            fast = fast.next;
        }

        // Move both pointers to the end of the list
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth node from the end which is the node on the right side of the slow pointer
        slow.next = slow.next.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);

        ListNode.printList(head);
        ListNode.printList(removeNthFromEnd(head, 2));
    }
}
