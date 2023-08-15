package dev.luka.datastructure;

public class Matrix {
    private int rows;
    private int cols;
    private int[][] data;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getValue(int row, int col) {
        return data[row][col];
    }

    public void setValue(int row, int col, int value) {
        data[row][col] = value;
    }

    public Matrix add(Matrix other) {
        if (rows != other.getRows() || cols != other.getCols()) {
            throw new IllegalArgumentException("Matrix dimensions must match for addition");
        }

        Matrix result = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setValue(i, j, data[i][j] + other.getValue(i, j));
            }
        }

        return result;
    }

    public Matrix multiply(Matrix other) {
        if (cols != other.getRows()) {
            throw new IllegalArgumentException("Number of columns in the first matrix must match the number of rows in the second matrix");
        }

        Matrix result = new Matrix(rows, other.getCols());

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.getCols(); j++) {
                int sum = 0;
                for (int k = 0; k < cols; k++) {
                    sum += data[i][k] * other.getValue(k, j);
                }
                result.setValue(i, j, sum);
            }
        }

        return result;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Matrix A = new Matrix(2, 3);
        A.setValue(0, 0, 1);
        A.setValue(0, 1, 2);
        A.setValue(0, 2, 3);
        A.setValue(1, 0, 4);
        A.setValue(1, 1, 5);
        A.setValue(1, 2, 6);

        Matrix B = new Matrix(3, 2);
        B.setValue(0, 0, 7);
        B.setValue(0, 1, 8);
        B.setValue(1, 0, 9);
        B.setValue(1, 1, 10);
        B.setValue(2, 0, 11);
        B.setValue(2, 1, 12);

        System.out.println("Matrix A:");
        A.print();

        System.out.println("Matrix B:");
        B.print();

        Matrix C = A.multiply(B);
        System.out.println("Matrix C (A * B):");
        C.print();
    }
}

