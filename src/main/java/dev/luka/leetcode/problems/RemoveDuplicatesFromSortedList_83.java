package dev.luka.leetcode.problems;

public class RemoveDuplicatesFromSortedList_83 {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.add(1);
        head.add(2);
        head.add(3);
        head.add(3);

        ListNode.printList(deleteDuplicates(head)); // 1, 2, 3
    }
}
