package dev.luka.leetcode.problems;

public class CanPlaceFlowers_605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        for (int i = 0; i < flowerbed.length; i++) {
            // place a flower where there's 3 Zeros in a row.
            // if at start of array is a Zero, only need the next one is Zero.
            // if at end of array is a Zero, the previous one must be a zero.
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length - 1 || flowerbed[i+1] == 0)) {
                flowerbed[i] = 1;
                n--;
                if (n == 0) {
                    return true;
                }
            }
        }
        System.gc();
        return false;
    }

}
