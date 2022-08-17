package com.company;


import java.util.Scanner;

public class StickyFingers {
    private static int row = 0;
    private static int col = 0;
    private static int moneyStolen = 0;
    private static boolean DillingerIsInField = true;
    private static boolean isPoliceHit = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][size];
        String [] command = scanner.nextLine().split(",");
        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            field[i] = line.toCharArray();

            if(line.contains("M")){
                row = i;
                col = line.indexOf("M");
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

         if(isPoliceHit){
             System.out.println("You got caught with " + moneyStolen + "&, and you are going to jail.");
         }
         else{
             System.out.println("Your last theft has finished successfully with " + moneyStolen + "$ in your pocket.");
         }
         printMatrix(field);
     }
 }


 private static void moveDillinger(char[][] field, int rowMutator, int colMutator) {
     int nextRow = row + rowMutator;
     int nextCol = col + colMutator;


     if(!isInField(field, nextRow, nextCol)){
         field[row][col] = 'D';
         System.out.println("You cannot leave the town, there is police outside!");

     }
     if(field[nextRow][nextCol] == 'P'){
         isPoliceHit = true;
         }
     else if(field[nextRow][nextCol] == '$'){
         moneyStolen = moneyStolen + (nextRow * nextCol);
         System.out.println("You successfully stole " + moneyStolen + " $.");
     }
     if(isPoliceHit){
         field[row][col] = '+';
         field[nextRow][nextCol] = '#';
         row = nextRow;
         col = nextCol;
     }
     else {
         field[row][col] = '+';
         field[nextRow][nextCol] = 'D';
         row = nextRow;
         col = nextCol;
     }
    }



 private static boolean isInField(char[][] field, int r, int c) {
     return r >= 0 && r < field.length && c >= 0 && c < field[r].length;

 }

 private static void printMatrix(char[][] field) {
        for(char[]arr : field){
            for(char c : arr){
                System.out.print(c);
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