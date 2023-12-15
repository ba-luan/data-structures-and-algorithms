package dev.luka.leetcode.problems;

import java.util.LinkedList;
import java.util.Stack;

public class ImplementQueueUsingStack_232 {
    Stack<Integer> inbox;
    Stack<Integer> outbox;

    public ImplementQueueUsingStack_232() {
        inbox = new Stack();
        outbox = new Stack();
    }

    public void push(int x) {
        inbox.push(x);
    }

    public int pop() {
        peek();
        return outbox.pop();
    }

    public int peek() {
        if (outbox.isEmpty())
            while (!inbox.isEmpty()) outbox.push(inbox.pop());
        return outbox.peek();
    }

    public boolean empty() {
        return inbox.isEmpty() && outbox.isEmpty();
    }
}
