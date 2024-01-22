package dev.luka.leetcode.problems;

import java.util.Arrays;

public class RotateImage_48 {

    public void rotateByBorder(int[][] matrix) {
        int left = 0;
        int right = matrix.length - 1;

        while (left < right) {
            for (int i = 0; i < right - left; i++) {
                int top = left;
                int bottom = right;

                int topLeft = matrix[top][left + i];

                // move bottom left to top left
                matrix[top][left + i] = matrix[bottom - i][left];

                // move bottom right to bottom left
                matrix[bottom - i][left] = matrix[bottom][right - i];

                // move top right to bottom right
                matrix[bottom][right - i] = matrix[top + i][right];

                // move top left to top right
                matrix[top + i][right] = topLeft;
            }
            left++;
            right--;
        }
    }

    public void rotateByTranspose(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            // Reverse the elements in each row
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RotateImage_48 solution = new RotateImage_48();

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        solution.rotateByBorder(matrix);
        System.out.println("rotateByBorder:");
        printMatrix(matrix);

        solution.rotateByTranspose(matrix);
        System.out.println("Rotate again using rotateByTranspose:");
        printMatrix(matrix);
    }


}
