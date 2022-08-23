package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = arr[0];
        int columns = arr[1];
        int [][] matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            int[] arr1 = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr1;
        }
        int bestSum = Integer.MIN_VALUE;
        int resultRow1 = 0;
        int resultRow2 = 0;
        int resultRow3 = 0;
        int resultRow4 = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if(sum>bestSum){
                    bestSum = sum;
                    resultRow1 = matrix[row][col];
                    resultRow2 = matrix[row][col + 1];
                    resultRow3 = matrix[row + 1][col];
                    resultRow4 = matrix[row + 1][col + 1];

                }
            }
        }
        System.out.println(resultRow1 + " " + resultRow2);
        System.out.println(resultRow3 + " " + resultRow4);
        System.out.println(bestSum);
    }
}
