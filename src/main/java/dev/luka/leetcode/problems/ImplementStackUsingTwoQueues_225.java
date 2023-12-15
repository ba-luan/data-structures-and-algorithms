package dev.luka.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Time complexity of all implemented methods can be O(1), but one of push or pop has to be O(n)
 * due to the loop throughout the entire LinkedList to rearrange the order. For the sake of adding data
 * more efficient, we should implement push with O(1) and pop with O(n) time complexity.
 * */
public class ImplementStackUsingTwoQueues_225 {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int top;

    // constructor
    public ImplementStackUsingTwoQueues_225() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Time complexity O(1)
    public void push(int x) {
        queue1.offer(x);
        top = x;
    }

    // Time complexity O(n)
    public int pop() {
        while(queue1.size() > 1) {
            top = queue1.poll();
            queue2.offer(top);
        }
        int removeElement = queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return removeElement;
    }

    public int top() {
        return top;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingTwoQueues_225 myStack = new ImplementStackUsingTwoQueues_225();
        System.out.println("push 1");
        myStack.push(1);
        System.out.println("push 2");
        myStack.push(2);
        System.out.println("top: "+ myStack.top());
        System.out.println("pop: " +myStack.pop());
        System.out.println("isEmpty: " + myStack.isEmpty());
    }
}
