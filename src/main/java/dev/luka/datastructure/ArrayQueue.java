package dev.luka.datastructure;

import java.util.ArrayList;

public class ArrayQueue<T> {
    private ArrayList<T> list;

    public ArrayQueue() {
        list = new ArrayList<>();
    }

    public void enqueue(T element) {
        list.add(element);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("ArrayQueue is empty");
        }
        return list.remove(0);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("ArrayQueue is empty");
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Size: " + queue.size());
        System.out.println("Front element: " + queue.peek());

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());

        System.out.println("Is empty: " + queue.isEmpty());
        System.out.println("Size after dequeue: " + queue.size());
    }
}

