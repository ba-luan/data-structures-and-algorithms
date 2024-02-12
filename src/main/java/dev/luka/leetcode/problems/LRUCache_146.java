package dev.luka.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {

    private final int capacity;
    private final Map<Integer, ListNode> cache;
    private final ListNode dummyHead;
    private final ListNode dummyTail;
    public LRUCache_146(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.dummyHead = new ListNode(0, 0);
        this.dummyTail = new ListNode(0, 0);
        this.dummyHead.next = dummyTail;
        this.dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        ListNode node = cache.get(key);

        // After we get the val of node we need to update it to become the Most Recently Used node
        // by moving it to the head of linked list
        delete(node);
        insertToHead(node);

        return node.val;
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            node.val = val;

            // Make the node the Most Recently Used Node
            delete(node);
            insertToHead(node);
        } else {
            ListNode newNode = new ListNode(key, val);
            // Evict the Least Recently Used if reached capacity
            if (cache.size() == capacity) {
                cache.remove(dummyTail.prev.key);
                delete(dummyTail.prev);
            }
            // Add to cache
            cache.put(key, newNode);
            // Make the node becoming the Most Recently Used node
            insertToHead(newNode);
        }
    }

    private void delete(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void insertToHead(ListNode node) {
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache_146 LRUCache = new LRUCache_146(2);
        LRUCache.put(1, 1);
        LRUCache.put(2, 2);
        System.out.println(LRUCache.get(1)); // 1
        LRUCache.put(3,3);
        System.out.println(LRUCache.get(2)); // key 2 deleted, expect returning -1
        LRUCache.put(4, 4);
        System.out.println(LRUCache.get(1)); // key 1 deleted, expect returning -1
        System.out.println(LRUCache.get(3)); // 3
        System.out.println(LRUCache.get(4)); // 4
    }
}
