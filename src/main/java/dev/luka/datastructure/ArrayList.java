package dev.luka.datastructure;

public class ArrayList<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] array;
    private int size;

    public ArrayList() {
        array = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(T element) {
        if (size == array.length) {
            resizeArray();
        }
        array[size] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return (T) array[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resizeArray() {
        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("Size: " + list.size());
        System.out.println("Element at index 1: " + list.get(1));

        list.remove(1);

        System.out.println("Size after removal: " + list.size());
        System.out.println("Is empty: " + list.isEmpty());
    }
}

