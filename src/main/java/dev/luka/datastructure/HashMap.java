package dev.luka.datastructure;

import java.util.LinkedList;

class KeyValuePair<K, V> {
    K key;
    V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class HashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<KeyValuePair<K, V>>[] buckets;
    private int size;

    public HashMap() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<KeyValuePair<K, V>> bucket = buckets[index];
        for (KeyValuePair<K, V> pair : bucket) {
            if (pair.key.equals(key)) {
                pair.value = value;
                return;
            }
        }
        bucket.add(new KeyValuePair<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        LinkedList<KeyValuePair<K, V>> bucket = buckets[index];
        for (KeyValuePair<K, V> pair : bucket) {
            if (pair.key.equals(key)) {
                return pair.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<KeyValuePair<K, V>> bucket = buckets[index];
        for (KeyValuePair<K, V> pair : bucket) {
            if (pair.key.equals(key)) {
                bucket.remove(pair);
                size--;
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("Size: " + map.size());
        System.out.println("Value for key 'two': " + map.get("two"));

        map.remove("two");

        System.out.println("Size after removal: " + map.size());
        System.out.println("Is empty: " + map.isEmpty());
    }
}

