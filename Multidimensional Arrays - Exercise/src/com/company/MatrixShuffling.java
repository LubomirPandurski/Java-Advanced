package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = data[0];
        int columns = data[1];
        String [][] matrix = new String[rows][columns];
        for (int row = 0; row < rows; row++) {
            String[] arr1 = scanner.nextLine().split(" ");
            matrix[row] = arr1;
        }
        String[] input = scanner.nextLine().split(" ");
        while(!input[0].equals("END")){
            if(input.length!=5){
                System.out.println("Invalid input!");
                input = scanner.nextLine().split(" ");
            }
            String command = input[0];
            int row1 = Integer.parseInt(input[1]);
            int col1 = Integer.parseInt(input[2]);
            int row2 = Integer.parseInt(input[3]);
            int col2 = Integer.parseInt(input[4]);
            String swap1 = "";
            String swap2 = "";
            if(command.equals("swap")){
                if(row1>=rows || row2>=rows || col1>=columns || col2>=columns){
                    System.out.println("Invalid input!");
                }
                else{
                    swap1 = matrix[row1][col1];
                    swap2 = matrix[row2][col2];
                    matrix[row1][col1] = swap2;
                    matrix[row2][col2] = swap1;
                    for (String [] arr : matrix) {
                        for(String n : arr){
                            System.out.print(n + " ");
                        }
                        System.out.println();
                    }
                }
            }
            input = scanner.nextLine().split(" ");
        }
    }
}
