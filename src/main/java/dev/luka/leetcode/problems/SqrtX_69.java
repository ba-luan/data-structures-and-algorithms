package dev.luka.leetcode.problems;

public class SqrtX_69 {

    public static int mySqrt(int x) {
        // base cases
        if(x==0||x==1) return x;

        int left = 1;
        int right = x;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // condition (mid*mid > x) may cause int overflown => convert to (mid > x/mid)
            if (mid > x / mid) right = mid - 1;
            else if (mid < x / mid) {
                left = mid + 1;
                res = mid; // store the current mid as result, new mid in the next iter could yield mid^2 > x
            }
            else return mid; // this case is mid == x/mid
        }
        return res;
    }

    public static int mySqrtV2(int x) {
        // base cases
        if(x==0||x==1) return x;

        int left = 1, right = x;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) right = mid - 1;
            else {
                if (mid + 1 > x / (mid + 1)) return mid;
                left = mid + 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(9));
        System.out.println(mySqrtV2(0));
        System.out.println(mySqrtV2(1));
        System.out.println(mySqrtV2(8));
        System.out.println(mySqrtV2(9));
    }
}
