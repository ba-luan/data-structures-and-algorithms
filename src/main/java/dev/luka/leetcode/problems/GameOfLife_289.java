package dev.luka.leetcode.problems;

public class GameOfLife_289 {

    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Original | New | State
        //     0    |  0  |   0
        //     1    |  0  |   1
        //     0    |  1  |   2
        //     1    |  1  |   3
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j);

                if (board[i][j] == 1) {
                    if (liveNeighbors  == 2 || liveNeighbors == 3) {
                        board[i][j] = 3;
                    }
                } else if (liveNeighbors == 3) {
                    board[i][j] = 2;
                }
            }
        }

        // Update the board with the next state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2 || board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    // Helper method to count live neighbors
    private static int countLiveNeighbors(int[][] board, int row, int col) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;

        // This method scans the 3x3 matrix from the center cell/number
        // checking min or max of row & col index for edge cases where we scan 3x3 matrix
        // where they are at the corners or borders of parent matrix
        for (int i = Math.max(0, row - 1); i <= Math.min(m - 1, row + 1); i++) {
            for (int j = Math.max(0, col - 1); j <= Math.min(n - 1, col + 1); j++) {
                if (!(i == row && j == col) && (board[i][j] == 1 || board[i][j] == 3)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        System.out.println("Original Board:");
        printBoard(board);

        gameOfLife(board);

        System.out.println("\nBoard after one update:");
        printBoard(board);
    }

}
