package dev.luka.leetcode.problems;

public class ZigZagConversion_6 {

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder res = new StringBuilder();
        int len = s.length();
        for (int row = 0; row < numRows; row++) {
            int increment = (numRows - 1) * 2;
            for (int i = row; i < len; i += increment) { // i starts from row, not 0
                res.append(s.charAt(i)); // this works for the first and last row
                // add extra char if not first/last row
                int incrementMidRow = increment - row * 2; // change jump step of middle rows
                if (row > 0 && row < numRows - 1  && (i + incrementMidRow) < len) {
                    res.append(s.charAt(i + incrementMidRow));
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3)); // Output: "PAHNAPLSIIGYIR"
        System.out.println(convert("PAYPALISHIRING", 4)); // Output: "PINALSIGYAHRPI"
    }
}
