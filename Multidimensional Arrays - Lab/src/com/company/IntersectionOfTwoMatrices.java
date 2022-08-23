package com.company;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] firstMatrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] arr = scanner.nextLine().split("\\s+");
            firstMatrix[row] = arr;
        }

        String[][] secondMatrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] arr = scanner.nextLine().split("\\s+");
            secondMatrix[row] = arr;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            String[] firstArr = firstMatrix[row];
            String[] secondArr = secondMatrix[row];

            for (int col = 0; col < firstArr.length ; col++) {
                String firstElement = firstArr[col];
                String secondElement = secondArr[col];

                if (firstElement.equals(secondElement)){
                    System.out.print(firstElement + " ");
                }
                else{
                    System.out.print("*" + " ");
                }
            }
            System.out.println();
        }
    }
}
