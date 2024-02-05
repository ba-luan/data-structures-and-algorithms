package dev.luka.leetcode.problems;

public class MergeTwoSortedList_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode cur = dummyHead;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }

            cur = cur.next;
        }

        // link the result linked list to the remaining nodes of list1 / list2 at current pointer
        if (p1 != null) {
            cur.next = p1;
        } else {
            cur.next = p2;
        }

        return dummyHead.next;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeTwoSortedList_21 solution = new MergeTwoSortedList_21();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        printList(list1);
        printList(list2);
        printList(solution.mergeTwoLists(list1, list2));
    }
}
