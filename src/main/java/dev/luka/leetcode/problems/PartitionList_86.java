package dev.luka.leetcode.problems;

public class PartitionList_86 {

    public static ListNode partition(ListNode head, int x) {
        // we split the list into 2 sub-lists: the left and right sub-list
        ListNode leftHead = new ListNode(); // create dummy head for left sub-list
        ListNode leftTail = leftHead;
        ListNode rightHead = new ListNode(); // create dummy head for right sub-list
        ListNode rightTail = rightHead;

        while (head != null) {
            if (head.val < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }

            head = head.next;
        }

        leftTail.next = rightHead.next; // rightHead is dummy, we need to link to rightHead.next which is real head
        rightTail.next = null;

        return leftHead.next; // similarly leftHead is dummy, real head is leftHead.next
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNext(4).addNext(3).addNext(2).addNext(5).addNext(2);

        ListNode.printList(head); // 1 4 3 2 5 2
        head = partition(head, 3);
        ListNode.printList(head); // 1 2 2 4 3 5
    }
}