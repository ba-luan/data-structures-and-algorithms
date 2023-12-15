package dev.luka.leetcode.problems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingSingleQueue_225 {
    private Queue<Integer> queue;

    public ImplementStackUsingSingleQueue_225() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
        int size = queue.size();
        while (size > 1) {
            queue.offer(queue.poll());
            size--;
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingSingleQueue_225 myStack = new ImplementStackUsingSingleQueue_225();
        System.out.println("push 1");
        myStack.push(1);
        System.out.println("push 2");
        myStack.push(2);
        System.out.println("top: "+ myStack.top());
        System.out.println("pop: " +myStack.pop());
        System.out.println("isEmpty: " + myStack.isEmpty());
    }
}
