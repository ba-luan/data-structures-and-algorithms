package dev.luka.leetcode.problems;

public class ListNode {
    int val;
    ListNode next;
    ListNode random;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void add(int val) {
        ListNode cur = this;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(val, null);
    }

    public ListNode addNext(int val) {
        ListNode cur = this;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(val, null);
        return cur.next;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
