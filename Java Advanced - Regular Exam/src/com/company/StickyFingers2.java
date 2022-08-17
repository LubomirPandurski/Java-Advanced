package com.company;

import java.util.Scanner;

public class StickyFingers2 {
    private static int row = 0;
    private static int col = 0;
    private static int moneyStolen = 0;
    private static int totalMOneyStolen = 0;
    private static boolean isPoliceHit = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] field = new String[size][size];
        String [] command = scanner.nextLine().split(",");
        for (int row1 = 0; row1 < size; row1++) {
            String [] arr = scanner.nextLine().split(" ");
            for (int col1 = 0; col1 < size; col1++) {
                field[row1][col1] = arr[col1];
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(field[i][j].equals("D")){
                    row = i;
                    col = j;
                }
            }
        }

        for (String s : command) {
            if (isPoliceHit) {
                break;
            }
            if(s.equals("up")){
                moveDillinger(field,  -1, 0);
            } else if (s.equals("down")){
                moveDillinger(field,  1, 0);
            } else if (s.equals("left")){
                moveDillinger(field, 0,  - 1);
            } else if (s.equals("right")){
                moveDillinger(field, 0,  1);
            }

        }
        if(isPoliceHit){
            System.out.println("You got caught with " + totalMOneyStolen + "$, and you are going to jail.");
        }
        else{
            System.out.println("Your last theft has finished successfully with " + totalMOneyStolen + "$ in your pocket.");
        }
        printMatrix(field);
    }


    private static void moveDillinger(String[][] field, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;


        if(!isInField(field, nextRow, nextCol)){
            field[row][col] = "D";
            System.out.println("You cannot leave the town, there is police outside!");
            return;
        }
        else if(field[nextRow][nextCol].equals("P")){
            isPoliceHit = true;
        }
        else if(field[nextRow][nextCol].equals("$")){
            moneyStolen = (nextRow * nextCol);
            totalMOneyStolen +=moneyStolen;
            System.out.println("You successfully stole " + moneyStolen + "$.");
        }
        if(isPoliceHit){
            field[row][col] = "+";
            field[nextRow][nextCol] = "#";
            row = nextRow;
            col = nextCol;
        }
        else {
            field[row][col] = "+";
            field[nextRow][nextCol] = "D";
            row = nextRow;
            col = nextCol;
        }
    }



    private static boolean isInField(String[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;

    }

    private static void printMatrix(String[][] field) {
        for(String[]arr : field){
            int count = arr.length;
            for(String c : arr){
                if(count != 1 ){
                    System.out.print(c + " ");
                }
                else{
                    System.out.print(c);
                }
                count--;
            }
            System.out.println();
        }
    }
}

//5
//up,right,down,down,left
//+ + + D +
//+ + + P +
//+ + + $ +
//P + + P +
//+ + $ + +

//4
//right,down,down,left
//+ + D $
//+ + P $
//+ P $ +
//+ + + +