package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] conditions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int stackSize = conditions[0];
        int numbersToPop = conditions[1];
        int numberPresent = conditions[2];
        int [] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int number : numbers) {
            stack.push(number);
        }
        for (int i = 0; i < numbersToPop; i++) {
            stack.pop();
        }
        if(stack.contains(numberPresent)){
            System.out.println("true");
        }
        else if(stack.isEmpty()){
            System.out.println(0);
        }
        else{
            int temp = stack.pop();
            int smallest = Integer.MAX_VALUE;
            if(temp<smallest){
                smallest = temp;
            }
            System.out.println(smallest);
        }
    }
}
