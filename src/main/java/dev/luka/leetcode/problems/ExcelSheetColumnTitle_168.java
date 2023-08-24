package dev.luka.leetcode.problems;

public class ExcelSheetColumnTitle_168 {

    public static String convertToTitle(int columnNumber) {
        String title = "";
        while (columnNumber > 0) {
            // we need to cast int to char, so we will add char 'A' in the operation
            // as a result, we must subtract 1 in each iteration to get correct char
            columnNumber--;
            // since title is the remainder of modulus operation, we have to concat it to the right, not the left.
            title = (char) (columnNumber % 26 + 'A') + title;
            columnNumber /= 26;
        }
        return title;
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(27));
    }

}
