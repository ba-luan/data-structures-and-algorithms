package dev.luka.leetcode.problems;

public class ReverseLinkedListII_92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Create dummyHead for easier handle some edge cases
        ListNode dummyHead = new ListNode(0, head);
        ListNode beforeLeftNode = dummyHead;

        // move to the (left-1)th node
        for (int i = 1; i < left; i++) {
            beforeLeftNode = beforeLeftNode.next;
        }

        ListNode cur = beforeLeftNode.next;
        ListNode tail = cur; // the initial current node is actually the tail node of reversed part
        ListNode prev = null; // the previous pointer
        for (int i = left; i <= right; i++) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        // At this point the current node is at position (right + 1)
        // so we link the tail of reversed part to the current node
        // and link the node at position (left - 1) to the head of reversed part which is the prev node
        tail.next = cur;
        beforeLeftNode.next = prev;

        // return dummyHead.next instead of head because head could be a part of reversed part
        // then head is no longer the correct head
        return dummyHead.next;
    }

    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseLinkedListII_92 solution = new ReverseLinkedListII_92();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int left = 2, right = 4;
        ListNode result = solution.reverseBetween(head, left, right);
        solution.printList(result);
    }
}
