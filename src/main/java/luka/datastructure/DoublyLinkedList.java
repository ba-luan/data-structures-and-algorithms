package luka.datastructure;

class DoublyListNode {
    int data;
    DoublyListNode prev;
    DoublyListNode next;

    public DoublyListNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    private DoublyListNode head;
    private DoublyListNode tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void add(int data) {
        DoublyListNode newNode = new DoublyListNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void removeData(int data) {
        DoublyListNode current = head;
        while (current != null) {
            if (current.data == data) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                return;
            }
            current = current.next;
        }
    }

    public void removeAtIndex(int index) {
        if (index < 0) {
            return;
        }

        DoublyListNode current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }

        if (current != null) {
            if (current.prev != null) {
                current.prev.next = current.next;
            } else {
                head = current.next;
            }

            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }
        }
    }

    public boolean contains(int data) {
        DoublyListNode current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int getDataAtIndex(int index) {
        if (index < 0) {
            return -1;
        }

        DoublyListNode current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }

        if (current != null) {
            return current.data;
        }

        return -1;
    }

    public void reverse() {
        DoublyListNode temp = null;
        DoublyListNode current = head;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        DoublyListNode current = head;
        while (current != null) {
            result.append(current.data).append(" ");
            current = current.next;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(25);

        System.out.println("Original Doubly Linked List: " + list);

        list.removeData(15);
        System.out.println("Doubly Linked List after removing 15: " + list);

        list.removeAtIndex(1);
        System.out.println("Doubly Linked List after removing element at index 1: " + list);

        System.out.println("Doubly Linked List contains 10: " + list.contains(10));
        System.out.println("Doubly Linked List contains 30: " + list.contains(30));

        System.out.println("Data at index 2: " + list.getDataAtIndex(2));

        list.reverse();
        System.out.println("Reversed Doubly Linked List: " + list);
    }
}


