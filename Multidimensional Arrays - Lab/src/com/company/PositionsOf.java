package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static  int[][] readMatrix(Scanner scanner){
        String [] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];


        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }
        return matrix;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int number = Integer.parseInt(scanner.nextLine());

        ArrayList<String> outputLines = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == number){
                    outputLines.add(row + " " + col);
                }
            }
        }
        String output = formatOutput(outputLines);

        System.out.println(output);
    }

    private static String formatOutput(ArrayList<String> outputLines) {
        if(outputLines.isEmpty()){
            return "not found";
        }

        return String.join(System.lineSeparator(), outputLines);
    }
}
