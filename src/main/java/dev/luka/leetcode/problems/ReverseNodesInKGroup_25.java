package dev.luka.leetcode.problems;

public class ReverseNodesInKGroup_25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode prevGroupTail = dummy;

        while (true) {
            ListNode kth = getKth(prevGroupTail, k);
            if (kth == null) break;
            ListNode nextGroupHead = kth.next;

            ListNode cur = prevGroupTail.next; // update cur to the head of current group
            ListNode prev = nextGroupHead; // pointing prev to next group head to link with head of current group
            while (cur != nextGroupHead) {
                ListNode tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }

            // link previous group to the next group
            // initially prevGroupTail.next points to the head node of current group
            // after reversing, head became tail, so we save it to tmp
            ListNode tmp = prevGroupTail.next;
            prevGroupTail.next = kth; // kth was tail but now became head => point prev group head to it
            prevGroupTail = tmp; // update new prev group tail
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode cur, int k) {
        while (cur != null && k > 0) {
            cur = cur.next;
            k--;
        }
        return cur;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup_25 solution = new ReverseNodesInKGroup_25();
        ListNode head = new ListNode(1);
        head.addNext(2).addNext(3).addNext(4).addNext(5);

        ListNode.printList(head);
        head = solution.reverseKGroup(head, 2);
        ListNode.printList(head);
    }
}
