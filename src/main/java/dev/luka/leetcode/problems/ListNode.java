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
        ListNode newNode = new ListNode(val, null);
        ListNode cur = this;
        ListNode last = this;
        while (cur != null) {
            last = cur;
            cur = cur.next;
        }
        last.next = newNode;
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
