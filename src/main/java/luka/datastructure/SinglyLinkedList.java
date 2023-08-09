package luka.datastructure;

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private ListNode head;

    public SinglyLinkedList() {
        head = null;
    }

    public void add(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void removeData(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        ListNode current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void removeAtIndex(int index) {
        if (index < 0) {
            return;
        }

        if (index == 0) {
            if (head != null) {
                head = head.next;
            }
            return;
        }

        ListNode current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }

        if (current != null && current.next != null) {
            current.next = current.next.next;
        }
    }

    public boolean contains(int data) {
        ListNode current = head;
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

        ListNode current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }

        if (current != null) {
            return current.data;
        }

        return -1;
    }

    public void reverse() {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            result.append(current.data).append(" ");
            current = current.next;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(25);

        System.out.println("Original Linked List: " + list);

        list.removeData(15);
        System.out.println("Linked List after removing 15: " + list);

        list.removeAtIndex(1);
        System.out.println("Linked List after removing element at index 1: " + list);

        System.out.println("Linked List contains 10: " + list.contains(10));
        System.out.println("Linked List contains 30: " + list.contains(30));

        System.out.println("Data at index 2: " + list.getDataAtIndex(2));

        list.reverse();
        System.out.println("Reversed Linked List: " + list);
    }
}

