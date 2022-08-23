package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            int[] arr1 = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr1;
        }
        int [] values = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int valueRow = values[0];
        int valueColumn = values[1];
        int valueReplace = matrix[values[0]][values[1]];
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == valueReplace){
                    if(row == 0 && col == 0){
                        sum = matrix[row][col+1] + matrix[row+1][col];
                    }
                    else if(row == 0 && col == matrix.length-1){
                        sum = matrix[row][col-1] + matrix[row+1][col];
                    }
                    else if(row==0 && col>0 && col< matrix.length - 1){
                        sum=matrix[row]
                    }
                    //sum = matrix[row - 1][col] + matrix[row][col+1] + matrix[row+1][col] + matrix[row][col-1];
                    System.out.print(sum + " ");
                }
                else{
                    System.out.print(matrix[row][col] + " ");
                }

            }
            System.out.println();
        }
        System.out.println(valueReplace);
    }
}
