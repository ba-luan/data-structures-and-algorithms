package dev.luka.leetcode.problems;

public class RotateList_61 {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // find list length and tail node
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        k = k % len;
        if (k == 0) return head;

        // move to the (k+1)th node from the end of list
        ListNode cur = head;
        for (int i = 0; i < len - k - 1; i++) {
            cur = cur.next;
        }

        // rotate the list
        ListNode newHead = cur.next;
        cur.next = null;
        tail.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNext(2).addNext(3).addNext(4).addNext(5);

        ListNode.printList(head);
        head = rotateRight(head, 1);
        ListNode.printList(head);

        head = rotateRight(head, 2);
        ListNode.printList(head);
    }
}
