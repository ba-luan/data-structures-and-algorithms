package dev.luka.leetcode.problems;

public class RemoveDuplicatesFromSortedListII_82 {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            boolean hasDuplicates = false;

            // Check for duplicates
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
                hasDuplicates = true;
            }

            if (hasDuplicates) {
                // Skip the duplicates by adjusting the next pointer of the previous node
                prev.next = current.next;
            } else {
                // Move to the next node
                prev = prev.next;
            }

            current = current.next;
        }
        return dummy.next;
    }

    public static ListNode deleteDuplicatesV2(ListNode head) {
        if (head == null) return null;

        ListNode dummyHead = new ListNode(0, head);
        ListNode prev = dummyHead; // only update prev pointer if there's no duplicates
        ListNode cur = head;

        while (cur != null){
            // Skip the duplicates
            while (cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }

            // Check and update prev before updating cur
            if (prev.next == cur) {  // prev is right behind cur, there's no duplicates
                prev = prev.next;
            } else { // there's duplicates => skip duplicates by jumping prev to the right side of cur
                prev.next = cur.next;
            }

            // Updating cur after updating prev
            cur = cur.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.add(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(4);
        head.add(5);

        ListNode.printList(head);
        head = deleteDuplicates(head);
        ListNode.printList(head);

        head.add(5);
        ListNode.printList(head);
        head = deleteDuplicatesV2(head);
        ListNode.printList(head);
    }
}
