package dev.luka.leetcode.problems;

public class ReverseLinkedList_206 {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        // after escaping while loop, prev pointer is at the last node which is new node of reversed list.
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNext(2).addNext(3).addNext(4).addNext(5);

        ListNode.printList(head);
        head = reverseList(head);
        ListNode.printList(head);
    }
}
