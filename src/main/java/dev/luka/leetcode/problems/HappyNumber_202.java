package dev.luka.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {

    public static boolean isHappyHashSet(int n) {
        Set<Integer> sums = new HashSet();
        int sumSquare;
        int remainder;
        while(sums.add(n)) {
            sumSquare = 0;
            while (n > 0) {
                remainder = n % 10;
                sumSquare += remainder * remainder;
                n /= 10;
            }
            if (sumSquare == 1) return true;
            else n = sumSquare;
        }
        return false;
    }

    // Two-pointer solution or Tortoise and Hare algorithm
    public static boolean isHappyTwoPointer(int n) {
        int slow = n;
        int fast = n;

        // initially slow = fast = n, so we have to execute the 1st iteration then go into the while loop
        do {
            slow = sumSquare(slow);
            fast = sumSquare(sumSquare(fast)); // fast pointer is 2 steps ahead slow pointer
        } while (slow != fast);

        // while loop breaks when slow == fast regardless their values
        // if slow == fast == 1 means there's no cycle when calculating sum of squares
        // if slow == fast != 1 means two pointers meet inside a cycle
        return slow == 1;
    }

    private static int sumSquare(int n) {
        int ans = 0;
        while (n > 0) {
            int remainder = n % 10;
            ans += remainder * remainder;
            n /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(isHappyHashSet(19)); // true
        System.out.println(isHappyHashSet(2)); // false

        System.out.println(isHappyTwoPointer(19)); // true
        System.out.println(isHappyTwoPointer(2)); // false
    }
}
