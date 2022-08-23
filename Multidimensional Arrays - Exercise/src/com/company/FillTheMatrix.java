package com.company;

import java.util.Scanner;

public class FillTheMatrix {
    public static  int[][] patternA(int n){
        int[][] matrix = new int[n][n];
        int temp = 0;
        for (int col= 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                    matrix[row][col] = 1 + temp;
                    temp++;
            }
        }
        return matrix;
    }
    public static  int[][] patternB(int n){
        int[][] matrix = new int[n][n];
        int temp = 0;
        for (int col= 0; col < n; col++) {
            if(col%2==0){
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = 1 + temp;
                    temp++;
                }
            }
            else{
                for (int row = n - 1; row >= 0; row--) {
                    matrix[row][col] = 1 + temp;
                    temp++;
                }
            }
        }
        return matrix;
    }
    public static  void printMatrix(int[][] matrix){
        for (int [] arr : matrix) {
            for(int n : arr){
                System.out.print(n + " ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] data = scanner.nextLine().split(", ");
        int n = Integer.parseInt(data[0]);
        String pattern = data[1];
        if(pattern.equals("A"))
            printMatrix(patternA(n));
        else if(pattern.equals("B"))
            printMatrix(patternB(n));
    }
}
