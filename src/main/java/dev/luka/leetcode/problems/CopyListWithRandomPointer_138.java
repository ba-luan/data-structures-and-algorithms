package dev.luka.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer_138 {

    public ListNode copyRandomList(ListNode head) {
        // Create a hashmap with keys are nodes from copied list and values are nodes from copying list.
        Map<ListNode, ListNode> map = new HashMap<>();

        ListNode cur = head;
        while (cur != null) {
            ListNode newNode = new ListNode(cur.val);
            map.put(cur, newNode);
            cur = cur.next;
        }

        // reset current pointer to head for new loop
        // NOTE for EDGE case of last node: HashMap allows null key and null value and automatically returns null
        // if map.get(null) invoked. We don't have to add null key/value pair to the map as map.put(null, null)
        // So we are safe when the loop reaches last node which has next node as null,
        cur = head;
        while (cur != null) {
            ListNode newNode = map.get(cur);
            newNode.next = map.get(cur.next);
            newNode.random = map.get(cur.random);
            cur = cur.next;
        }

        // return the copy node of head which at the same time is the head of the copying list.
        return map.get(head);
    }

    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print("(" + current.val + ", ");
            if (current.random != null) {
                System.out.print(current.random.val);
            } else {
                System.out.print("null");
            }
            System.out.print(") ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer_138 solution = new CopyListWithRandomPointer_138();

        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next;

        ListNode result = solution.copyRandomList(head);
        solution.printList(result);
    }
}
