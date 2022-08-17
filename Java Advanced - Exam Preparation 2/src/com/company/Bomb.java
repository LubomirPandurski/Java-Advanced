package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        char[][] matrix = new char[matrixSize][matrixSize];

        int sapperRow = 0;
        int sapperCol = 0;
        int bombCounter = 0;
        for (int i = 0; i < matrixSize; i++) {
            List<Character> characterList = Arrays.stream(scanner.nextLine().split(" "))
                    .map(e->e.charAt(0))
                    .collect(Collectors.toList());
            for (int j = 0; j < characterList.size(); j++) {
                char currentChar = characterList.get(j);
                if(currentChar == 's'){
                    sapperRow = i;
                    sapperCol = j;
                } else if(currentChar == 'B'){
                    bombCounter++;
                }
                matrix[i][j] = currentChar;
            }
        }

        int bombsFound = 0;

        for (int i = 0; i < commands.length; i++) {
            String commandName = commands[i];
            switch (commandName){
                case "up":
                    if(sapperRow!=0){
                        sapperRow--;
                    }
                    break;
                case "down":
                    if(sapperRow != matrixSize - 1){
                        sapperRow++;
                    }
                    break;
                case "right":
                    if(sapperCol != matrixSize - 1){
                        sapperCol++;
                    }
                    break;
                case "left":
                    if(sapperCol != 0){
                        sapperCol--;
                    }
                    break;
            }
            if(matrix[sapperRow][sapperCol] == 'B'){
                System.out.println("You found a bomb!");
                matrix[sapperRow][sapperCol] = '+';
                bombsFound++;
                if(bombsFound == bombCounter){
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if(matrix[sapperRow][sapperCol] == 'e'){
                System.out.printf("END! %d bombs left on the field", bombCounter - bombsFound);
                return;
            }
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombCounter - bombsFound, sapperRow, sapperCol);
    }
}
