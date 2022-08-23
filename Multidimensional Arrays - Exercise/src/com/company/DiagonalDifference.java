package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        int sum1 = 0;
        int sum2 = 0;
        for (int row = 0; row < n; row++) {
            int[] arr1 = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr1;
        }
        for (int i = 0; i < n; i++) {
            sum1 += matrix[i][i];
            sum2 += matrix[n - 1- i][i];
        }
        int diff = sum1 - sum2;
        System.out.println(Math.abs(diff));
    }
}
