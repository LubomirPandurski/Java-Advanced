package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static String[][] readMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = "" + (char)('a' + row) + (char)('a' + row + col) + (char)('a' + row);
            }

        }
        return matrix;
    }
    public static  void printMatrix(String[][] matrix){
        for (String [] arr : matrix) {
            for(String n : arr){
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        int[] data = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                                .toArray();
        int rows = data[0];
        int cols = data[1];
        printMatrix(readMatrix(rows,cols));
    }
}
