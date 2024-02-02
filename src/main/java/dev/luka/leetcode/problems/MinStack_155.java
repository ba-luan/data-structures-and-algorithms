package dev.luka.leetcode.problems;

public class MinStack_155 {

    private Node head;
    private int min;

    public void push(int x) {
        if (head == null) {
            head = new Node(x, null);
            min = x;
        } else {
            head = new Node(x, head);
            min = Math.min(min, x);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return min;
    }

    private class Node {
        int val;
        Node next;

        private Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
