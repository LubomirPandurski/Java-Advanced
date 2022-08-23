package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = arr[0];
        int colums = arr[1];
        int [][] matrix = new int[rows][colums];
        for (int row = 0; row < rows; row++) {
            int[] arr1 = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr1;
        }
        int sum = 0;
        System.out.println(rows);
        System.out.println(colums);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum+=matrix[row][col];
            }
        }
        System.out.println(sum);
    }
}
