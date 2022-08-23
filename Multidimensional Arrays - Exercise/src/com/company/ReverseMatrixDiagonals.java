package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = arr[0];
        int cols = arr[1];
        int [][] matrix = new int[rows][cols];

        for (int row = 0; row < rws; row++) {
            int[] arr1 = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr1;
        }
        Map<Integer, List<Integer>> diagonals = new LinkedHashMap<>();
        for (int group = 0, diagonal = 0, row = rows - 1; row >= 0; row--, diagonal = ++group) {
            for (int col = cols - 1; col >= 0 && col >= group; col--, diagonal++) {
                addValueToDiagonal(diagonals, matrix[row][col], diagonal);
            }

            for (int r = rows - 1 - 1 - group; r >= 0 && group < cols; r--, diagonal++) {
                addValueToDiagonal(diagonals, matrix[r][group], diagonal);
            }
        }

        final StringBuilder sb = new StringBuilder();

        diagonals.values().forEach(numbers -> sb
                .append(numbers.stream().map(Object::toString).collect(Collectors.joining(" ")))
                .append(System.lineSeparator()));

        System.out.print(sb);
    }

    private static void addValueToDiagonal(Map<Integer, List<Integer>> diagonals, int value, int diagonal) {
        diagonals.putIfAbsent(diagonal, new ArrayList<>());
        diagonals.get(diagonal).add(value);
    }
}
