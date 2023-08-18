package dev.luka.datastructure;

public class CustomString {
    private char[] data;

    public CustomString(String str) {
        data = str.toCharArray();
    }

    public int length() {
        return data.length;
    }

    public char charAt(int index) {
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return data[index];
    }

    public CustomString substring(int beginIndex, int endIndex) {
        if (beginIndex < 0 || endIndex > data.length || beginIndex > endIndex) {
            throw new IndexOutOfBoundsException("Invalid substring indices");
        }
        char[] subData = new char[endIndex - beginIndex];
        System.arraycopy(data, beginIndex, subData, 0, endIndex - beginIndex);
        return new CustomString(new String(subData));
    }

    public boolean equals(CustomString other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (this.length() != other.length()) {
            return false;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] != other.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public CustomString concat(CustomString other) {
        char[] newData = new char[data.length + other.length()];
        System.arraycopy(data, 0, newData, 0, data.length);
        System.arraycopy(other.data, 0, newData, data.length, other.data.length);
        return new CustomString(new String(newData));
    }

    public int indexOf(char c) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        return new String(data);
    }

    public static void main(String[] args) {
        CustomString str = new CustomString("Hello, world!");

        System.out.println("Length: " + str.length());
        System.out.println("Character at index 7: " + str.charAt(7));
        System.out.println("Substring from index 0 to 5: " + str.substring(0, 5));

        CustomString otherStr = new CustomString("Hello, world!");
        System.out.println("Are the strings equal? " + str.equals(otherStr));

        CustomString concatenated = str.concat(new CustomString(" Welcome!"));
        System.out.println("Concatenated: " + concatenated);

        System.out.println("Index of 'o': " + str.indexOf('o'));
    }
}

