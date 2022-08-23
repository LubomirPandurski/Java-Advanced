package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        int[] diagonalOne = new int[n];
        int[] diagonalTwo = new int[n];
        for (int row = 0; row < n; row++) {
            int[] arr1 = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr1;
        }
        for (int i = 0; i < n; i++) {
                    diagonalOne[i] = matrix[i][i];

        }
        for (int i = 0; i < n ; i++) {
                diagonalTwo[i] = matrix[n - 1- i][i];
        }
        System.out.println(Arrays.toString(diagonalOne)
                .replace(",","")
                .replace("[", "")
                .replace("]", ""));
        System.out.println(Arrays.toString(diagonalTwo)
                .replace(",","")
                .replace("[", "")
                .replace("]", ""));
    }
}
