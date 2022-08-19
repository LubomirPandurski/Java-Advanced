package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] arr = scanner.nextLine().split("");
        ArrayDeque<String> left = new ArrayDeque<>();
        ArrayDeque<String> right = new ArrayDeque<>();
        int count = 0;
        if(arr.length%2==1){
            System.out.println("NO");
        }
        else{
            for(int i=(arr.length/2)-1; i>=0 ; i--){
                left.push(arr[i]);
            }
            for(int i = arr.length/2; i< arr.length ; i++){
                right.push(arr[i]);
            }
            for (int i = 0; i < arr.length/2; i++) {
                String tempLeft = left.pop();
                String tempRight = right.pop();
                if(tempLeft.equals("(") && !tempRight.equals(")")){
                    System.out.println("NO");
                    break;
                }
                else if(tempLeft.equals("[") && !tempRight.equals("]")){
                    System.out.println("NO");
                    break;
                }
                else if(tempLeft.equals("{") && !tempRight.equals("}")){
                    System.out.println("NO");
                    break;
                }
                count++;
                if(count == (arr.length/2) - 1) {
                    System.out.println("YES");
                }
            }
        }

    }
}
