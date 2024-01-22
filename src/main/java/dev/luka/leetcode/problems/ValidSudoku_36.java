package dev.luka.leetcode.problems;

import java.util.*;

public class ValidSudoku_36 {

    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                String cur = String.valueOf(board[r][c]);
                if (!cur.equals(".")) {
                    if (!seen.add(cur + "r" + r) // check in row
                        || !seen.add(cur + "c" + c) // check in column
                        || !seen.add(cur + "b" + r/3 + c/3)) { // check in a specific box
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidSudoku_36 solution = new ValidSudoku_36();

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(solution.isValidSudoku(board)); // true
        board[0][0] = '8';
        System.out.println(solution.isValidSudoku(board)); // false
    }
}
