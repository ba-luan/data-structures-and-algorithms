package dev.luka.datastructure;

class QueueNode<T> {
    T value;
    QueueNode<T> next;

    public QueueNode(T value) {
        this.value = value;
        this.next = null;
    }
}

public class LinkedQueue<T> {
    private QueueNode<T> front;
    private QueueNode<T> rear;
    private int size;

    public LinkedQueue() {
        front = rear = null;
        size = 0;
    }

    public void enqueue(T element) {
        QueueNode<T> newNode = new QueueNode<>(element);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T value = front.value;
        front = front.next;
        size--;
        if (isEmpty()) {
            rear = null;
        }
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
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

